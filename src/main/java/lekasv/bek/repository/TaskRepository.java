package lekasv.bek.repository;
import lekasv.bek.enums.TaskStatucEnum;
import lekasv.bek.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByDescription(String description);
    List<Task> findByName(String name);
    List<Task> findByStatus(TaskStatucEnum status);
    List<Task> findByUserId(Integer userId);
    List<Task> findByParentTaskId(Integer parentTaskId);
    List<Task> findByTaskGroupId(Integer taskGroupId);
    List<Task> findByTaskGroupIdIn(List<Integer> taskGroupIds);
}