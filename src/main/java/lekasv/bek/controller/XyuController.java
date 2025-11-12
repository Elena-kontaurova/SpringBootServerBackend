package lekasv.bek.controller;

import lekasv.bek.dto.xyu.CreateXyuRequest;
import lekasv.bek.dto.xyu.UpdateXyuRequest;
import lekasv.bek.dto.xyu.XyuResponse;
import lekasv.bek.model.Xyu;
import lekasv.bek.service.api.XyuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xuy")
@RequiredArgsConstructor
public class XyuController {
    private final XyuService xyuService;

    @GetMapping
    public List<XyuResponse> getAll() {
        return xyuService.getAll();
    }

    @GetMapping("/name/{name}")
    public List<XyuResponse> getByName(@PathVariable String name) {
        return xyuService.getByName(name);
    }

    @GetMapping("/{id_xyu}")
    public XyuResponse getById(@PathVariable int id_xyu) {
        return xyuService.getById(id_xyu);
    }

    @PostMapping()
    public XyuResponse postXyu(@RequestBody CreateXyuRequest request) {
        return xyuService.create(request);
    }

    @PutMapping("/{id_xyu}")
    public XyuResponse putXyu(@RequestBody UpdateXyuRequest request, @PathVariable int id_xyu) {
        return xyuService.update(request, id_xyu);
    }

    @DeleteMapping("/{id_xyu}")
    public void deleteXyu(@PathVariable int id_xyu) {
        xyuService.deleteById(id_xyu);
    }
}
