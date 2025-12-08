package lekasv.bek.service.impl;

import lekasv.bek.dto.project.CreateProjectRequest;
import lekasv.bek.dto.project.ProjectResponse;
import lekasv.bek.dto.project.UpdateProjectRequest;
import lekasv.bek.exception.extended.project.ProjectNotFoundException;
import lekasv.bek.mapper.ProjectMapper;
import lekasv.bek.model.Project;
import lekasv.bek.repository.ProjectRepository;
import lekasv.bek.service.api.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public List<ProjectResponse> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::toProjectResponse)
                .toList();
    }

    @Override
    public ProjectResponse createProject(CreateProjectRequest request) {
        Project project = projectMapper.fromCreateProjectRequest(request);
        projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(UpdateProjectRequest request, Integer projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
        project.setName(request.getName());
        projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void deleteProject(Integer projectId) {
        projectRepository.deleteById(projectId);
    }
}
