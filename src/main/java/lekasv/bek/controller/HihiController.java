package lekasv.bek.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/geta")
public class HihiController {
    @GetMapping
    public Map<String, String> geta() {
        return Map.of("message", "Елена");
    }
}

