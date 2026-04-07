package tn.esprit.adam_zahi_arctic10.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.adam_zahi_arctic10.entities.Project;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    @Mapping(source = "libelle", target = "projectName")
    @Mapping(source = "projectDetails.client", target = "projectName")
    @Mapping(source = "projectsId", target = "projectId")
    ProjectsDTO toDTO(Project project);
}
