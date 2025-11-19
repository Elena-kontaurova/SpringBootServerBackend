package lekasv.bek.service.api;

import jakarta.validation.Valid;
import lekasv.bek.dto.role.CreateRoleRequest;
import lekasv.bek.dto.role.RoleResponse;
import lekasv.bek.dto.role.UpdateRoleRequest;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Validated
public interface RoleService {
    List<RoleResponse> getAll();
    RoleResponse create(@Valid CreateRoleRequest request);
    RoleResponse update(@Valid UpdateRoleRequest request, Integer roleId);
    void deleteById(Integer roleId);
    List<RoleResponse> getByRole(String role);
}
