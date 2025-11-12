package lekasv.bek.mapper;

import lekasv.bek.dto.xyu.CreateXyuRequest;
import lekasv.bek.dto.xyu.UpdateXyuRequest;
import lekasv.bek.dto.xyu.XyuResponse;
import lekasv.bek.model.Xyu;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface XyuMapper {
    Xyu fromCreateXyuRequest(CreateXyuRequest request);
    void fromUpdateXyuRequest(UpdateXyuRequest request, @MappingTarget Xyu xyu);
    XyuResponse toXyuResponse(Xyu xyu);
}
