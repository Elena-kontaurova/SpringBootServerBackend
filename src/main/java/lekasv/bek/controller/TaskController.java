package lekasv.bek.controller;

import lekasv.bek.Enum.TaskStatucEnum;
import lekasv.bek.model.Task;
import lekasv.bek.model.User;
import lekasv.bek.repository.RoleRepository;
import lekasv.bek.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskRepository taskRepository;
    @GetMapping
    public List<Task> findAll() {
        return taskRepository.findAll();
    }
    @GetMapping("/description/{description}")
    public List<Task> findByDescription(@PathVariable String description) {
        return taskRepository.findByDescription(description);
    }
    @GetMapping("/name/{name}")
    public List<Task> findByName(@PathVariable String name) {
        return taskRepository.findByName(name);
    }
    @GetMapping("/status/{status}")
    public List<Task> findByStatus(@PathVariable TaskStatucEnum status) {
        return taskRepository.findByStatus(status);
    }
    @GetMapping("/user/{userId}")
    public List<Task> findByUser(@PathVariable Integer userId) {
        return taskRepository.findByUserId(userId);
    }

    @PostMapping
    public Task save(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @PutMapping("/update/{task_id}")
    public Task update(@PathVariable Integer task_id, @RequestBody Task task) {
        Task tasks = taskRepository.findById(task_id).get();
        tasks.setName(task.getName());
        tasks.setDescription(task.getDescription());
        tasks.setStatus(task.getStatus());
        tasks.setUser(task.getUser());
        return taskRepository.save(tasks);
    }

    @DeleteMapping("/del/{tast_id}")
    public void delete(@PathVariable Integer tast_id) {
        taskRepository.deleteById(tast_id);
    }
}
