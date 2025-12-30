package lekasv.bek.controller;

import io.swagger.v3.oas.annotations.Parameter;
import lekasv.bek.dto.tag.CreateTagRequest;
import lekasv.bek.dto.tag.TagResponse;
import lekasv.bek.dto.tag.UpdateTagRequest;
import lekasv.bek.service.api.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tag")
public class TagController {
    private final TagService tagService;

    @GetMapping
    public List<TagResponse> getTags() {
        return tagService.getAll();
    }

    @PostMapping
    public TagResponse createTag(@RequestBody CreateTagRequest request) {
        return tagService.createTag(request);
    }

    @PutMapping("/{tagId}")
    public TagResponse updateTag(
            @Parameter(description = "Данные для обновления тега", required = true)
            @RequestBody UpdateTagRequest request,
            @Parameter(description = "ID тега", required = true, example = "1")
            @PathVariable Integer tagId) {
        return tagService.updateTag(request, tagId);
    }

    @DeleteMapping("/{tagId}")
    public void deleteTag(
            @Parameter(description = "ID тега", required = true, example = "1")
            @PathVariable Integer tagId) {
        tagService.deleteTag(tagId);
    }
}