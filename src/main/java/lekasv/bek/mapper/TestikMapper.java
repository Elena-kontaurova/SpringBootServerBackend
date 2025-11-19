package lekasv.bek.mapper;

import lekasv.bek.dto.testik.CreateTestikRequest;
import lekasv.bek.dto.testik.TestikResponse;
import lekasv.bek.dto.testik.UpdateTestikRequest;
import lekasv.bek.model.Testik;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TestikMapper {
    Testik fromCreateTestikRequest(CreateTestikRequest request);
    void fromUpdateTestikRequest(UpdateTestikRequest request, @MappingTarget Testik testik);
    TestikResponse toTestikResponse(Testik testik);
}
