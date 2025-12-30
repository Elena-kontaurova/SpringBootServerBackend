package lekasv.bek.controller;

import io.swagger.v3.oas.annotations.Parameter;
import lekasv.bek.dto.task.CreateTaskRequest;
import lekasv.bek.dto.task.TaskFullInfoResponse;
import lekasv.bek.dto.task.TaskResponse;
import lekasv.bek.dto.task.UpdateTaskRequest;
import lekasv.bek.enums.TaskStatucEnum;
import lekasv.bek.service.api.TaskService;
import lekasv.bek.service.impl.TaskFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    private final TaskFacade taskFacade;

    @GetMapping("/full-info/{taskId}")
    public TaskFullInfoResponse getTaskFullInfo(
            @Parameter(description = "ID задачи", required = true, example = "1")
            @PathVariable Integer taskId) {
        return taskFacade.getTaskFullInfo(taskId);
    }

    @GetMapping
    public List<TaskResponse> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/description/{description}")
    public List<TaskResponse> getByDescription(
            @Parameter(description = "Текст описания для поиска", required = true, example = "срочная задача")
            @PathVariable String description) {
        return taskService.getByDescription(description);
    }

    @GetMapping("/name/{name}")
    public List<TaskResponse> getByName(
            @Parameter(description = "Название задачи для поиска", required = true, example = "рефакторинг")
            @PathVariable String name) {
        return taskService.getByName(name);
    }

    @GetMapping("/status/{status}")
    public List<TaskResponse> getByStatus(
            @Parameter(description = "Статус задачи", required = true, example = "IN_PROGRESS")
            @PathVariable TaskStatucEnum status) {
        return taskService.getByStatus(status);
    }

    @GetMapping("/user/{userId}")
    public List<TaskResponse> getByUser(
            @Parameter(description = "ID пользователя", required = true, example = "5")
            @PathVariable Integer userId) {
        return taskService.getByUserId(userId);
    }

    @GetMapping("/group/{taskGroupId}")
    public List<TaskResponse> getByGroupTaskId(@PathVariable Integer taskGroupId) {
        return taskService.getByTaskGroupId(taskGroupId);
    }

    @PostMapping
    public TaskResponse create(@RequestBody CreateTaskRequest request) {
        return taskService.create(request);
    }

    @PutMapping("/update/{taskId}")
    public TaskResponse update(
            @Parameter(description = "ID задачи", required = true, example = "1")
            @PathVariable Integer taskId,
            @RequestBody UpdateTaskRequest request) {
        return taskService.update(taskId, request);
    }

    @DeleteMapping("/del/{taskId}")
    public void delete(
            @Parameter(description = "ID задачи", required = true, example = "1")
            @PathVariable Integer taskId) {
        taskService.deleteById(taskId);
    }

    @GetMapping("/taskParentId/{taskParentId}")
    public List<TaskResponse> getByParentTaskId(
            @Parameter(description = "ID родительской задачи", required = true, example = "10")
            @PathVariable Integer taskParentId) {
        return taskService.findByParentTaskId(taskParentId);
    }
}