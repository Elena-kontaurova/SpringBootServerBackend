package lekasv.bek.controller;

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
    public List<Xyu> getAll() {
        return xyuService.getAll();
    }

    @GetMapping("/name/{name}")
    public Xyu getByName(@PathVariable String name) {
        return xyuService.getByName(name);
    }

    @GetMapping("/{id_xyu}")
    public Xyu getById(@PathVariable int id_xyu) {
        return xyuService.getById(id_xyu);
    }

    @PostMapping()
    public Xyu postXyu(@RequestBody Xyu xyu) {
        return xyuService.create(xyu);
    }

    @PutMapping("/{id_xyu}")
    public Xyu putXyu(@RequestBody Xyu xyu, @PathVariable int id_xyu) {
        return xyuService.update(xyu, id_xyu);
    }

    @DeleteMapping("/{id_xyu}")
    public void deleteXyu(@PathVariable int id_xyu) {
        xyuService.deleteById(id_xyu);
    }
}
