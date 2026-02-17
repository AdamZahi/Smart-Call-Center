package tn.esprit.adam_zahi_arctic10.services;

import tn.esprit.adam_zahi_arctic10.entities.Agent;
import tn.esprit.adam_zahi_arctic10.entities.Project;

import java.util.List;

public interface IProjectServices {

    // khedmet l CRUD

    List<Agent> getAgents(long projectId);
}
