package lekasv.bek.service.impl;

import lekasv.bek.dto.user.CreateUserRequest;
import lekasv.bek.dto.user.UpdateUserRequest;
import lekasv.bek.dto.user.UserResponse;
import lekasv.bek.mapper.UserMapper;
import lekasv.bek.model.User;
import lekasv.bek.repository.RoleRepository;
import lekasv.bek.repository.UserRepository;
import lekasv.bek.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

    @Override
    public List<UserResponse> getByName(String name) {
        return userRepository.findByName(name)
                .stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

    @Override
    public UserResponse getById(int id_user) {
        return userMapper.toUserResponse(userRepository.findById(id_user).get());
    }

    @Override
    public List<UserResponse> getByLastName(String last_name) {
        return userRepository.findByLastName(last_name)
                .stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

    @Override
    public List<UserResponse> getByAge(int age) {
        return userRepository.findByAge(age)
                .stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

    @Override
    public UserResponse create(CreateUserRequest request) {
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new IllegalArgumentException("Name is null");
        }
        if (request.getLastName() == null || request.getLastName().isEmpty()) {
            throw new IllegalArgumentException("LastName is null");
        }
        if (request.getAge() < 0 || request.getAge() > 100) {
            throw new IllegalArgumentException("Age must be between 0 and 100");
        }
        if (request.getRoleId() == null ) {
            throw new IllegalArgumentException("Role is null");
        }
        if (!roleRepository.existsById(request.getRoleId())) {
            throw new IllegalArgumentException("Role not found");
        }
        User user = userMapper.fromCreateUserRequest(request);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse update(UpdateUserRequest request, int id_user) {
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new IllegalArgumentException("Name is null");
        }
        if (request.getLastName() == null || request.getLastName().isEmpty()) {
            throw new IllegalArgumentException("LastName is null");
        }
        if (request.getAge() < 0 || request.getAge() > 100) {
            throw new IllegalArgumentException("Age must be between 0 and 100");
        }
        if (request.getRoleId() == null ) {
            throw new IllegalArgumentException("Role is null");
        }
        if (!roleRepository.existsById(request.getRoleId())) {
            throw new IllegalArgumentException("Role not found");
        }
        User users = userRepository.findById(id_user).get();
        userMapper.fromUpdateUserRequest(request, users);
        userRepository.save(users);
        return userMapper.toUserResponse(users);
    }

    @Override
    public void deleteById(int id_user) {
        userRepository.deleteById(id_user);
    }
}
