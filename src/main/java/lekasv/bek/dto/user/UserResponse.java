package lekasv.bek.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class UserResponse {
    private int id;
    private String name;
    private String lastName;
    private int age;
    private Boolean active;
    private Integer roleId;
}
