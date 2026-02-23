package tn.esprit.adam_zahi_arctic10.services;

import tn.esprit.adam_zahi_arctic10.entities.Agent;
import tn.esprit.adam_zahi_arctic10.entities.Calls;
import tn.esprit.adam_zahi_arctic10.entities.Project;

import java.util.List;

public interface IProjectServices {

    // khedmet l CRUD
    Project addProject(Project project);
    Project updateProject(Project project);
    void deleteProjectById(long id);
    void deleteProject(Project project);
    Project getProjectById(long id);
    List<Project> getAll();

    List<Agent> getAgents(long projectId);
}
