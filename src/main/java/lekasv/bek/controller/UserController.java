package lekasv.bek.controller;

import io.swagger.v3.oas.annotations.Parameter;
import lekasv.bek.dto.user.CreateUserRequest;
import lekasv.bek.dto.user.UpdateUserRequest;
import lekasv.bek.dto.user.UserResponse;
import lekasv.bek.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public List<UserResponse> getAllByName(
            @Parameter(description = "Имя пользователя для поиска", required = true, example = "Иван")
            @PathVariable String name) {
        return userService.getByName(name);
    }

    @GetMapping("/{userId}")
    public UserResponse getById(
            @Parameter(description = "ID пользователя", required = true, example = "1")
            @PathVariable Integer userId) {
        return userService.getById(userId);
    }

    @GetMapping("/lastName/{last_name}")
    public List<UserResponse> getLastByName(
            @Parameter(description = "Фамилия пользователя для поиска", required = true, example = "Иванов")
            @PathVariable String last_name) {
        return userService.getByLastName(last_name);
    }

    @GetMapping("/age/{age}")
    public List<UserResponse> getByAge(
            @Parameter(description = "Возраст пользователя", required = true, example = "25")
            @PathVariable Integer age) {
        return userService.getByAge(age);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping()
    public UserResponse postUser(@RequestBody CreateUserRequest request) {
        return userService.create(request);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/{userId}")
    public UserResponse puyUser(
            @RequestBody UpdateUserRequest request,
            @Parameter(description = "ID пользователя", required = true, example = "1")
            @PathVariable Integer userId) {
        return userService.update(request, userId);
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{userId}")
    public void deleteUser(
            @Parameter(description = "ID пользователя", required = true, example = "1")
            @PathVariable Integer userId) {
        userService.deleteById(userId);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("authorization/{userName}/{password}")
    public UserResponse authorization(@PathVariable String userName, @PathVariable String password) {
        return userService.authorization(userName, password);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("registration/{userName}/{password}")
    public UserResponse registration(@PathVariable String userName, @PathVariable String password) {
        return userService.registration(userName, password);
    }
}