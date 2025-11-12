package lekasv.bek.dto.task;

import jakarta.persistence.*;
import lekasv.bek.enums.TaskStatucEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class TaskResponse {
    private int id;
    private String name;
    private String description;
    private TaskStatucEnum status;
    private Integer userId;
}
