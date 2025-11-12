package lekasv.bek.service.impl;

import lekasv.bek.dto.xyu.CreateXyuRequest;
import lekasv.bek.dto.xyu.UpdateXyuRequest;
import lekasv.bek.dto.xyu.XyuResponse;
import lekasv.bek.mapper.XyuMapper;
import lekasv.bek.model.Xyu;
import lekasv.bek.repository.XyuRepository;
import lekasv.bek.service.api.XyuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class XyuServiceImpl implements XyuService {
    private final XyuRepository xyuRepository;
    private final XyuMapper xyuMapper;

    @Override
    public List<XyuResponse> getAll() {
        return xyuRepository.findAll()
                .stream()
                .map(xyuMapper::toXyuResponse)
                .toList();
    }

    @Override
    public List<XyuResponse> getByName(String name) {
        return xyuRepository.findByName(name)
                .stream()
                .map(xyuMapper::toXyuResponse)
                .toList();
    }

    @Override
    public XyuResponse getById(int id_xyu) {
        return xyuMapper.toXyuResponse(xyuRepository.findById(id_xyu).get());
    }

    @Override
    public XyuResponse create(CreateXyuRequest request) {
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new IllegalArgumentException("Xyu name is null or empty");
        }
        if (request.getAge() < 0 || request.getAge() > 100) {
            throw new IllegalArgumentException("Xyu age is out of range");
        }
        Xyu xyu = xyuMapper.fromCreateXyuRequest(request);
       xyuRepository.save(xyu);
       return xyuMapper.toXyuResponse(xyu);
    }

    @Override
    public XyuResponse update(UpdateXyuRequest request, int id_xyu) {
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new IllegalArgumentException("Xyu name is null or empty");
        }
        if (request.getAge() < 0 || request.getAge() > 100) {
            throw new IllegalArgumentException("Xyu age is out of range");
        }
        Xyu xyu = xyuRepository.findById(id_xyu).get();
        xyuMapper.fromUpdateXyuRequest(request, xyu);
        xyuRepository.save(xyu);
        return xyuMapper.toXyuResponse(xyu);
    }

    @Override
    public void deleteById(int id_xyu) {
        xyuRepository.deleteById(id_xyu);
    }

}
