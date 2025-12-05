package lekasv.bek.service.impl;

import lekasv.bek.dto.taskGroup.CreateTaskGroupRequest;
import lekasv.bek.dto.taskGroup.TaskGroupResponse;
import lekasv.bek.dto.taskGroup.UpdateTaskGroupRequest;
import lekasv.bek.exception.extended.taskGroup.TaskGroupNotFoundException;
import lekasv.bek.mapper.TaskGroupMapper;
import lekasv.bek.model.TaskGroup;
import lekasv.bek.repository.TaskGroupRepository;
import lekasv.bek.service.api.TaskGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskGroupServiceImpl implements TaskGroupService {
    private final TaskGroupRepository taskGroupRepository;
    private final TaskGroupMapper taskGroupMapper;


    @Override
    public List<TaskGroupResponse> getAllTaskGroups() {
        return taskGroupRepository.findAll()
                .stream()
                .map(taskGroupMapper::toTaskGroupResponse)
                .toList();
    }

    @Override
    public List<TaskGroupResponse> getByName(String name) {
        return taskGroupRepository.findByName(name)
                .stream()
                .map(taskGroupMapper::toTaskGroupResponse)
                .toList();
    }

    @Override
    public List<TaskGroupResponse> getByDescription(String description) {
        return taskGroupRepository.findByDescription(description)
                .stream()
                .map(taskGroupMapper::toTaskGroupResponse)
                .toList();
    }

    @Override
    public List<TaskGroupResponse> getByTaskBoardId(Integer taskBoardId) {
        return taskGroupRepository.findByTaskBoardId(taskBoardId)
                .stream()
                .map(taskGroupMapper::toTaskGroupResponse)
                .toList();
    }

    @Override
    public TaskGroupResponse createTaskGroup(CreateTaskGroupRequest taskGroup) {
        TaskGroup taskGroups = taskGroupMapper.fromCreateTaskGroupRequest(taskGroup);
        taskGroupRepository.save(taskGroups);
        return taskGroupMapper.toTaskGroupResponse(taskGroups);
    }

    @Override
    public TaskGroupResponse updateTaskGroup(UpdateTaskGroupRequest taskGroup, Integer taskGroupId) {
        TaskGroup taskGroups = taskGroupRepository.findById(taskGroupId)
                .orElseThrow(TaskGroupNotFoundException::new);
        taskGroupMapper.fromUpdateTaskGroupRequest(taskGroup, taskGroups);
        taskGroupRepository.save(taskGroups);
        return taskGroupMapper.toTaskGroupResponse(taskGroups);
    }

    @Override
    public void deleteTaskGroup(Integer taskGroupId) {
        taskGroupRepository.deleteById(taskGroupId);
    }
}
