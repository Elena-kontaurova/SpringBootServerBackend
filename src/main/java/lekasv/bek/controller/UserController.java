package lekasv.bek.controller;

import lekasv.bek.model.User;

import lekasv.bek.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/name/{name}")
    public User getAllByName(@PathVariable String name) {
        return userService.getByName(name);
    }

    @GetMapping("/{id_user}")
    public User getById(@PathVariable int id_user) {
        return userService.getById(id_user);
    }

    @GetMapping("/lastName/{last_name}")
    public List<User> getLastByName(@PathVariable String last_name) {
        return userService.getByLastName(last_name);
    }

    @GetMapping("/age/{age}")
    public List<User> getByAge(@PathVariable int age) {
        return userService.getByAge(age);
    }

    @PostMapping()
    public User postUser(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/{id_user}")
    public User puyUser(@RequestBody User user, @PathVariable int id_user) {
        return userService.update(user, id_user);
    }

    @DeleteMapping("/{id_user}")
    public void deleteUser(@PathVariable int id_user) {
        userService.deleteById(id_user);
    }
}
