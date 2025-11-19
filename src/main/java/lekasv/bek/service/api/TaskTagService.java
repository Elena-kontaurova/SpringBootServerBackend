package lekasv.bek.service.api;


import jakarta.validation.Valid;
import lekasv.bek.dto.taskTag.CreateTaskTagRequest;
import lekasv.bek.dto.taskTag.TaskTagResponse;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface TaskTagService{
    List<TaskTagResponse> getAll();
    TaskTagResponse create(@Valid CreateTaskTagRequest request);
    void delete(Integer id);
}
