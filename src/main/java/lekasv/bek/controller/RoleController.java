package lekasv.bek.controller;

import lekasv.bek.dto.role.CreateRoleRequest;
import lekasv.bek.dto.role.RoleResponse;
import lekasv.bek.dto.role.UpdateRoleRequest;
import lekasv.bek.model.Role;
import lekasv.bek.service.api.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/role")
@RestController
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public List<RoleResponse> getAll() {
        return roleService.getAll();
    }

    @PostMapping
    public RoleResponse create(@RequestBody CreateRoleRequest request) {
        return roleService.create(request);
    }

    @PutMapping("/{id_role}")
    public RoleResponse updateRole(@RequestBody UpdateRoleRequest request, @PathVariable int id_role) {
        return roleService.update(request, id_role);
    }

    @DeleteMapping("/{id_role}")
    public void deleteRole(@PathVariable int id_role) {
        roleService.deleteById(id_role);
    }

    @GetMapping("/rol/{role}")
    public List<RoleResponse> getAllByRole(@PathVariable String role) {
        return roleService.getByRole(role);
    }
}
