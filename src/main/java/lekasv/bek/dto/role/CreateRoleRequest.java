package lekasv.bek.dto.role;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class CreateRoleRequest {
    private String role;
}
