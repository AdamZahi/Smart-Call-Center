package tn.esprit.adam_zahi_arctic10.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.adam_zahi_arctic10.entities.Calls;
import tn.esprit.adam_zahi_arctic10.services.CallsServicesImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("calls")
public class CallsRestController {
    private final CallsServicesImpl callsServices;

    @PostMapping("add")
    public Calls addCalls(@RequestBody Calls call){
        return callsServices.addCall(call);
    }
}
