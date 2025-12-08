package lekasv.bek.controller;

import lekasv.bek.dto.project.CreateProjectRequest;
import lekasv.bek.dto.project.ProjectResponse;
import lekasv.bek.dto.project.UpdateProjectRequest;
import lekasv.bek.service.api.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/project")
@RestController
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping
    public List<ProjectResponse> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public ProjectResponse createProject(@RequestBody CreateProjectRequest project) {
        return projectService.createProject(project);
    }

    @PutMapping("/update/{projectId}")
    public ProjectResponse updateProject(@PathVariable Integer projectId, @RequestBody UpdateProjectRequest project) {
        return projectService.updateProject(project, projectId);
    }

    @DeleteMapping("/del/{projectId}")
    public void deleteProject(@PathVariable Integer projectId) {
        projectService.deleteProject(projectId);
    }
}
