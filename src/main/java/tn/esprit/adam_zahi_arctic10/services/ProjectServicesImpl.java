package tn.esprit.adam_zahi_arctic10.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.adam_zahi_arctic10.entities.Agent;
import tn.esprit.adam_zahi_arctic10.entities.Project;
import tn.esprit.adam_zahi_arctic10.repositories.IAgentRepository;
import tn.esprit.adam_zahi_arctic10.repositories.IProjectRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServicesImpl implements IProjectServices{

    private final IProjectRepository projectRepository;

    @Override
    public List<Agent> getAgents(long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(()->new EntityNotFoundException("Project with id "+projectId+" not found"));
        return project.getAgents().stream().toList();
    }
}
