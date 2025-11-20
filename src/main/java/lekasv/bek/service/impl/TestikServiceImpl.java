package lekasv.bek.service.impl;

import lekasv.bek.dto.testik.CreateTestikRequest;
import lekasv.bek.dto.testik.TestikResponse;
import lekasv.bek.dto.testik.UpdateTestikRequest;
import lekasv.bek.exception.extended.testik.TestikNotFoundException;
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
    public TestikResponse getById(Integer testikId) {
        return testikMapper.toTestikResponse(testikRepository.findById(testikId)
                .orElseThrow(TestikNotFoundException::new));
    }

    @Override
    public TestikResponse create(CreateTestikRequest request) {
        Testik testik = testikMapper.fromCreateTestikRequest(request);
       testikRepository.save(testik);
       return testikMapper.toTestikResponse(testik);
    }

    @Override
    public TestikResponse update(UpdateTestikRequest request, Integer testikId) {
        Testik testik = testikRepository.findById(testikId)
                .orElseThrow(TestikNotFoundException::new);
        testikMapper.fromUpdateTestikRequest(request, testik);
        testikRepository.save(testik);
        return testikMapper.toTestikResponse(testik);
    }

    @Override
    public void deleteById(Integer testikId) {
        testikRepository.deleteById(testikId);
    }

}
