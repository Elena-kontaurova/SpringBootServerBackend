package lekasv.bek.controller;

import io.swagger.v3.oas.annotations.Parameter;
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
    public List<TestikResponse> getByName(
            @Parameter(description = "Имя теста для поиска", required = true, example = "unit")
            @PathVariable String name) {
        return testikService.getByName(name);
    }

    @GetMapping("/{testikId}")
    public TestikResponse getById(
            @Parameter(description = "ID теста", required = true, example = "1")
            @PathVariable Integer testikId) {
        return testikService.getById(testikId);
    }

    @PostMapping()
    public TestikResponse postTestik(@RequestBody CreateTestikRequest request) {
        return testikService.create(request);
    }

    @PutMapping("/{testikId}")
    public TestikResponse putTestik(
            @RequestBody UpdateTestikRequest request,
            @Parameter(description = "ID теста", required = true, example = "1")
            @PathVariable Integer testikId) {
        return testikService.update(request, testikId);
    }

    @DeleteMapping("/{testikId}")
    public void deleteTestik(
            @Parameter(description = "ID теста", required = true, example = "1")
            @PathVariable Integer testikId) {
        testikService.deleteById(testikId);
    }
}