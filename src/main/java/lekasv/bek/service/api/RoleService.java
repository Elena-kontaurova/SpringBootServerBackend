package lekasv.bek.service.api;

import lekasv.bek.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    Role create(Role role);
    Role update(Role role, int id_role);
    void deleteById(int id_role);
    List<Role> getByRole(String role);
}
