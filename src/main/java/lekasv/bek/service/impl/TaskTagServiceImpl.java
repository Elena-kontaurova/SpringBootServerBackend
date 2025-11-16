package lekasv.bek.service.impl;

import lekasv.bek.dto.taskTag.CreateTaskTagRequest;
import lekasv.bek.dto.taskTag.TaskTagResponse;
import lekasv.bek.mapper.TaskTagMapper;
import lekasv.bek.model.TaskTag;
import lekasv.bek.repository.TaskTagRepository;
import lekasv.bek.service.api.TaskTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskTagServiceImpl implements TaskTagService {
    private final TaskTagMapper taskTagMapper;
    private final TaskTagRepository taskTagRepository;

    @Override
    public List<TaskTagResponse> getAll() {
        return taskTagRepository.findAll()
                .stream()
                .map(taskTagMapper::toTaskTagResponse)
                .toList();
    }

    @Override
    public TaskTagResponse create(CreateTaskTagRequest request) {
        TaskTag taskTag = taskTagMapper.fromCreateTaskTagRequest(request);
        taskTagRepository.save(taskTag);
        return taskTagMapper.toTaskTagResponse(taskTag);
    }

    @Override
    public void delete(Integer taskTagId) {
        taskTagRepository.deleteById(taskTagId);
    }
}
