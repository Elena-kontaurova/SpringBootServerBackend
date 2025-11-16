package lekasv.bek.dto.executor;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class CreateExecutorRequest {
    private Integer taskId;
    private Integer executorId;
}
