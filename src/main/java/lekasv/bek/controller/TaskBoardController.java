package lekasv.bek.controller;

import lekasv.bek.dto.taskBoard.CreateTaskBoardRequest;
import lekasv.bek.dto.taskBoard.TaskBoardFullInfoResponse;
import lekasv.bek.dto.taskBoard.TaskBoardProjectResponse;
import lekasv.bek.dto.taskBoard.TaskBoardResponse;
import lekasv.bek.dto.taskGroup.UpdateTaskGroupRequest;
import lekasv.bek.service.api.TaskBoardService;
import lekasv.bek.service.impl.TaskBoardFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/taskBoard")
public class TaskBoardController {
    private final TaskBoardService taskBoardService;
    private final TaskBoardFacade taskBoardFacade;

    @GetMapping("/full-info/{taskBoardId}")
    public TaskBoardFullInfoResponse getTaskBoardFullInfo(@PathVariable Integer taskBoardId) {
        return taskBoardFacade.getTaskBoardFullInfo(taskBoardId);
    }

    @GetMapping("/project/{projectId}")
    public List<TaskBoardProjectResponse> getByProjectId(@PathVariable Integer projectId) {
        return taskBoardService.getByProjectId(projectId);
    }

    @GetMapping
    public List<TaskBoardResponse> getTaskBoard() {
        return taskBoardService.getAllTaskBoards();
    }

    @GetMapping("/{name}")
    public TaskBoardResponse getTaskBoardByName(@PathVariable String name) {
        return taskBoardService.getByName(name);
    }

    @PostMapping
    public TaskBoardResponse createTaskGroup(@RequestBody CreateTaskBoardRequest board) {
        return taskBoardService.createTaskBoard(board);
    }

    @PutMapping("/update/{taskBoardId}")
    public TaskBoardResponse updateTaskBoard(@PathVariable Integer taskBoardId, @RequestBody UpdateTaskGroupRequest board) {
        return taskBoardService.updateTaskBoard(board, taskBoardId);
    }

    @DeleteMapping("/del/{taskBoardId}")
    public void deleteTaskBoard(@PathVariable Integer taskBoardId) {
        taskBoardService.deleteTaskBoard(taskBoardId);
    }
}
