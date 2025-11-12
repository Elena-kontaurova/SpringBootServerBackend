package lekasv.bek.mapper;

import lekasv.bek.dto.task.CreateTaskRequest;
import lekasv.bek.dto.task.TaskResponse;
import lekasv.bek.dto.task.UpdateTaskRequest;
import lekasv.bek.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.lang.annotation.Target;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task fromCreateTaskRequest(CreateTaskRequest request);
    void fromUpdateTaskRequest(UpdateTaskRequest request, @MappingTarget Task task);
    TaskResponse toTaskResponse(Task task);
}
