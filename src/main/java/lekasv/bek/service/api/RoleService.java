package lekasv.bek.service.api;

import lekasv.bek.dto.role.CreateRoleRequest;
import lekasv.bek.dto.role.RoleResponse;
import lekasv.bek.dto.role.UpdateRoleRequest;

import java.util.List;

public interface RoleService {
    List<RoleResponse> getAll();
    RoleResponse create(CreateRoleRequest request);
    RoleResponse update(UpdateRoleRequest request, int id_role);
    void deleteById(int id_role);
    List<RoleResponse> getByRole(String role);
}
