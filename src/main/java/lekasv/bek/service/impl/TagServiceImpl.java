package lekasv.bek.service.impl;

import lekasv.bek.dto.tag.CreateTagRequest;
import lekasv.bek.dto.tag.TagResponse;
import lekasv.bek.dto.tag.UpdateTagRequest;
import lekasv.bek.exception.extended.tag.TagNotFoundException;
import lekasv.bek.mapper.TagMapper;
import lekasv.bek.model.Tag;
import lekasv.bek.repository.TagRepository;
import lekasv.bek.service.api.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    private final TagMapper tagMapper;


    @Override
    public List<TagResponse> getAll() {
        return tagRepository.findAll()
                .stream()
                .map(tagMapper::toTagResponse)
                .toList();
    }

    @Override
    public TagResponse createTag(CreateTagRequest request) {
        Tag tag = tagMapper.fromCreateTagRequest(request);
        tag.setCreatedAt(LocalDateTime.now());
        tag.setUpdatedAt(LocalDateTime.now());
        tagRepository.save(tag);
        return tagMapper.toTagResponse(tag);
    }

    @Override
    public TagResponse updateTag(UpdateTagRequest tag, Integer tagId) {
        Tag tags = tagRepository.findById(tagId)
                .orElseThrow(TagNotFoundException::new);
        tagMapper.fromUpdateTagRequest(tag, tags);
        tags.setUpdatedAt(LocalDateTime.now());
        return tagMapper.toTagResponse(tagRepository.save(tags));
    }

    @Override
    public void deleteTag(Integer tag) {
        tagRepository.deleteById(tag);
    }
}
