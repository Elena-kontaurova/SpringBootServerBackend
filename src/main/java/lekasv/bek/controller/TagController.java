package lekasv.bek.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lekasv.bek.dto.tag.CreateTagRequest;
import lekasv.bek.dto.tag.TagResponse;
import lekasv.bek.dto.tag.UpdateTagRequest;
import lekasv.bek.service.api.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Tags", description = "API для управления тегами")
@RequiredArgsConstructor
@RestController
@RequestMapping("/tag")
public class TagController {
    private final TagService tagService;

    @Operation(summary = "Получить все теги", description = "Возвращает список всех тегов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping
    public List<TagResponse> getTags() {
        return tagService.getAll();
    }

    @Operation(summary = "Создать тег", description = "Создает новый тег")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Тег создан"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @PostMapping
    public TagResponse createTag(@RequestBody CreateTagRequest request) {
        return tagService.createTag(request);
    }

    @Operation(summary = "Обновить тег", description = "Обновляет тег по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Тег обновлен"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "404", description = "Тег не найден"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @PutMapping("/{tagId}")
    public TagResponse updateTag(
            @Parameter(description = "Данные для обновления тега", required = true)
            @RequestBody UpdateTagRequest request,
            @Parameter(description = "ID тега", required = true, example = "1")
            @PathVariable Integer tagId) {
        return tagService.updateTag(request, tagId);
    }

    @Operation(summary = "Удалить тег", description = "Удаляет тег по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Тег удален"),
            @ApiResponse(responseCode = "404", description = "Тег не найден"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @DeleteMapping("/{tagId}")
    public void deleteTag(
            @Parameter(description = "ID тега", required = true, example = "1")
            @PathVariable Integer tagId) {
        tagService.deleteTag(tagId);
    }
}