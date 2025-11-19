package lekasv.bek.service.api;

import jakarta.validation.Valid;
import lekasv.bek.dto.user.CreateUserRequest;
import lekasv.bek.dto.user.UpdateUserRequest;
import lekasv.bek.dto.user.UserResponse;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Validated
public interface UserService {
    List<UserResponse> getAll();
    List<UserResponse> getByName(String name);
    UserResponse getById(Integer userId);
    List<UserResponse> getByLastName(String last_name);
    List<UserResponse> getByAge(Integer ageId);
    UserResponse create(@Valid CreateUserRequest request);
    UserResponse update(@Valid UpdateUserRequest request, Integer userId);
    void deleteById(Integer userId);
}
