package lekasv.bek.dto.taskTag;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Jacksonized
public class CreateTaskTagRequest {
    private Integer tagId;
    private Integer taskId;
}
