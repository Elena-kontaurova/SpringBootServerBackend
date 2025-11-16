package lekasv.bek.service.impl;

import lekasv.bek.dto.task.CreateTaskRequest;
import lekasv.bek.dto.task.TaskResponse;
import lekasv.bek.dto.task.UpdateTaskRequest;
import lekasv.bek.enums.TaskStatucEnum;
import lekasv.bek.mapper.TaskMapper;
import lekasv.bek.model.Task;
import lekasv.bek.repository.TaskRepository;
import lekasv.bek.repository.UserRepository;
import lekasv.bek.service.api.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
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
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new IllegalArgumentException("Task name is null");
        }
        if (request.getDescription() == null || request.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Task description is null");
        }
        if (request.getStatus() == null) {
            throw new IllegalArgumentException("Task status is null");
        }
        if (request.getUserId() == null) {
            throw new IllegalArgumentException("Task user is null");
        }
        if (!userRepository.existsById(request.getUserId())) {
            throw new IllegalArgumentException("User not found");
        }
        Task task = taskMapper.fromCreateTaskRequest(request);
        taskRepository.save(task);
        return taskMapper.toTaskResponse(task);
    }

    @Override
    public TaskResponse update(Integer task_id, UpdateTaskRequest request) {
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new IllegalArgumentException("Task name is null");
        }
        if (request.getDescription() == null || request.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Task description is null");
        }
        if (request.getStatus() == null) {
            throw new IllegalArgumentException("Task status is null");
        }
        if (request.getUserId() == null) {
            throw new IllegalArgumentException("Task user is null");
        }
        if (!userRepository.existsById(request.getUserId())) {
            throw new IllegalArgumentException("User not found");
        }
        Task tasks = taskRepository.findById(task_id).get();
        taskMapper.fromUpdateTaskRequest(request, tasks);
        taskRepository.save(tasks);
        return taskMapper.toTaskResponse(tasks);
    }

    @Override
    public void deleteById(Integer task_id) {
        taskRepository.deleteById(task_id);
    }
}
