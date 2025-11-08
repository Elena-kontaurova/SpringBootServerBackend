package lekasv.bek.controller;

import lekasv.bek.model.Role;
import lekasv.bek.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/role")
@RestController
public class RoleController {
    private final RoleRepository roleRepository;

    @GetMapping
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @PostMapping
    public Role save(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    @PutMapping("/{id_role}")
    public Role updateRole(@RequestBody Role role, @PathVariable int id_role) {
        Role roles = roleRepository.findById(id_role).get();
        roles.setRole(role.getRole());
        return roleRepository.save(roles);
    }

    @DeleteMapping("/{id_role}")
    public void deleteRole(@PathVariable int id_role) {
        roleRepository.deleteById(id_role);
    }
}
