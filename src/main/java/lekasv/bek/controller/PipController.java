package lekasv.bek.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/pole")

public class PipController {
    @GetMapping
    public Map<String, String> pole() {
        return Map.of("mes", "Это мой веб сайт");
    }
    @GetMapping("/lox")
    public Map<String, String> poleLox() {
        return Map.of("mes", "А вот тут щас поебемся");
    }
}
