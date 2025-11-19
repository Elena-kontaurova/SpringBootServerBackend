package lekasv.bek.service.impl;

import lekasv.bek.dto.role.CreateRoleRequest;
import lekasv.bek.dto.role.RoleResponse;
import lekasv.bek.dto.role.UpdateRoleRequest;
import lekasv.bek.mapper.RoleMapper;
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
    private final RoleMapper roleMapper;

    @Override
    public List<RoleResponse> getAll() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toRoleResponse)
                .toList();
    }

    @Override
    public RoleResponse create(CreateRoleRequest request) {
        if (request.getRole() == null || request.getRole().isEmpty()) {
            throw new IllegalArgumentException("Role is null");
        }
        Role role = roleMapper.fromCreateRoleRequest(request);
        roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    @Override
    public RoleResponse update(UpdateRoleRequest request, Integer roleId) {
        if (request.getRole() == null || request.getRole().isEmpty()) {
            throw new IllegalArgumentException("Role is null");
        }
        Role roles = roleRepository.findById(roleId).get();
        roles.setRole(request.getRole());
        roleRepository.save(roles);
        return roleMapper.toRoleResponse(roles);
    }

    @Override
    public void deleteById(Integer roleId) {
        roleRepository.deleteById(roleId);
    }

    @Override
    public List<RoleResponse> getByRole(String role) {
        return roleRepository.findByRole(role)
                .stream()
                .map(roleMapper::toRoleResponse)
                .toList();
    }
}
