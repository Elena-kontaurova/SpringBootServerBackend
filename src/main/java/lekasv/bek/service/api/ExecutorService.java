package lekasv.bek.service.api;

import lekasv.bek.dto.executor.CreateExecutorRequest;
import lekasv.bek.dto.executor.ExecutorResponse;

import java.util.List;

public interface ExecutorService{
    List<ExecutorResponse> getAll();
    List<ExecutorResponse> findByTaskId(Integer taskId);
    List<ExecutorResponse> findByExecutorId(Integer executorId);
    ExecutorResponse create(CreateExecutorRequest request);
    void deleteById(int executorId);
}
