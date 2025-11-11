package lekasv.bek.repository;

import lekasv.bek.Enum.TaskStatucEnum;
import lekasv.bek.model.Task;
import lekasv.bek.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByDescription(String description);
    List<Task> findByName(String name);
    List<Task> findByStatus(TaskStatucEnum status);
    List<Task> findByUser(User user);
    List<Task> findByUserId(Integer userId);
}
