package lekasv.bek.service.api;

import lekasv.bek.dto.tag.CreateTagRequest;
import lekasv.bek.dto.tag.TagResponse;
import lekasv.bek.dto.tag.UpdateTagRequest;

import java.util.List;

public interface TagService {
    List<TagResponse> getAll();
    TagResponse createTag(CreateTagRequest tag);
    TagResponse updateTag(UpdateTagRequest tag, Integer id_tag);
    void deleteTag(Integer tag);
}
