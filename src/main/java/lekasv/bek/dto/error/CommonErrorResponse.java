package lekasv.bek.dto.error;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Jacksonized
public class CommonErrorResponse {
    private String errorMessage;
}
