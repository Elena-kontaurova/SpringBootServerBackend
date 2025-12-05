package lekasv.bek.service.api;

import jakarta.validation.Valid;
import lekasv.bek.dto.taskGroup.CreateTaskGroupRequest;
import lekasv.bek.dto.taskGroup.TaskGroupResponse;
import lekasv.bek.dto.taskGroup.UpdateTaskGroupRequest;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface TaskGroupService {
    List<TaskGroupResponse> getAllTaskGroups();
    List<TaskGroupResponse> getByName(String name);
    List<TaskGroupResponse> getByDescription(String description);
    List<TaskGroupResponse> getByTaskBoardId(Integer taskBoardId);
    TaskGroupResponse createTaskGroup(@Valid CreateTaskGroupRequest taskGroup);
    TaskGroupResponse updateTaskGroup(@Valid UpdateTaskGroupRequest taskGroup, Integer taskGroupId);
    void deleteTaskGroup(Integer taskGroupId);
}
