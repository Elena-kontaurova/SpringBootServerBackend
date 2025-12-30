package lekasv.bek.controller;

import lekasv.bek.dto.executor.CreateExecutorRequest;
import lekasv.bek.dto.executor.ExecutorResponse;
import lekasv.bek.service.api.ExecutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/executor")
public class ExecutorController {
    private final ExecutorService executorService;

    @GetMapping
    public List<ExecutorResponse> getAll() {
        return executorService.getAll();
    }

    @GetMapping("/task/{taskId}")
    public List<ExecutorResponse> getTaskById(@PathVariable Integer taskId) {
        return executorService.findByTaskId(taskId);
    }

    @GetMapping("/{executorId}")
    public List<ExecutorResponse> getExecutorById(@PathVariable Integer executorId) {
        return executorService.findByExecutorId(executorId);
    }

    @PostMapping
    public ExecutorResponse create(@RequestBody CreateExecutorRequest executor) {
        return executorService.create(executor);
    }

    @DeleteMapping("/{executorId}")
    public void delete(@PathVariable Integer executorId) {
        executorService.deleteById(executorId);
    }
}
