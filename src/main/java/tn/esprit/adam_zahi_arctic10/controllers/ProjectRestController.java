package tn.esprit.adam_zahi_arctic10.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("update")
    public void updateProject(@RequestBody Project project) {
        projectServices.updateProject(project);
    }

    @PostMapping("delete/{id}")
    public void deleteProjectById(@PathVariable long id) {
        projectServices.deleteProjectById(id);
    }

    @PostMapping("get")
    public void getAll() {
        projectServices.getAll();
    }

    @PostMapping("get/{id}")
    public Project getById(@PathVariable long id) {
        return projectServices.getProjectById(id);
    }
}
