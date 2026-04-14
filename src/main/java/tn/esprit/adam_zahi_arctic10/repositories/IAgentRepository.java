package tn.esprit.adam_zahi_arctic10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.adam_zahi_arctic10.entities.Agent;
import tn.esprit.adam_zahi_arctic10.entities.CallSkills;

import java.util.List;

public interface IAgentRepository extends JpaRepository<Agent, Long> {

	// Q3
	@Query("SELECT a FROM Agent a WHERE :skill MEMBER OF a.skills")
	List<Agent> findAgentsBySkill(@Param("skill") CallSkills skill);

	// Q4
	@Query("""
			SELECT a FROM Agent a
			WHERE a.available = true
			AND (SELECT COUNT(s) FROM Calls c JOIN c.requiredSkills s WHERE c.callsId = :callsId AND s MEMBER OF a.skills) 
						= ( SELECT MAX(
					   			( SELECT COUNT(s2)  FROM Calls c2 JOIN c2.requiredSkills s2 WHERE c2.callsId = :callsId AND s2 MEMBER OF aMax.skills )
							)
				    FROM Agent aMax WHERE aMax.available = true
			    )
			    AND a.agentsId = ( SELECT MIN(aTie.agentsId) FROM Agent aTie WHERE aTie.available = true AND 
			    	( SELECT COUNT(s3) FROM Calls c3 JOIN c3.requiredSkills s3 WHERE c3.callsId = :callsId AND s3 MEMBER OF aTie.skills) 
			    	= ( SELECT COUNT(s4) FROM Calls c4 JOIN c4.requiredSkills s4 WHERE c4.callsId = :callsId AND s4 MEMBER OF a.skills )
			  		)
			""")
	Agent findMostCompetentAgentForCall(@Param("callsId") Long callsId);

	// Q6
	@Query("""
			SELECT a.name, COUNT(c)
			FROM Agent a JOIN a.calls c
			GROUP BY a.agentsId, a.name
			HAVING COUNT(c) > 5
			""")
	List<Object[]> findTopActiveAgents();
}
