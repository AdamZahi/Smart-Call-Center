package tn.esprit.adam_zahi_arctic10.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.adam_zahi_arctic10.entities.Agent;
import tn.esprit.adam_zahi_arctic10.entities.CallStatus;
import tn.esprit.adam_zahi_arctic10.entities.Calls;
import tn.esprit.adam_zahi_arctic10.repositories.IAgentRepository;
import tn.esprit.adam_zahi_arctic10.repositories.ICallsRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CallsServicesImpl implements ICallsServices{

    private final ICallsRepository callsRepository;
    private final IAgentRepository agentRepository;

//    @Autowired
//    public void setCallsRepository(ICallsRepository callsRepository) {
//        this.callsRepository = callsRepository;
//    }

    @Override
    public Calls addCall(Calls call) {
        call.setCallsDateTime(java.time.LocalDateTime.now());
        call.setStatus(CallStatus.ON_HOLD);
        return callsRepository.save(call);
    }

    @Override
    public Calls updateCall(Calls call) {
        return callsRepository.save(call);
    }

    @Override
    public void deleteById(long id) {
        callsRepository.deleteById(id);
    }

    @Override
    public Calls getById(long id) {
        return callsRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Calls with id " + id + " not found"));
    }

    @Override
    public List<Calls> getAll() {
        return callsRepository.findAll();
    }

    @Override
    public Calls assignedToAgent(long callId, long agentId) {
        Calls call = callsRepository.findById(callId).orElseThrow(()->new EntityNotFoundException("call with the id "+callId+" not found"));
        Agent agent = agentRepository.findById(agentId).orElseThrow(()->new EntityNotFoundException("agent with the id "+agentId+" not found"));
        if(!agent.isAvailable()){
            throw new IllegalStateException("agent with the id "+agentId+" is not available");
        }
        if (agent.isAvailable() && agent != null) {
            call.setAssignedAgent(agent); //affectation
            agent.setAvailable(false); //agent n'est plus disponible
            call.setStatus(CallStatus.IN_PROGRESS); //le status de l'appel devient en cours
            agentRepository.save(agent); //sauvegarder les modifications de l'agent
        }

        return callsRepository.save(call);
    }

    @Override
    public Calls assignedToAgent(Calls call, long agentId) {
            Agent agent = agentRepository.findById(agentId).orElseThrow(()->new EntityNotFoundException("agent with the id "+agentId+" not found"));
            call.setAssignedAgent(agent);
        return callsRepository.save(call);
    }
}
