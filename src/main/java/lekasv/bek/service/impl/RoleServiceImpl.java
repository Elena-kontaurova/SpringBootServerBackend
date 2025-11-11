package lekasv.bek.service.impl;

import lekasv.bek.model.Role;
import lekasv.bek.repository.RoleRepository;
import lekasv.bek.service.api.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role create(Role role) {
        if (role.getRole() == null || role.getRole().isEmpty()) {
            throw new IllegalArgumentException("Role is null");
        }
        return roleRepository.save(role);
    }

    @Override
    public Role update(Role role, int id_role) {
        if (role.getRole() == null || role.getRole().isEmpty()) {
            throw new IllegalArgumentException("Role is null");
        }
        Role roles = roleRepository.findById(id_role).get();
        roles.setRole(role.getRole());
        return roleRepository.save(roles);
    }

    @Override
    public void deleteById(int id_role) {
        roleRepository.deleteById(id_role);
    }

    @Override
    public List<Role> getByRole(String role) {
        return roleRepository.findByRole(role);
    }
}
