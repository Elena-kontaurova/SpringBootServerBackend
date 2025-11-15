package lekasv.bek.service.api;


import lekasv.bek.dto.taskTag.CreateTaskTagRequest;
import lekasv.bek.dto.taskTag.TaskTagResponse;

import java.util.List;

public interface TaskTagService{
    List<TaskTagResponse> getAll();
    TaskTagResponse create(CreateTaskTagRequest request);
    void delete(Integer id);
}
