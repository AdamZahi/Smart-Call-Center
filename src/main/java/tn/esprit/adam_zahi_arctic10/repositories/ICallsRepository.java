package tn.esprit.adam_zahi_arctic10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.adam_zahi_arctic10.entities.*;

import java.util.List;

public interface ICallsRepository extends JpaRepository<Calls, Long> {
    @Query("SELECT COUNT(c) FROM Calls c WHERE c.assignedAiSystem = :aiSystem")
    long countByAssignedAiSystem(@Param("aiSystem") AISystem aiSystem);

    @Query("SELECT c FROM Calls c WHERE c.status = :status")
    List<Calls> findByStatus(@Param("status") CallStatus status);

    @Query("""
            SELECT c FROM Calls c
            JOIN c.assignedAgent a
            WHERE c.status = :status AND a.agentsId = :agentId
            """)
    List<Calls> findByStatusAndAssignedAgent_AgentsId(@Param("status") CallStatus status, @Param("agentId") long agentId);

    @Query("SELECT c FROM Calls c WHERE c.assignedAgent IS NULL")
    List<Calls> findByAssignedAgentIsNull();

    @Query("SELECT c FROM Calls c WHERE :skill MEMBER OF c.requiredSkills")
    List<Calls> findByRequiredSkillsContains(@Param("skill") CallSkills skill);

    @Query("""
            SELECT c FROM Calls c
            WHERE :skill MEMBER OF c.requiredSkills
              AND (
                  SELECT COUNT(c2) FROM Calls c2
                  WHERE :skill MEMBER OF c2.requiredSkills
                    AND (
                        c2.callsDateTime < c.callsDateTime
                        OR (c2.callsDateTime = c.callsDateTime AND c2.callsId <= c.callsId)
                    )
              ) <= 5
            ORDER BY c.callsDateTime ASC, c.callsId ASC
            """)
    List<Calls> findTop5ByRequiredSkillsContainsOrderByCallsDateTimeAsc(@Param("skill") CallSkills skill);

    @Query("SELECT (COUNT(c) > 0) FROM Calls c WHERE c.phoneNumber = :phoneNumber")
    boolean existsByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    @Query("SELECT COUNT(c) FROM Calls c WHERE c.status = :status")
    long countByStatus(@Param("status") CallStatus status);

    // Q1
    @Query("SELECT c FROM Calls c JOIN c.assignedAgent a WHERE a.agentsId = :idAgent")
    List<Calls> findCallsByAgent(@Param("idAgent") Long idAgent);

    // Q2
    @Query("SELECT c FROM Calls c WHERE :skill MEMBER OF c.requiredSkills")
    List<Calls> findCallsBySkill(@Param("skill") CallSkills skill);

    // Q5
    @Query("SELECT COUNT(c), c.status FROM Calls c GROUP BY c.status")
    List<Object[]> countCallsByStatus();

    // Q7
    @Query("SELECT c FROM Calls c WHERE FUNCTION('DATE', c.callsDateTime) = CURRENT_DATE")
    List<Calls> findTodayCalls();

}
