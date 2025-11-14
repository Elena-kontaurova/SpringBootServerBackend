package lekasv.bek.dto.tag;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Getter
public class TagResponse {
    private int id;
    private String name;
}
