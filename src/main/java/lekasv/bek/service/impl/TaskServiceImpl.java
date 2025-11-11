package lekasv.bek.service.impl;

import lekasv.bek.Enum.TaskStatucEnum;
import lekasv.bek.model.Task;
import lekasv.bek.repository.TaskRepository;
import lekasv.bek.service.api.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getByDescription(String description) {
        return taskRepository.findByDescription(description);
    }

    @Override
    public List<Task> getByName(String name) {
        return taskRepository.findByName(name);
    }

    @Override
    public List<Task> getByStatus(TaskStatucEnum status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public List<Task> getByUserId(Integer userId) {
        return taskRepository.findByUserId(userId);
    }

    @Override
    public Task create(Task task) {
        if (task.getName() == null || task.getName().isEmpty()) {
            throw new IllegalArgumentException("Task name is null");
        }
        if (task.getDescription() == null || task.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Task description is null");
        }
        if (task.getStatus() == null) {
            throw new IllegalArgumentException("Task status is null");
        }
        if (task.getUser() == null) {
            throw new IllegalArgumentException("Task user is null");
        }
        return taskRepository.save(task);
    }

    @Override
    public Task update(Integer task_id, Task task) {
        if (task.getName() == null || task.getName().isEmpty()) {
            throw new IllegalArgumentException("Task name is null");
        }
        if (task.getDescription() == null || task.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Task description is null");
        }
        if (task.getStatus() == null) {
            throw new IllegalArgumentException("Task status is null");
        }
        if (task.getUser() == null) {
            throw new IllegalArgumentException("Task user is null");
        }
        Task tasks = taskRepository.findById(task_id).get();
        tasks.setName(task.getName());
        tasks.setDescription(task.getDescription());
        tasks.setStatus(task.getStatus());
        tasks.setUser(task.getUser());
        return taskRepository.save(tasks);
    }

    @Override
    public void deleteById(Integer task_id) {
        taskRepository.deleteById(task_id);
    }
}
