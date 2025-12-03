package lekasv.bek.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lekasv.bek.dto.taskTag.CreateTaskTagRequest;
import lekasv.bek.dto.taskTag.TaskTagResponse;
import lekasv.bek.service.api.TaskTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "TaskTag", description = "API для управления связями между задачами и тегами")
@RestController
@RequestMapping("/taskTag")
@RequiredArgsConstructor
public class TaskTagController {
    private final TaskTagService taskTagService;

    @Operation(summary = "Получить все связи", description = "Возвращает все связи между задачами и тегами")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping
    public List<TaskTagResponse> getAll() {
        return taskTagService.getAll();
    }

    @Operation(summary = "Создать связь", description = "Создает связь между задачей и тегом")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Связь создана"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "404", description = "Задача или тег не найдены"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @PostMapping
    public TaskTagResponse create(@RequestBody CreateTaskTagRequest request) {
        return taskTagService.create(request);
    }

    @Operation(summary = "Удалить связь", description = "Удаляет связь между задачей и тегом по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Связь удалена"),
            @ApiResponse(responseCode = "404", description = "Связь не найдена"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @DeleteMapping("/{taskTagId}")
    public void delete(
            @Parameter(description = "ID связи задачи и тега", required = true, example = "1")
            @PathVariable Integer taskTagId) {
        taskTagService.delete(taskTagId);
    }
}