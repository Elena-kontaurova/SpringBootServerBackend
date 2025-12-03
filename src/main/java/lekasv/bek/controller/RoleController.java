package lekasv.bek.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lekasv.bek.dto.role.CreateRoleRequest;
import lekasv.bek.dto.role.RoleResponse;
import lekasv.bek.dto.role.UpdateRoleRequest;
import lekasv.bek.service.api.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Role", description = "API для управления ролями пользователей")
@RequiredArgsConstructor
@RequestMapping("/role")
@RestController
public class RoleController {
    private final RoleService roleService;

    @Operation(
            summary = "Получить все роли",
            description = "Возвращает список всех доступных ролей в системе"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешное получение списка ролей"
            ),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @GetMapping
    public List<RoleResponse> getAll() {
        return roleService.getAll();
    }

    @Operation(
            summary = "Создать новую роль",
            description = "Создает новую роль в системе"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Роль успешно создана"
            ),
            @ApiResponse(responseCode = "400", description = "Неверные входные данные"),
            @ApiResponse(responseCode = "409", description = "Роль с таким именем уже существует"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @PostMapping
    public RoleResponse create(@RequestBody CreateRoleRequest request) {
        return roleService.create(request);
    }

    @Operation(
            summary = "Обновить роль",
            description = "Обновляет информацию о существующей роли по её ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Роль успешно обновлена"
            ),
            @ApiResponse(responseCode = "400", description = "Неверные входные данные"),
            @ApiResponse(responseCode = "404", description = "Роль не найдена"),
            @ApiResponse(responseCode = "409", description = "Роль с таким именем уже существует"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @PutMapping("/{roleId}")
    public RoleResponse updateRole(@RequestBody UpdateRoleRequest request, @PathVariable Integer roleId) {
        return roleService.update(request, roleId);
    }

    @Operation(
            summary = "Удалить роль",
            description = "Удаляет роль по её ID. Внимание: удаление роли может повлиять на пользователей, имеющих эту роль."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Роль успешно удалена"),
            @ApiResponse(responseCode = "404", description = "Роль не найдена"),
            @ApiResponse(responseCode = "409", description = "Невозможно удалить роль, так как она используется пользователями"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @DeleteMapping("/{roleId}")
    public void deleteRole(@PathVariable Integer roleId) {
        roleService.deleteById(roleId);
    }

    @Operation(
            summary = "Поиск ролей по названию",
            description = "Возвращает список ролей, соответствующих указанному названию (частичное совпадение)"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешный поиск ролей"
            ),
            @ApiResponse(responseCode = "404", description = "Роли не найдены"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    @GetMapping("/rol/{role}")
    public List<RoleResponse> getAllByRole(@PathVariable String role) {
        return roleService.getByRole(role);
    }
}
