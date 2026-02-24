package tn.esprit.adam_zahi_arctic10.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.adam_zahi_arctic10.entities.Calls;
import tn.esprit.adam_zahi_arctic10.services.ICallsServices;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("calls")
public class CallsRestController {
    private final ICallsServices callsServices;

    @PostMapping("add")
    public Calls addCalls(@RequestBody Calls call){
        return callsServices.addCall(call);
    }

    @PutMapping("update")
    public Calls updateCalls(@RequestBody Calls call){
        return callsServices.updateCall(call);
    }

    @DeleteMapping("delete/{id}")
    public void deleteCallsById(@PathVariable long id) {
        callsServices.deleteById(id);
    }

    @GetMapping("get/{id}")
    public Calls getById(@PathVariable long id) {
        return callsServices.getById(id);
    }

    @GetMapping("get")
    public List<Calls> getAllCalls(){
        return callsServices.getAll();
    }
}
