package lekasv.bek.dto.executor;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Getter
@Builder
@Jacksonized
public class ExecutorResponse {
    private Integer id;
    private Integer taskId;
    private Integer executorId;
    private LocalDateTime createdAt; // когда
    private Integer createdBy;
}
