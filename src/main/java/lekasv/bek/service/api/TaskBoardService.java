package lekasv.bek.service.api;

import jakarta.validation.Valid;
import lekasv.bek.dto.taskBoard.CreateTaskBoardRequest;
import lekasv.bek.dto.taskBoard.TaskBoardProjectResponse;
import lekasv.bek.dto.taskBoard.TaskBoardResponse;
import lekasv.bek.dto.taskGroup.UpdateTaskGroupRequest;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface TaskBoardService {
    List<TaskBoardResponse> getAllTaskBoards();
    List<TaskBoardProjectResponse> getByProjectId(Integer projectId);
    TaskBoardResponse getByName(@Valid String name);
    TaskBoardResponse createTaskBoard(CreateTaskBoardRequest board);
    TaskBoardResponse updateTaskBoard(UpdateTaskGroupRequest board, Integer taskBoardId);
    void deleteTaskBoard(Integer taskBoardId);
}
