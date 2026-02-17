package tn.esprit.adam_zahi_arctic10.services;

import tn.esprit.adam_zahi_arctic10.entities.Calls;

import java.util.List;

public interface ICallsServices {
    Calls addCall(Calls call);
    Calls updateCall(Calls call);
    void deleteById(long callId);
    void deleteCall(Calls call);
    Calls getById(long callId);
    List<Calls> getAll();
}
