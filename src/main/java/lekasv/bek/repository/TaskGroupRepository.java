package lekasv.bek.repository;

import lekasv.bek.model.TaskGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskGroupRepository extends JpaRepository<TaskGroup, Integer> {
    List<TaskGroup> findByName(String name);
    List<TaskGroup> findByDescription(String description);
    List<TaskGroup> findByTaskBoardId(Integer taskBoardId);
}
