package lekasv.bek.mapper;

import lekasv.bek.dto.taskBoard.CreateTaskBoardRequest;
import lekasv.bek.dto.taskBoard.TaskBoardProjectResponse;
import lekasv.bek.dto.taskBoard.TaskBoardResponse;
import lekasv.bek.model.TaskBoard;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskBoardMapper {
    TaskBoardResponse toTaskBoardResponse(TaskBoard taskBoard);
    TaskBoard fromCreateTaskBoardRequest(CreateTaskBoardRequest request);
    TaskBoardProjectResponse toTaskBoardProjectResponse(TaskBoard taskBoard);
}
