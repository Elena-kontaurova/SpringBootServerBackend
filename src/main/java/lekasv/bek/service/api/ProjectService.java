package lekasv.bek.service.api;

import jakarta.validation.Valid;
import lekasv.bek.dto.project.CreateProjectRequest;
import lekasv.bek.dto.project.ProjectResponse;
import lekasv.bek.dto.project.UpdateProjectRequest;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface ProjectService {
    List<ProjectResponse> getAllProjects();
    ProjectResponse createProject(@Valid CreateProjectRequest request);
    ProjectResponse updateProject(@Valid UpdateProjectRequest request, Integer projectId);
    void deleteProject(Integer projectId);
}
