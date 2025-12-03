package lekasv.bek.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lekasv.bek.dto.user.CreateUserRequest;
import lekasv.bek.dto.user.UpdateUserRequest;
import lekasv.bek.dto.user.UserResponse;
import lekasv.bek.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Users", description = "API для управления пользователями")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "Получить всех пользователей", description = "Возвращает список всех пользователей")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @Operation(summary = "Поиск по имени", description = "Возвращает пользователей по частичному совпадению имени")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping("/name/{name}")
    public List<UserResponse> getAllByName(
            @Parameter(description = "Имя пользователя для поиска", required = true, example = "Иван")
            @PathVariable String name) {
        return userService.getByName(name);
    }

    @Operation(summary = "Получить пользователя по ID", description = "Возвращает пользователя по его идентификатору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping("/{userId}")
    public UserResponse getById(
            @Parameter(description = "ID пользователя", required = true, example = "1")
            @PathVariable Integer userId) {
        return userService.getById(userId);
    }

    @Operation(summary = "Поиск по фамилии", description = "Возвращает пользователей по частичному совпадению фамилии")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping("/lastName/{last_name}")
    public List<UserResponse> getLastByName(
            @Parameter(description = "Фамилия пользователя для поиска", required = true, example = "Иванов")
            @PathVariable String last_name) {
        return userService.getByLastName(last_name);
    }

    @Operation(summary = "Поиск по возрасту", description = "Возвращает пользователей указанного возраста")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping("/age/{age}")
    public List<UserResponse> getByAge(
            @Parameter(description = "Возраст пользователя", required = true, example = "25")
            @PathVariable Integer age) {
        return userService.getByAge(age);
    }

    @Operation(summary = "Создать пользователя", description = "Создает нового пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь создан"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "409", description = "Пользователь с таким email уже существует"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @PostMapping()
    public UserResponse postUser(@RequestBody CreateUserRequest request) {
        return userService.create(request);
    }

    @Operation(summary = "Обновить пользователя", description = "Обновляет информацию о пользователе")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь обновлен"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден"),
            @ApiResponse(responseCode = "409", description = "Пользователь с таким email уже существует"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @PutMapping("/{userId}")
    public UserResponse puyUser(
            @RequestBody UpdateUserRequest request,
            @Parameter(description = "ID пользователя", required = true, example = "1")
            @PathVariable Integer userId) {
        return userService.update(request, userId);
    }

    @Operation(summary = "Удалить пользователя", description = "Удаляет пользователя по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь удален"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @DeleteMapping("/{userId}")
    public void deleteUser(
            @Parameter(description = "ID пользователя", required = true, example = "1")
            @PathVariable Integer userId) {
        userService.deleteById(userId);
    }

    @PostMapping("authorization/{userName}/{password}")
    public UserResponse authorization(@PathVariable String userName, @PathVariable String password) {
        return userService.authorization(userName, password);
    }

    @PostMapping("registration/{userName}/{password}")
    public UserResponse registration(@PathVariable String userName, @PathVariable String password) {
        return userService.registration(userName, password);
    }
}