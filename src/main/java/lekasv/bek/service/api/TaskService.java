package lekasv.bek.service.api;

import jakarta.validation.Valid;
import lekasv.bek.dto.task.CreateTaskRequest;
import lekasv.bek.dto.task.TaskResponse;
import lekasv.bek.dto.task.UpdateTaskRequest;
import lekasv.bek.enums.TaskStatucEnum;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Validated
public interface TaskService {
    List<TaskResponse> getAll();
    List<TaskResponse> getByDescription(String description);
    List<TaskResponse> getByName(String name);
    List<TaskResponse> getByStatus(TaskStatucEnum status);
    List<TaskResponse> getByUserId(Integer userId);
    List<TaskResponse> getByTaskGroupId(Integer taskGroupId);
    TaskResponse create(@Valid CreateTaskRequest task);
    TaskResponse update(@Valid Integer taskId, UpdateTaskRequest task);
    void deleteById(Integer taskId);
    List<TaskResponse> findByParentTaskId(Integer parentTaskId);
}
