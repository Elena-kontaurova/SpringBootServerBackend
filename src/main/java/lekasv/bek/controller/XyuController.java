package lekasv.bek.controller;

import lekasv.bek.model.Xyu;
import lekasv.bek.repository.XyuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xuy")
@RequiredArgsConstructor
public class XyuController {
    private final XyuRepository xyuRepository;

    @GetMapping
    public List<Xyu> getAll() {
        return xyuRepository.findAll();
    }
    @GetMapping("/name/{name}")
    public Xyu getByName(@PathVariable String name) {
        return xyuRepository.findByName(name);
    }
    @GetMapping("/{id_xyu}")
    public Xyu getById(@PathVariable int id_xyu) {
        return xyuRepository.findById(id_xyu).get();
    }

    @PostMapping()
    public Xyu postXyu(@RequestBody Xyu xyu) {
        return xyuRepository.save(xyu);
    }

    @PutMapping("/{id_xyu}")
    public Xyu putXyu(@RequestBody Xyu xyu, @PathVariable int id_xyu) {
        Xyu xx = xyuRepository.findById(id_xyu).get();
        xx.setName(xyu.getName());
        xx.setAge(xyu.getAge());
        return xyuRepository.save(xx);
    }

    @DeleteMapping("/{id_xyu}")
    public void deleteXyu(@PathVariable int id_xyu) {
        xyuRepository.deleteById(id_xyu);
    }
}
