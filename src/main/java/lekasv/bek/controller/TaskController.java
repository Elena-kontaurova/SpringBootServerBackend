package lekasv.bek.controller;

import lekasv.bek.Enum.TaskStatucEnum;
import lekasv.bek.model.Task;
import lekasv.bek.service.api.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/description/{description}")
    public List<Task> getByDescription(@PathVariable String description) {
        return taskService.getByDescription(description);
    }

    @GetMapping("/name/{name}")
    public List<Task> getByName(@PathVariable String name) {
        return taskService.getByName(name);
    }

    @GetMapping("/status/{status}")
    public List<Task> getByStatus(@PathVariable TaskStatucEnum status) {
        return taskService.getByStatus(status);
    }

    @GetMapping("/user/{userId}")
    public List<Task> getByUser(@PathVariable Integer userId) {
        return taskService.getByUserId(userId);
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        return taskService.create(task);
    }

    @PutMapping("/update/{task_id}")
    public Task update(@PathVariable Integer task_id, @RequestBody Task task) {
        return taskService.update(task_id, task);
    }

    @DeleteMapping("/del/{task_id}")
    public void delete(@PathVariable Integer task_id) {
        taskService.deleteById(task_id);
    }
}
