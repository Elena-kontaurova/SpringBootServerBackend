package lekasv.bek.mapper;

import lekasv.bek.dto.taskBoard.CreateTaskBoardRequest;
import lekasv.bek.dto.taskBoard.TaskBoardResponse;
import lekasv.bek.dto.taskBoard.UpdateTaskBoardRequest;
import lekasv.bek.model.TaskBoard;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TaskBoardMapper {
    TaskBoardResponse toTaskBoardResponse(TaskBoard taskBoard);
    TaskBoard fromCreateTaskBoardRequest(CreateTaskBoardRequest request);
    void fromUpdateTaskBoardRequest(UpdateTaskBoardRequest request, @MappingTarget TaskBoard taskBoard);
}
