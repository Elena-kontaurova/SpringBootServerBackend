package lekasv.bek.service.impl;

import lekasv.bek.dto.testik.CreateTestikRequest;
import lekasv.bek.dto.testik.UpdateTestikRequest;
import lekasv.bek.dto.testik.TestikResponse;
import lekasv.bek.mapper.TestikMapper;
import lekasv.bek.model.Testik;
import lekasv.bek.repository.TestikRepository;
import lekasv.bek.service.api.TestikService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TestikServiceImpl implements TestikService {
    private final TestikRepository testikRepository;
    private final TestikMapper testikMapper;

    @Override
    public List<TestikResponse> getAll() {
        return testikRepository.findAll()
                .stream()
                .map(testikMapper::toTestikResponse)
                .toList();
    }

    @Override
    public List<TestikResponse> getByName(String name) {
        return testikRepository.findByName(name)
                .stream()
                .map(testikMapper::toTestikResponse)
                .toList();
    }

    @Override
    public TestikResponse getById(int testikId) {
        return testikMapper.toTestikResponse(testikRepository.findById(testikId).get());
    }

    @Override
    public TestikResponse create(CreateTestikRequest request) {
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new IllegalArgumentException("Testik name is null or empty");
        }
        if (request.getAge() < 0 || request.getAge() > 100) {
            throw new IllegalArgumentException("Testik age is out of range");
        }
        Testik testik = testikMapper.fromCreateTestikRequest(request);
       testikRepository.save(testik);
       return testikMapper.toTestikResponse(testik);
    }

    @Override
    public TestikResponse update(UpdateTestikRequest request, int testikId) {
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new IllegalArgumentException("Testik name is null or empty");
        }
        if (request.getAge() < 0 || request.getAge() > 100) {
            throw new IllegalArgumentException("Testik age is out of range");
        }
        Testik testik = testikRepository.findById(testikId).get();
        testikMapper.fromUpdateTestikRequest(request, testik);
        testikRepository.save(testik);
        return testikMapper.toTestikResponse(testik);
    }

    @Override
    public void deleteById(int testikId) {
        testikRepository.deleteById(testikId);
    }

}
