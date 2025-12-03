package lekasv.bek.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lekasv.bek.dto.task.CreateTaskRequest;
import lekasv.bek.dto.task.TaskFullInfoResponse;
import lekasv.bek.dto.task.TaskResponse;
import lekasv.bek.dto.task.UpdateTaskRequest;
import lekasv.bek.enums.TaskStatucEnum;
import lekasv.bek.service.api.TaskService;
import lekasv.bek.service.impl.TaskFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Task", description = "API для управления задачами")
@RequiredArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    private final TaskFacade taskFacade;

    @Operation(summary = "Полная информация о задаче", description = "Возвращает полную информацию о задаче с исполнителями, тегами и комментариями")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "404", description = "Задача не найдена"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping("/full-info/{taskId}")
    public TaskFullInfoResponse getTaskFullInfo(
            @Parameter(description = "ID задачи", required = true, example = "1")
            @PathVariable Integer taskId) {
        return taskFacade.getTaskFullInfo(taskId);
    }

    @Operation(summary = "Получить все задачи", description = "Возвращает список всех задач")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping
    public List<TaskResponse> getAll() {
        return taskService.getAll();
    }

    @Operation(summary = "Поиск задач по описанию", description = "Возвращает задачи по частичному совпадению описания")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping("/description/{description}")
    public List<TaskResponse> getByDescription(
            @Parameter(description = "Текст описания для поиска", required = true, example = "срочная задача")
            @PathVariable String description) {
        return taskService.getByDescription(description);
    }

    @Operation(summary = "Поиск задач по названию", description = "Возвращает задачи по частичному совпадению названия")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping("/name/{name}")
    public List<TaskResponse> getByName(
            @Parameter(description = "Название задачи для поиска", required = true, example = "рефакторинг")
            @PathVariable String name) {
        return taskService.getByName(name);
    }

    @Operation(summary = "Фильтр задач по статусу", description = "Возвращает задачи с указанным статусом")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "400", description = "Неверный статус"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping("/status/{status}")
    public List<TaskResponse> getByStatus(
            @Parameter(description = "Статус задачи", required = true, example = "IN_PROGRESS")
            @PathVariable TaskStatucEnum status) {
        return taskService.getByStatus(status);
    }

    @Operation(summary = "Задачи пользователя", description = "Возвращает задачи, назначенные пользователю")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping("/user/{userId}")
    public List<TaskResponse> getByUser(
            @Parameter(description = "ID пользователя", required = true, example = "5")
            @PathVariable Integer userId) {
        return taskService.getByUserId(userId);
    }

    @Operation(summary = "Создать задачу", description = "Создает новую задачу")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Задача создана"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @PostMapping
    public TaskResponse create(@RequestBody CreateTaskRequest request) {
        return taskService.create(request);
    }

    @Operation(summary = "Обновить задачу", description = "Обновляет существующую задачу")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Задача обновлена"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "404", description = "Задача не найдена"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @PutMapping("/update/{taskId}")
    public TaskResponse update(
            @Parameter(description = "ID задачи", required = true, example = "1")
            @PathVariable Integer taskId,
            @RequestBody UpdateTaskRequest request) {
        return taskService.update(taskId, request);
    }

    @Operation(summary = "Удалить задачу", description = "Удаляет задачу по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Задача удалена"),
            @ApiResponse(responseCode = "404", description = "Задача не найдена"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @DeleteMapping("/del/{taskId}")
    public void delete(
            @Parameter(description = "ID задачи", required = true, example = "1")
            @PathVariable Integer taskId) {
        taskService.deleteById(taskId);
    }

    @Operation(summary = "Подзадачи", description = "Возвращает подзадачи родительской задачи")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "404", description = "Родительская задача не найдена"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping("/taskParentId/{taskParentId}")
    public List<TaskResponse> getByParentTaskId(
            @Parameter(description = "ID родительской задачи", required = true, example = "10")
            @PathVariable Integer taskParentId) {
        return taskService.findByParentTaskId(taskParentId);
    }
}