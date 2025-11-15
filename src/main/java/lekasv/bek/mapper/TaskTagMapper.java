package lekasv.bek.mapper;

import lekasv.bek.dto.taskTag.CreateTaskTagRequest;
import lekasv.bek.dto.taskTag.TaskTagResponse;
import lekasv.bek.model.TaskTag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskTagMapper {
    TaskTagResponse toTaskTagResponse(TaskTag taskTag);
    TaskTag fromCreateTaskTagRequest(CreateTaskTagRequest createTaskTagRequest);
}
