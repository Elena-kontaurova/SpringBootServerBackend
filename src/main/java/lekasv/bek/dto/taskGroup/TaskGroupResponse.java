package lekasv.bek.dto.taskGroup;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class TaskGroupResponse {
    private int id;
    private String name;
    private String description;
    private Integer taskBoardId;
}
