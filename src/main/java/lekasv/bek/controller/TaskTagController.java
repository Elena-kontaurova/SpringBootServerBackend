package lekasv.bek.controller;

import io.swagger.v3.oas.annotations.Parameter;
import lekasv.bek.dto.taskTag.CreateTaskTagRequest;
import lekasv.bek.dto.taskTag.TaskTagResponse;
import lekasv.bek.service.api.TaskTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskTag")
@RequiredArgsConstructor
public class TaskTagController {
    private final TaskTagService taskTagService;

    @GetMapping
    public List<TaskTagResponse> getAll() {
        return taskTagService.getAll();
    }

    @PostMapping
    public TaskTagResponse create(@RequestBody CreateTaskTagRequest request) {
        return taskTagService.create(request);
    }

    @DeleteMapping("/{taskTagId}")
    public void delete(
            @Parameter(description = "ID связи задачи и тега", required = true, example = "1")
            @PathVariable Integer taskTagId) {
        taskTagService.delete(taskTagId);
    }
}