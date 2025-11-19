package lekasv.bek.dto.role;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class RoleResponse {
    private Integer id;
    private String role;
}
