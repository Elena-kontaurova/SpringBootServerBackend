package lekasv.bek.service.impl;

import lekasv.bek.dto.user.CreateUserRequest;
import lekasv.bek.dto.user.UpdateUserRequest;
import lekasv.bek.dto.user.UserResponse;
import lekasv.bek.exception.extended.user.UserNotFoundException;
import lekasv.bek.mapper.UserMapper;
import lekasv.bek.model.User;
import lekasv.bek.repository.UserRepository;
import lekasv.bek.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
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
    public UserResponse getById(Integer userId) {
        return userMapper.toUserResponse(userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new));
    }

    @Override
    public List<UserResponse> getByLastName(String last_name) {
        return userRepository.findByLastName(last_name)
                .stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

    @Override
    public List<UserResponse> getByAge(Integer age) {
        return userRepository.findByAge(age)
                .stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

    @Override
    public UserResponse create(CreateUserRequest request) {
        User user = userMapper.fromCreateUserRequest(request);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse update(UpdateUserRequest request, Integer userId) {
        User users = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
        userMapper.fromUpdateUserRequest(request, users);
        users.setUpdatedAt(LocalDateTime.now());
        userRepository.save(users);
        return userMapper.toUserResponse(users);
    }

    @Override
    public void deleteById(Integer userId) {
        userRepository.deleteById(userId);
    }
}
