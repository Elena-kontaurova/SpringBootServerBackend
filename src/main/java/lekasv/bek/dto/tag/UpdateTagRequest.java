package lekasv.bek.dto.tag;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class UpdateTagRequest {
    private String name;
    private Integer createdBy;
    private Integer updatedBy;
}
