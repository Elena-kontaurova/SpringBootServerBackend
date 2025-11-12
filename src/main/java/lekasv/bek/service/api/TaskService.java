package lekasv.bek.service.api;

import lekasv.bek.dto.task.TaskResponse;
import lekasv.bek.enums.TaskStatucEnum;
import lekasv.bek.dto.task.CreateTaskRequest;
import lekasv.bek.dto.task.UpdateTaskRequest;
import lekasv.bek.model.Task;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAll();
    List<TaskResponse> getByDescription(String description);
    List<TaskResponse> getByName(String name);
    List<TaskResponse> getByStatus(TaskStatucEnum status);
    List<TaskResponse> getByUserId(Integer userId);
    TaskResponse create(CreateTaskRequest task);
    TaskResponse update(Integer task_id, UpdateTaskRequest task);
    void deleteById(Integer task_id);
}
