package lekasv.bek.dto.xyu;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class CreateXyuRequest {
    private String name;
    private int age;
}
