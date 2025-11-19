package lekasv.bek.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Getter
@Builder
@Jacksonized
public class UserResponse {
    private Integer id;
    private String name;
    private String lastName;
    private Integer age;
    private Boolean active;
    private Integer roleId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
