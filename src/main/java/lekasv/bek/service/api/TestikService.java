package lekasv.bek.service.api;

import jakarta.validation.Valid;
import lekasv.bek.dto.testik.CreateTestikRequest;
import lekasv.bek.dto.testik.TestikResponse;
import lekasv.bek.dto.testik.UpdateTestikRequest;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface TestikService {
    List<TestikResponse> getAll();
    List<TestikResponse> getByName(String name);
    TestikResponse getById(Integer testikId);
    TestikResponse create(@Valid CreateTestikRequest request);
    TestikResponse update(@Valid UpdateTestikRequest request, Integer testikId);
    void deleteById(Integer testikId);
}
