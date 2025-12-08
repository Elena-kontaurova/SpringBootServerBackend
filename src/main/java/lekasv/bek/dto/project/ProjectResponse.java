package lekasv.bek.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class ProjectResponse {
    private int id;
    private String name;
}
