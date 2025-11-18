package lekasv.bek.controller;

import lekasv.bek.dto.testik.CreateTestikRequest;
import lekasv.bek.dto.testik.UpdateTestikRequest;
import lekasv.bek.dto.testik.TestikResponse;
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

    @GetMapping("/{id_testik}")
    public TestikResponse getById(@PathVariable int id_testik) {
        return testikService.getById(id_testik);
    }

    @PostMapping()
    public TestikResponse posttestik(@RequestBody CreateTestikRequest request) {
        return testikService.create(request);
    }

    @PutMapping("/{id_testik}")
    public TestikResponse puttestik(@RequestBody UpdateTestikRequest request, @PathVariable int id_testik) {
        return testikService.update(request, id_testik);
    }

    @DeleteMapping("/{id_testik}")
    public void deletetestik(@PathVariable int id_testik) {
        testikService.deleteById(id_testik);
    }
}
