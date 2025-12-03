package lekasv.bek.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lekasv.bek.dto.comment.CommentResponse;
import lekasv.bek.dto.comment.CreateCommentRequest;
import lekasv.bek.dto.comment.UpdateCommentRequest;
import lekasv.bek.service.api.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/comment")
@RestController
@Tag(name = "Comments", description = "API для управления комментариями")
public class CommentController {
    private final CommentService commentService;

    @Operation(
            summary = "Получить все комментарии",
            description = "Возвращает список всех комментариев в системе"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение списка комментариев"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @GetMapping
    public List<CommentResponse> getAll() {
        return commentService.getAll();
    }

    @Operation(
            summary = "Получить комментарии по ID задачи",
            description = "Возвращает список комментариев для конкретной задачи"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение комментариев"),
            @ApiResponse(responseCode = "404", description = "Задача не найдена"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @GetMapping("/taskId/{taskId}")
    public List<CommentResponse> findByTaskId(@PathVariable Integer taskId) {
        return commentService.findByTaskId(taskId);
    }

    @Operation(
            summary = "Создать новый комментарий",
            description = "Создает новый комментарий и возвращает его данные"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Комментарий успешно создан"),
            @ApiResponse(responseCode = "400", description = "Неверные входные данные"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @PostMapping
    public CommentResponse create(@RequestBody CreateCommentRequest comment) {
        return commentService.create(comment);
    }

    @Operation(
            summary = "Обновить комментарий",
            description = "Обновляет существующий комментарий по его ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Комментарий успешно обновлен"),
            @ApiResponse(responseCode = "400", description = "Неверные входные данные"),
            @ApiResponse(responseCode = "404", description = "Комментарий не найден"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @PutMapping("/comment/{commentId}")
    public CommentResponse update(@PathVariable Integer commentId, @RequestBody UpdateCommentRequest comment) {
        return commentService.update(comment, commentId);
    }

    @Operation(
            summary = "Удалить комментарий",
            description = "Удаляет комментарий по его ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Комментарий успешно удален"),
            @ApiResponse(responseCode = "404", description = "Комментарий не найден"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @DeleteMapping("/comment/{commentId}")
    public void deleteById(@PathVariable Integer commentId) {
        commentService.deleteById(commentId);
    }
}
