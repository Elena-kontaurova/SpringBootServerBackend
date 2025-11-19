package lekasv.bek.service.api;

import jakarta.validation.Valid;
import lekasv.bek.dto.tag.CreateTagRequest;
import lekasv.bek.dto.tag.TagResponse;
import lekasv.bek.dto.tag.UpdateTagRequest;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Validated
public interface TagService {
    List<TagResponse> getAll();
    TagResponse createTag(@Valid CreateTagRequest tag);
    TagResponse updateTag(@Valid UpdateTagRequest tag, Integer tagId);
    void deleteTag(Integer tag);
}
