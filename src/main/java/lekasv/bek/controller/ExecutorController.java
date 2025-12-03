package lekasv.bek.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lekasv.bek.dto.executor.CreateExecutorRequest;
import lekasv.bek.dto.executor.ExecutorResponse;
import lekasv.bek.service.api.ExecutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Executor", description = "API для управления исполнителями задач")
@RestController
@RequiredArgsConstructor
@RequestMapping("/executor")
public class ExecutorController {
    private final ExecutorService executorService;

    @Operation(
            summary = "Получить всех исполнителей",
            description = "Возвращает список всех исполнителей в системе"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение списка исполнителей"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @GetMapping
    public List<ExecutorResponse> getAll() {
        return executorService.getAll();
    }

    @Operation(
            summary = "Получить исполнителей по ID задачи",
            description = "Возвращает список исполнителей, назначенных на конкретную задачу"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение исполнителей задачи"),
            @ApiResponse(responseCode = "404", description = "Задача не найдена"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @GetMapping("/task/{taskId}")
    public List<ExecutorResponse> getTaskById(@PathVariable Integer taskId) {
        return executorService.findByTaskId(taskId);
    }

    @Operation(
            summary = "Получить задачи по ID исполнителя",
            description = "Возвращает список задач, назначенных конкретному исполнителю"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение задач исполнителя"),
            @ApiResponse(responseCode = "404", description = "Исполнитель не найден"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @GetMapping("/{executorId}")
    public List<ExecutorResponse> getExecutorById(@PathVariable Integer executorId) {
        return executorService.findByExecutorId(executorId);
    }

    @Operation(
            summary = "Создать нового исполнителя",
            description = "Создает нового исполнителя или назначает существующего исполнителя на задачу"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Исполнитель успешно создан/назначен"),
            @ApiResponse(responseCode = "400", description = "Неверные входные данные"),
            @ApiResponse(responseCode = "404", description = "Задача или пользователь не найден"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @PostMapping
    public ExecutorResponse create(@RequestBody CreateExecutorRequest executor) {
        return executorService.create(executor);
    }

    @Operation(
            summary = "Удалить исполнителя",
            description = "Удаляет связь исполнителя с задачей или самого исполнителя"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Исполнитель успешно удален"),
            @ApiResponse(responseCode = "404", description = "Исполнитель не найден"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @DeleteMapping("/{executorId}")
    public void delete(@PathVariable Integer executorId) {
        executorService.deleteById(executorId);
    }
}
