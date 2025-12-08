package lekasv.bek.repository;

import lekasv.bek.model.TaskBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TaskBoardRepository extends JpaRepository<TaskBoard, Integer> {
    TaskBoard findByName(String name);
    List<TaskBoard> findByProjectId(Integer projectId);
}
