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

    @GetMapping("/{userId}")
    public UserResponse getById(@PathVariable Integer userId) {
        return userService.getById(userId);
    }

    @GetMapping("/lastName/{last_name}")
    public List<UserResponse> getLastByName(@PathVariable String last_name) {
        return userService.getByLastName(last_name);
    }

    @GetMapping("/age/{age}")
    public List<UserResponse> getByAge(@PathVariable Integer age) {
        return userService.getByAge(age);
    }

    @PostMapping()
    public UserResponse postUser(@RequestBody CreateUserRequest request) {
        return userService.create(request);
    }

    @PutMapping("/{userId}")
    public UserResponse puyUser(@RequestBody UpdateUserRequest request, @PathVariable Integer userId) {
        return userService.update(request, userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteById(userId);
    }
}
