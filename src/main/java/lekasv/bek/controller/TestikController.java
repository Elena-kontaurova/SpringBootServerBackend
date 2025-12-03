package lekasv.bek.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lekasv.bek.dto.testik.CreateTestikRequest;
import lekasv.bek.dto.testik.TestikResponse;
import lekasv.bek.dto.testik.UpdateTestikRequest;
import lekasv.bek.service.api.TestikService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Test", description = "API для управления тестами")
@RestController
@RequestMapping("/testik")
@RequiredArgsConstructor
public class TestikController {
    private final TestikService testikService;

    @Operation(summary = "Получить все тесты", description = "Возвращает список всех тестов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping
    public List<TestikResponse> getAll() {
        return testikService.getAll();
    }

    @Operation(summary = "Поиск тестов по имени", description = "Возвращает тесты по частичному совпадению имени")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping("/name/{name}")
    public List<TestikResponse> getByName(
            @Parameter(description = "Имя теста для поиска", required = true, example = "unit")
            @PathVariable String name) {
        return testikService.getByName(name);
    }

    @Operation(summary = "Получить тест по ID", description = "Возвращает тест по его идентификатору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "404", description = "Тест не найден"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping("/{testikId}")
    public TestikResponse getById(
            @Parameter(description = "ID теста", required = true, example = "1")
            @PathVariable Integer testikId) {
        return testikService.getById(testikId);
    }

    @Operation(summary = "Создать тест", description = "Создает новый тест")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Тест создан"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @PostMapping()
    public TestikResponse postTestik(@RequestBody CreateTestikRequest request) {
        return testikService.create(request);
    }

    @Operation(summary = "Обновить тест", description = "Обновляет существующий тест")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Тест обновлен"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "404", description = "Тест не найден"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @PutMapping("/{testikId}")
    public TestikResponse putTestik(
            @RequestBody UpdateTestikRequest request,
            @Parameter(description = "ID теста", required = true, example = "1")
            @PathVariable Integer testikId) {
        return testikService.update(request, testikId);
    }

    @Operation(summary = "Удалить тест", description = "Удаляет тест по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Тест удален"),
            @ApiResponse(responseCode = "404", description = "Тест не найден"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @DeleteMapping("/{testikId}")
    public void deleteTestik(
            @Parameter(description = "ID теста", required = true, example = "1")
            @PathVariable Integer testikId) {
        testikService.deleteById(testikId);
    }
}