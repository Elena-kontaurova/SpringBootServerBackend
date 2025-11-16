package lekasv.bek.controller;

import lekasv.bek.dto.user.CreateUserRequest;
import lekasv.bek.dto.user.UpdateUserRequest;
import lekasv.bek.dto.user.UserResponse;
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
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @GetMapping("/name/{name}")
    public List<UserResponse> getAllByName(@PathVariable String name) {
        return userService.getByName(name);
    }

    @GetMapping("/{id_user}")
    public UserResponse getById(@PathVariable int id_user) {
        return userService.getById(id_user);
    }

    @GetMapping("/lastName/{last_name}")
    public List<UserResponse> getLastByName(@PathVariable String last_name) {
        return userService.getByLastName(last_name);
    }

    @GetMapping("/age/{age}")
    public List<UserResponse> getByAge(@PathVariable int age) {
        return userService.getByAge(age);
    }

    @PostMapping()
    public UserResponse postUser(@RequestBody CreateUserRequest request) {
        return userService.create(request);
    }

    @PutMapping("/{id_user}")
    public UserResponse puyUser(@RequestBody UpdateUserRequest request, @PathVariable int id_user) {
        return userService.update(request, id_user);
    }

    @DeleteMapping("/{id_user}")
    public void deleteUser(@PathVariable int id_user) {
        userService.deleteById(id_user);
    }
}
