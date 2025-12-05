package lekasv.bek.dto.taskBoard;

import lekasv.bek.enums.TaskStatucEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Getter
@Builder
@Jacksonized
public class TaskBoardFullInfoResponse {
    private String name;
    private List<TaskGroup> taskGroup;

    @Getter
    @Builder
    @Jacksonized
    public static class TaskGroup {
        private int id;
        private String name;
        private List<Task> tasks;
    }

    @Getter
    @Builder
    @Jacksonized
    public static class Task {
        private int id;
        private String name;
        private TaskStatucEnum status;
        private User user;
        private Integer groupId;
    }

    @Getter
    @Builder
    @Jacksonized
    public static class User {
        private int id;
        private String name;
    }
}
