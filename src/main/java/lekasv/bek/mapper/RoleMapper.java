package lekasv.bek.mapper;

import lekasv.bek.dto.role.CreateRoleRequest;
import lekasv.bek.dto.role.RoleResponse;
import lekasv.bek.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role fromCreateRoleRequest(CreateRoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
