package lekasv.bek.service.impl;

import lekasv.bek.dto.taskBoard.TaskBoardFullInfoResponse;
import lekasv.bek.exception.extended.taskBoard.TaskBoardNotFoundException;
import lekasv.bek.model.Task;
import lekasv.bek.model.TaskBoard;
import lekasv.bek.model.TaskGroup;
import lekasv.bek.repository.TaskBoardRepository;
import lekasv.bek.repository.TaskGroupRepository;
import lekasv.bek.repository.TaskRepository;
import lekasv.bek.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskBoardFacade {
    private final TaskRepository taskRepository;
    private final TaskGroupRepository taskGroupRepository;
    private final UserRepository userRepository;
    private final TaskBoardRepository taskBoardRepository;

    public TaskBoardFullInfoResponse getTaskBoardFullInfo(Integer taskBoardId) {
        TaskBoard taskBoard = taskBoardRepository.findById(taskBoardId)
                .orElseThrow(TaskBoardNotFoundException::new);

        List<TaskGroup> taskGroups = taskGroupRepository.findByTaskBoardId(taskBoardId);
        List<Integer> taskGroupIds = taskGroups
                .stream()
                .map(TaskGroup::getId)
                .toList();
        List<Task> tasks =  taskRepository.findByTaskGroupIdIn(taskGroupIds);
        List<Integer> userIds = tasks
                .stream()
                .map(Task::getUserId)
                .toList();
        Map<Integer, TaskBoardFullInfoResponse.User> users = userRepository.findAllById(userIds)
                .stream()
                .map(user -> TaskBoardFullInfoResponse.User.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .build())
                .collect(Collectors.toMap(
                        TaskBoardFullInfoResponse.User::getId,
                        user -> user,
                        (existing, replacement) -> existing
                ));
        ;

        Map<Integer, List<TaskBoardFullInfoResponse.Task>> taskDto = tasks
                .stream()
                .map(task -> TaskBoardFullInfoResponse.Task.builder()
                        .id(task.getId())
                        .name(task.getName())
                        .status(task.getStatus())
                        .user(users.get(task.getUserId()))
                        .groupId(task.getTaskGroupId())
                        .build())
                .collect(Collectors.groupingBy(TaskBoardFullInfoResponse.Task::getGroupId));

        List<TaskBoardFullInfoResponse.TaskGroup> taskGroupDto = taskGroups
                .stream()
                .map(taskGroup -> TaskBoardFullInfoResponse.TaskGroup.builder()
                        .id(taskGroup.getId())
                        .name(taskGroup.getName())
                        .tasks(taskDto.get(taskGroup.getId()))
                        .build())
                .toList();

        return TaskBoardFullInfoResponse.builder()
                .name(taskBoard.getName())
                .taskGroup(taskGroupDto)
                .build();
    }
}
