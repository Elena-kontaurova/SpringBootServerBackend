package lekasv.bek.repository;

import lekasv.bek.model.TaskBoard;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskBoardRepository extends JpaRepository<TaskBoard, Integer> {
    TaskBoard findByName(String name);
}
