package lekasv.bek.dto.taskTag;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class TaskTagResponse {
    private int id;
    private Integer tagId;
    private Integer taskId;
}
