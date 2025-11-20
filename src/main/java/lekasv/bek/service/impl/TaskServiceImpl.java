package lekasv.bek.service.impl;

import lekasv.bek.dto.task.CreateTaskRequest;
import lekasv.bek.dto.task.TaskResponse;
import lekasv.bek.dto.task.UpdateTaskRequest;
import lekasv.bek.enums.TaskStatucEnum;
import lekasv.bek.exception.extended.task.TaskNotFoundException;
import lekasv.bek.mapper.TaskMapper;
import lekasv.bek.model.Task;
import lekasv.bek.repository.TaskRepository;
import lekasv.bek.service.api.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public List<TaskResponse> getAll() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toTaskResponse)
                .toList();
    }

    @Override
    public List<TaskResponse> getByDescription(String description) {
        return taskRepository.findByDescription(description)
                .stream()
                .map(taskMapper::toTaskResponse)
                .toList();
    }

    @Override
    public List<TaskResponse> getByName(String name) {
        return taskRepository.findByName(name)
                .stream()
                .map(taskMapper::toTaskResponse)
                .toList();
    }

    @Override
    public List<TaskResponse> getByStatus(TaskStatucEnum status) {
        return taskRepository.findByStatus(status)
                .stream()
                .map(taskMapper::toTaskResponse)
                .toList();
    }

    @Override
    public List<TaskResponse> getByUserId(Integer userId) {
        return taskRepository.findByUserId(userId)
                .stream()
                .map(taskMapper::toTaskResponse)
                .toList();
    }

    @Override
    public TaskResponse create(CreateTaskRequest request) {
        Task task = taskMapper.fromCreateTaskRequest(request);
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        taskRepository.save(task);
        return taskMapper.toTaskResponse(task);
    }

    @Override
    public TaskResponse update(Integer taskId, UpdateTaskRequest request) {
        Task tasks = taskRepository.findById(taskId)
                .orElseThrow(TaskNotFoundException::new);
        taskMapper.fromUpdateTaskRequest(request, tasks);
        tasks.setUpdatedAt(LocalDateTime.now());
        taskRepository.save(tasks);
        return taskMapper.toTaskResponse(tasks);
    }

    @Override
    public void deleteById(Integer taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public List<TaskResponse> findByParentTaskId(Integer parentTaskId) {
        return taskRepository.findByParentTaskId(parentTaskId)
                .stream()
                .map(taskMapper::toTaskResponse)
                .toList();
    }
}
