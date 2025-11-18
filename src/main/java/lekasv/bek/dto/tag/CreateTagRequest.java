package lekasv.bek.dto.tag;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Getter
@Builder
@Jacksonized
public class CreateTagRequest {
    private String name;
    private Integer createdBy;
    private Integer updatedBy;
}
