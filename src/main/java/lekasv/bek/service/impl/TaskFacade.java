package lekasv.bek.service.impl;

import lekasv.bek.dto.task.TaskFullInfoResponse;
import lekasv.bek.exception.extended.task.TaskNotFoundException;
import lekasv.bek.exception.extended.user.UserNotFoundException;
import lekasv.bek.model.Task;
import lekasv.bek.model.User;
import lekasv.bek.repository.ExecutorRepository;
import lekasv.bek.repository.TaskRepository;
import lekasv.bek.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskFacade {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ExecutorRepository executorRepository;


    public TaskFullInfoResponse getTaskFullInfo(Integer taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(TaskNotFoundException::new);

        User user = userRepository.findById(task.getUserId())
                .orElseThrow(UserNotFoundException::new);

        TaskFullInfoResponse.Task parrentTask =task.getParentTaskId() == null
                ? null
                : taskRepository.findById(task.getParentTaskId())
                .map(t -> TaskFullInfoResponse.Task.builder()
                        .id(t.getId())
                        .name(t.getName())
                        .build())
                .orElseThrow(TaskNotFoundException::new);

        List<Integer> executorsIds = executorRepository.findExecutorIdsByTaskId(taskId);
        List<TaskFullInfoResponse.User> executors = userRepository.findAllById(executorsIds)
                .stream()
                .map(u -> TaskFullInfoResponse.User.builder()
                        .id(u.getId())
                        .name(u.getName())
                        .lastName(u.getLastName())
                        .build())
                .toList();


        return TaskFullInfoResponse.builder()
                .id(task.getId())
                .name(task.getName())
                .description(task.getDescription())
                .status(task.getStatus())

                .user(
                    TaskFullInfoResponse.User.builder()
                            .id(user.getId())
                            .name(user.getName())
                            .lastName(user.getLastName())
                            .build()
                )

                .parentTask(parrentTask)

                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())

                .createdBy(
                        TaskFullInfoResponse.User.builder()
                                .id(user.getId())
                                .name(user.getName())
                                .lastName(user.getLastName())
                                .build()
                )

                .updatedBy(
                        TaskFullInfoResponse.User.builder()
                                .id(user.getId())
                                .name(user.getName())
                                .lastName(user.getLastName())
                                .build()
                )

                .executors(executors)

                .build();
    }
}
