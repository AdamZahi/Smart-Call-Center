package tn.esprit.adam_zahi_arctic10.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.adam_zahi_arctic10.entities.Agent;
import tn.esprit.adam_zahi_arctic10.services.IAgentService;

@RequestMapping("agent")
@RestController
@RequiredArgsConstructor
public class AgentRestController {
    private final IAgentService agentService;

    @PostMapping("add")
    public void addAgent(@RequestBody Agent agent) {
        agentService.addAgent(agent);
    }

    @PostMapping("update")
    public void updateAgent(@RequestBody Agent agent) {
        agentService.updateAgent(agent);
    }

    @PostMapping("delete/{id}")
    public void deleteAgentById(@PathVariable long id) {
        agentService.deleteById(id);
    }

    @PostMapping("get/{id}")
    public Agent getAgentById(@PathVariable long id) {
        return agentService.getById(id);
    }

    @PostMapping("get")
    public void getAll() {
        agentService.getAll();
    }

}
