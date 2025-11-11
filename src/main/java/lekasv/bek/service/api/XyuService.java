package lekasv.bek.service.api;

import lekasv.bek.model.Xyu;

import java.util.List;

public interface XyuService {
    List<Xyu> getAll();
    Xyu getByName(String name);
    Xyu getById(int id_xyu);
    Xyu create(Xyu xyu);
    Xyu update(Xyu xyu, int id_xyu);
    void deleteById(int id_xyu);
}
