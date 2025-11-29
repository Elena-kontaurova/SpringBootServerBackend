package lekasv.bek.repository;

import lekasv.bek.model.Executor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExecutorRepository extends JpaRepository<Executor, Integer> {
    List<Executor> findByTaskId(Integer taskId);
    List<Executor> findByExecutorId(Integer executorId);

    @Query("""
            SELECT executor.executorId
            FROM Executor executor
            WHERE executor.taskId = :taskId
            """)
    List<Integer> findExecutorIdsByTaskId(Integer taskId);
}
