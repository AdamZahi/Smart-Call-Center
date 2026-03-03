package tn.esprit.adam_zahi_arctic10.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.adam_zahi_arctic10.entities.ProjectDetails;
import tn.esprit.adam_zahi_arctic10.services.IProjectDetailsService;

@RequestMapping("project-details")
@RestController
@RequiredArgsConstructor
public class ProjectDetailsRestController {
    private final IProjectDetailsService projectDetailsService;

    @PostMapping("add")
    public void addProjectDetails(@RequestBody ProjectDetails projectDetails) {
        projectDetailsService.addProjectDetails(projectDetails);
    }

    @PostMapping("update")
    public void updateProjectDetails(@RequestBody ProjectDetails projectDetails) {
        projectDetailsService.updateProjectDetails(projectDetails);
    }

    @PostMapping("delete/{id}")
    public void deleteProjectDetailsById(@PathVariable long id) {
        projectDetailsService.deleteById(id);
    }

    @PostMapping("get")
    public void getAll() {
        projectDetailsService.getAll();
    }

    @PostMapping("get/{id}")
    public ProjectDetails getById(@PathVariable long id) {
        return projectDetailsService.getById(id);
    }
}
