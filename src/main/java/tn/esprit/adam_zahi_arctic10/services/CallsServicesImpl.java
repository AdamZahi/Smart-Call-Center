package tn.esprit.adam_zahi_arctic10.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.adam_zahi_arctic10.entities.Calls;
import tn.esprit.adam_zahi_arctic10.repositories.ICallsRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CallsServicesImpl implements ICallsServices{

    private final ICallsRepository callsRepository;

//    @Autowired
//    public void setCallsRepository(ICallsRepository callsRepository) {
//        this.callsRepository = callsRepository;
//    }

    @Override
    public Calls addCall(Calls call) {
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
    public void deleteCall(Calls call) {
        callsRepository.delete(call);
    }

    @Override
    public Calls getById(long id) {
        return callsRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Calls with id " + id + " not found"));
    }

    @Override
    public List<Calls> getAll() {
        return callsRepository.findAll();
    }
}
