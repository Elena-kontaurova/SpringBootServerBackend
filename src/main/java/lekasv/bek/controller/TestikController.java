package lekasv.bek.controller;

import lekasv.bek.dto.testik.CreateTestikRequest;
import lekasv.bek.dto.testik.TestikResponse;
import lekasv.bek.dto.testik.UpdateTestikRequest;
import lekasv.bek.service.api.TestikService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testik")
@RequiredArgsConstructor
public class TestikController {
    private final TestikService testikService;

    @GetMapping
    public List<TestikResponse> getAll() {
        return testikService.getAll();
    }

    @GetMapping("/name/{name}")
    public List<TestikResponse> getByName(@PathVariable String name) {
        return testikService.getByName(name);
    }

    @GetMapping("/{testikId}")
    public TestikResponse getById(@PathVariable Integer testikId) {
        return testikService.getById(testikId);
    }

    @PostMapping()
    public TestikResponse postTestik(@RequestBody CreateTestikRequest request) {
        return testikService.create(request);
    }

    @PutMapping("/{testikId}")
    public TestikResponse putTestik(@RequestBody UpdateTestikRequest request, @PathVariable Integer testikId) {
        return testikService.update(request, testikId);
    }

    @DeleteMapping("/{testikId}")
    public void deleteTestik(@PathVariable Integer testikId) {
        testikService.deleteById(testikId);
    }
}
