package lekasv.bek.mapper;

import lekasv.bek.dto.tag.CreateTagRequest;
import lekasv.bek.dto.tag.TagResponse;
import lekasv.bek.dto.tag.UpdateTagRequest;
import lekasv.bek.model.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagResponse toTagResponse(Tag tag);
    Tag fromCreateTagRequest(CreateTagRequest request);
    void fromUpdateTagRequest(UpdateTagRequest request, @MappingTarget Tag tag);
}
