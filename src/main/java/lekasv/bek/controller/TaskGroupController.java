package lekasv.bek.controller;

import lekasv.bek.dto.taskGroup.CreateTaskGroupRequest;
import lekasv.bek.dto.taskGroup.TaskGroupResponse;
import lekasv.bek.dto.taskGroup.UpdateTaskGroupRequest;
import lekasv.bek.service.api.TaskGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/taskGroup")
@RestController
public class TaskGroupController {
    private final TaskGroupService taskGroupService;

    @GetMapping
    public List<TaskGroupResponse> getAll() {
        return taskGroupService.getAllTaskGroups();
    }

    @GetMapping("/name/{name}")
    public List<TaskGroupResponse> getByName(@PathVariable String name) {
        return taskGroupService.getByName(name);
    }

    @GetMapping("/description/{description}")
    public List<TaskGroupResponse> getByDescription(@PathVariable String description) {
        return taskGroupService.getByDescription(description);
    }

    @GetMapping("/board/{taskBoardId}")
    public List<TaskGroupResponse> getByTaskBoardId(@PathVariable Integer taskBoardId) {
        return taskGroupService.getByTaskBoardId(taskBoardId);
    }

    @PostMapping
    public TaskGroupResponse createTaskGroup(@RequestBody CreateTaskGroupRequest taskGroup) {
        return taskGroupService.createTaskGroup(taskGroup);
    }

    @PutMapping("/{taskGroupId}")
    public TaskGroupResponse updateTaskGroup(@RequestBody UpdateTaskGroupRequest taskGroup, @PathVariable Integer taskGroupId) {
        return taskGroupService.updateTaskGroup(taskGroup, taskGroupId);
    }

    @DeleteMapping("/del/{taskGroupId}")
    public void deleteTaskGroup(@PathVariable Integer taskGroupId) {
        taskGroupService.deleteTaskGroup(taskGroupId);
    }
}
