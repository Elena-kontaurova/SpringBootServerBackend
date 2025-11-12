package lekasv.bek.mapper;

import lekasv.bek.dto.user.CreateUserRequest;
import lekasv.bek.dto.user.UpdateUserRequest;
import lekasv.bek.dto.user.UserResponse;
import lekasv.bek.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User fromCreateUserRequest(CreateUserRequest request);
    void fromUpdateUserRequest(UpdateUserRequest request,@MappingTarget User user);
    UserResponse toUserResponse(User user);
}
