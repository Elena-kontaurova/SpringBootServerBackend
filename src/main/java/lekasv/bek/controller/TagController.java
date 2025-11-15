package lekasv.bek.controller;

import lekasv.bek.dto.tag.CreateTagRequest;
import lekasv.bek.dto.tag.TagResponse;
import lekasv.bek.dto.tag.UpdateTagRequest;
import lekasv.bek.service.api.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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

    @PutMapping("/{id_tag}")
    public TagResponse updateTag(@RequestBody UpdateTagRequest request, @PathVariable int id_tag) {
        return tagService.updateTag(request, id_tag);
    }

    @DeleteMapping("/{id_tag}")
    public void deleteTag(@PathVariable int id_tag) {
        tagService.deleteTag(id_tag);
    }
}
