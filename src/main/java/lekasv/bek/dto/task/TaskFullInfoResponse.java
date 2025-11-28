package lekasv.bek.dto.task;

import lekasv.bek.enums.TaskStatucEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@Jacksonized
public class TaskFullInfoResponse {
    private Integer id;
    private String name;
    private String description;
    private TaskStatucEnum status;
    private TaskFullInfoResponse.User user; // ответсвенный
    private TaskFullInfoResponse.Task parentTask;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private TaskFullInfoResponse.User createdBy;
    private TaskFullInfoResponse.User updatedBy;
    private List<TaskFullInfoResponse.User> executors;

    @Builder
    @Getter
    @Jacksonized
    public static class User {
        private Integer id;
        private String name;
        private String lastName;
    }

    @Builder
    @Getter
    @Jacksonized
    public static class Task {
        private Integer id;
        private String name;
    }
}
