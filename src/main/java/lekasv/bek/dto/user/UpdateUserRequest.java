package lekasv.bek.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class UpdateUserRequest {
    private String name;
    private String lastName;
    private Integer age;
    private Boolean active;
    private Integer roleId;
}
