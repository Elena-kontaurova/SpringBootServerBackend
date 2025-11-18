package lekasv.bek.service.api;

import lekasv.bek.dto.testik.CreateTestikRequest;
import lekasv.bek.dto.testik.UpdateTestikRequest;
import lekasv.bek.dto.testik.TestikResponse;

import java.util.List;

public interface TestikService {
    List<TestikResponse> getAll();
    List<TestikResponse> getByName(String name);
    TestikResponse getById(int testikId);
    TestikResponse create(CreateTestikRequest request);
    TestikResponse update(UpdateTestikRequest request, int testikId);
    void deleteById(int testikId);
}
