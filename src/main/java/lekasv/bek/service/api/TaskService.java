package lekasv.bek.service.api;

import lekasv.bek.Enum.TaskStatucEnum;
import lekasv.bek.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();
    List<Task> getByDescription(String description);
    List<Task> getByName(String name);
    List<Task> getByStatus(TaskStatucEnum status);
    List<Task> getByUserId(Integer userId);
    Task create(Task task);
    Task update(Integer task_id, Task task);
    void deleteById(Integer task_id);
}
