package lekasv.bek.controller;

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
    public List<Role> getAll() {
        return roleService.getAll();
    }

    @PostMapping
    public Role create(@RequestBody Role role) {
        return roleService.create(role);
    }

    @PutMapping("/{id_role}")
    public Role updateRole(@RequestBody Role role, @PathVariable int id_role) {
        return roleService.update(role, id_role);
    }

    @DeleteMapping("/{id_role}")
    public void deleteRole(@PathVariable int id_role) {
        roleService.deleteById(id_role);
    }

    @GetMapping("/rol/{role}")
    public List<Role> getAllByRole(@PathVariable String role) {
        return roleService.getByRole(role);
    }
}
