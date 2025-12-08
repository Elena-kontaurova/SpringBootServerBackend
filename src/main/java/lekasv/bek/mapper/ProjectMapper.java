package lekasv.bek.mapper;

import lekasv.bek.dto.project.CreateProjectRequest;
import lekasv.bek.dto.project.ProjectResponse;
import lekasv.bek.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectResponse toProjectResponse(Project project);
    Project fromCreateProjectRequest(CreateProjectRequest createProjectRequest);
    void updateProjectResponse(ProjectResponse projectResponse,@MappingTarget Project project);
}
