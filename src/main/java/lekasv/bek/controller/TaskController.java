package lekasv.bek.controller;

import lekasv.bek.dto.task.TaskResponse;
import lekasv.bek.enums.TaskStatucEnum;
import lekasv.bek.dto.task.CreateTaskRequest;
import lekasv.bek.dto.task.UpdateTaskRequest;
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
    public List<TaskResponse> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/description/{description}")
    public List<TaskResponse> getByDescription(@PathVariable String description) {
        return taskService.getByDescription(description);
    }

    @GetMapping("/name/{name}")
    public List<TaskResponse> getByName(@PathVariable String name) {
        return taskService.getByName(name);
    }

    @GetMapping("/status/{status}")
    public List<TaskResponse> getByStatus(@PathVariable TaskStatucEnum status) {
        return taskService.getByStatus(status);
    }

    @GetMapping("/user/{userId}")
    public List<TaskResponse> getByUser(@PathVariable Integer userId) {
        return taskService.getByUserId(userId);
    }

    @PostMapping
    public TaskResponse create(@RequestBody CreateTaskRequest request) {
        return taskService.create(request);
    }

    @PutMapping("/update/{task_id}")
    public TaskResponse update(@PathVariable Integer task_id, @RequestBody UpdateTaskRequest request) {
        return taskService.update(task_id, request);
    }

    @DeleteMapping("/del/{task_id}")
    public void delete(@PathVariable Integer task_id) {
        taskService.deleteById(task_id);
    }
}
