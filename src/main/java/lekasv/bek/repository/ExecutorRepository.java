package lekasv.bek.repository;

import lekasv.bek.dto.executor.ExecutorResponse;
import lekasv.bek.model.Executor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExecutorRepository extends JpaRepository<Executor, Integer> {
    List<Executor> findByTaskId(Integer taskId);
    List<Executor> findByExecutorId(Integer executorId);
}
