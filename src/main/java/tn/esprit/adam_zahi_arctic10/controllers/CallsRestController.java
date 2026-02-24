package tn.esprit.adam_zahi_arctic10.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.adam_zahi_arctic10.entities.Calls;
import tn.esprit.adam_zahi_arctic10.services.ICallsServices;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("calls")
// http:://localhost:8082/api/calls
public class CallsRestController {
    private final ICallsServices callsServices;

    // http:://localhost:8082/api/calls/add
    @PostMapping("add")
    public Calls addCalls(@RequestBody Calls call){
        return callsServices.addCall(call);
    }

    // http:://localhost:8082/api/calls/update
    @PutMapping("update")
    public Calls updateCalls(@RequestBody Calls call){
        return callsServices.updateCall(call);
    }

    // http:://localhost:8082/api/calls/delete/{id}
    @DeleteMapping("delete/{id}")
    public void deleteCallsById(@PathVariable long id) {
        callsServices.deleteById(id);
    }

    // http:://localhost:8082/api/calls/get/{id}
    @GetMapping("get/{id}")
    public Calls getById(@PathVariable long id) {
        return callsServices.getById(id);
    }

    // http:://localhost:8082/api/calls/get
    @GetMapping("get")
    public List<Calls> getAllCalls(){
        return callsServices.getAll();
    }
}
