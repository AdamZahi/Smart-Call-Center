package tn.esprit.adam_zahi_arctic10.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.adam_zahi_arctic10.entities.AISystem;
import tn.esprit.adam_zahi_arctic10.services.IIASystemService;

@RequestMapping("ai-system")
@RestController
@RequiredArgsConstructor
public class AISystemRestController {
    private final IIASystemService aiSystemService;

    @PostMapping("add")
    public void addAISystem(@RequestBody AISystem aiSystem) {
        aiSystemService.addAISystem(aiSystem);
    }

    @PostMapping("update")
    public void updateAISystem(@RequestBody AISystem aiSystem) {
        aiSystemService.updateAISystem(aiSystem);
    }

    @PostMapping("delete/{id}")
    public void deleteAISystemById(@PathVariable long id) {
        aiSystemService.deleteById(id);
    }

    @PostMapping("get/{id}")
    public AISystem getAISystemById(@PathVariable long id) {
        return aiSystemService.getById(id);
    }

    @PostMapping("get")
    public void getAll() {
        aiSystemService.getAll();
    }
}
