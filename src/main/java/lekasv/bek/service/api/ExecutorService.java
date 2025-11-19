package lekasv.bek.service.api;

import jakarta.validation.Valid;
import lekasv.bek.dto.executor.CreateExecutorRequest;
import lekasv.bek.dto.executor.ExecutorResponse;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Validated
public interface ExecutorService{
    List<ExecutorResponse> getAll();
    List<ExecutorResponse> findByTaskId(Integer taskId);
    List<ExecutorResponse> findByExecutorId(Integer executorId);
    ExecutorResponse create(@Valid CreateExecutorRequest request);
    void deleteById(Integer executorId);
}
