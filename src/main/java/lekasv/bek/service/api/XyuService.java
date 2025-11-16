package lekasv.bek.service.api;

import lekasv.bek.dto.xyu.CreateXyuRequest;
import lekasv.bek.dto.xyu.UpdateXyuRequest;
import lekasv.bek.dto.xyu.XyuResponse;

import java.util.List;

public interface XyuService {
    List<XyuResponse> getAll();
    List<XyuResponse> getByName(String name);
    XyuResponse getById(int id_xyu);
    XyuResponse create(CreateXyuRequest request);
    XyuResponse update(UpdateXyuRequest request, int id_xyu);
    void deleteById(int id_xyu);
}
