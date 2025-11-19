package lekasv.bek.dto.error;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder
@Getter
@Jacksonized
public class ErrorResponse {
    private List<String> errorMessages;
}
