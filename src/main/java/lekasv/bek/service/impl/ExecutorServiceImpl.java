package lekasv.bek.service.impl;

import lekasv.bek.dto.executor.CreateExecutorRequest;
import lekasv.bek.dto.executor.ExecutorResponse;
import lekasv.bek.mapper.ExecutorMapper;
import lekasv.bek.model.Executor;
import lekasv.bek.repository.ExecutorRepository;
import lekasv.bek.service.api.ExecutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExecutorServiceImpl implements ExecutorService {
    private final ExecutorRepository executorRepository;
    private final ExecutorMapper executorMapper;

    @Override
    public List<ExecutorResponse> getAll() {
        return executorRepository.findAll()
                .stream()
                .map(executorMapper::toExecutorResponse)
                .toList();
    }

    @Override
    public List<ExecutorResponse> findByTaskId(Integer taskId) {
        return executorRepository.findByTaskId(taskId)
                .stream()
                .map(executorMapper::toExecutorResponse)
                .toList();
    }

    @Override
    public List<ExecutorResponse> findByExecutorId(Integer executorId) {
        return executorRepository.findByExecutorId(executorId)
                .stream()
                .map(executorMapper::toExecutorResponse)
                .toList();
    }

    @Override
    public ExecutorResponse create(CreateExecutorRequest request) {
        Executor executor = executorMapper.fromCreateExecutorRequest(request);
        executorRepository.save(executor);
        return executorMapper.toExecutorResponse(executor);
    }

    @Override
    public void deleteById(int executorId) {
        executorRepository.deleteById(executorId);
    }
}
