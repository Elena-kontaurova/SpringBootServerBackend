package lekasv.bek.mapper;

import lekasv.bek.dto.taskGroup.CreateTaskGroupRequest;
import lekasv.bek.dto.taskGroup.TaskGroupResponse;
import lekasv.bek.dto.taskGroup.UpdateTaskGroupRequest;
import lekasv.bek.model.TaskGroup;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TaskGroupMapper {
    TaskGroupResponse toTaskGroupResponse(TaskGroup taskGroup);
    TaskGroup fromCreateTaskGroupRequest(CreateTaskGroupRequest request);
    void fromUpdateTaskGroupRequest(UpdateTaskGroupRequest request, @MappingTarget TaskGroup taskGroup);
}
