package tn.esprit.adam_zahi_arctic10.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.adam_zahi_arctic10.entities.Project;
import tn.esprit.adam_zahi_arctic10.services.IProjectServices;

@RequestMapping("project")
@RestController
@RequiredArgsConstructor
public class ProjectRestController {
    private final IProjectServices projectServices;

    @PostMapping("add")
    public void addProject(@RequestBody Project project){
        projectServices.addProject(project);
    }
}
