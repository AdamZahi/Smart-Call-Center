package tn.esprit.adam_zahi_arctic10.services;

import tn.esprit.adam_zahi_arctic10.entities.Agent;

import java.util.List;

public interface IAgentService {
    Agent addAgent(Agent agent);
    Agent updateAgent(Agent agent);
    void deleteById(long agentId);
    void deleteAgent(Agent agent);
    Agent getById(long agentId);
    List<Agent> getAll();
}
