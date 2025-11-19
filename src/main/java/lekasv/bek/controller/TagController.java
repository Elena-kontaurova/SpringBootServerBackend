package lekasv.bek.controller;

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
    public TagResponse updateTag(@RequestBody UpdateTagRequest request, @PathVariable Integer tagId) {
        return tagService.updateTag(request, tagId);
    }

    @DeleteMapping("/{tagId}")
    public void deleteTag(@PathVariable Integer tagId) {
        tagService.deleteTag(tagId);
    }
}
