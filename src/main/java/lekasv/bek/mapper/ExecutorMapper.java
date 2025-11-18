package lekasv.bek.mapper;

import lekasv.bek.dto.executor.CreateExecutorRequest;
import lekasv.bek.dto.executor.ExecutorResponse;
import lekasv.bek.model.Executor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExecutorMapper {
    ExecutorResponse toExecutorResponse(Executor executor);
    Executor fromCreateExecutorRequest(CreateExecutorRequest request);
}
