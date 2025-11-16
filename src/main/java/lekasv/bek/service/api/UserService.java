package lekasv.bek.service.api;

import lekasv.bek.dto.user.CreateUserRequest;
import lekasv.bek.dto.user.UpdateUserRequest;
import lekasv.bek.dto.user.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAll();
    List<UserResponse> getByName(String name);
    UserResponse getById(int id_user);
    List<UserResponse> getByLastName(String last_name);
    List<UserResponse> getByAge(int age);
    UserResponse create(CreateUserRequest request);
    UserResponse update(UpdateUserRequest request, int id_user);
    void deleteById(int id_user);
}
