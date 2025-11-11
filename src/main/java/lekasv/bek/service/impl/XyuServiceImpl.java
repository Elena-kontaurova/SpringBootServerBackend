package lekasv.bek.service.impl;

import lekasv.bek.model.Xyu;
import lekasv.bek.repository.XyuRepository;
import lekasv.bek.service.api.UserService;
import lekasv.bek.service.api.XyuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class XyuServiceImpl implements XyuService {
    private final XyuRepository xyuRepository;

    @Override
    public List<Xyu> getAll() {
        return xyuRepository.findAll();
    }

    @Override
    public Xyu getByName(String name) {
        return xyuRepository.findByName(name);
    }

    @Override
    public Xyu getById(int id_xyu) {
        return xyuRepository.findById(id_xyu).get();
    }

    @Override
    public Xyu create(Xyu xyu) {
        if (xyu.getName() == null || xyu.getName().isEmpty()) {
            throw new IllegalArgumentException("Xyu name is null or empty");
        }
        if (xyu.getAge() < 0 || xyu.getAge() > 100) {
            throw new IllegalArgumentException("Xyu age is out of range");
        }
        return xyuRepository.save(xyu);
    }

    @Override
    public Xyu update(Xyu xyu, int id_xyu) {
        if (xyu.getName() == null || xyu.getName().isEmpty()) {
            throw new IllegalArgumentException("Xyu name is null or empty");
        }
        if (xyu.getAge() < 0 || xyu.getAge() > 100) {
            throw new IllegalArgumentException("Xyu age is out of range");
        }
        Xyu xx = xyuRepository.findById(id_xyu).get();
        xx.setName(xyu.getName());
        xx.setAge(xyu.getAge());
        return xyuRepository.save(xx);
    }

    @Override
    public void deleteById(int id_xyu) {
        xyuRepository.deleteById(id_xyu);
    }

}
