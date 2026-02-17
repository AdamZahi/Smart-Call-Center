package tn.esprit.adam_zahi_arctic10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.adam_zahi_arctic10.entities.ProjectDetails;

public interface IProjectDetailsRepository extends JpaRepository<ProjectDetails, Long> {
}
