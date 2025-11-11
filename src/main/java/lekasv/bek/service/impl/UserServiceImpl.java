package lekasv.bek.service.impl;

import lekasv.bek.model.User;
import lekasv.bek.repository.UserRepository;
import lekasv.bek.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User getById(int id_user) {
        return userRepository.findById(id_user).get();
    }

    @Override
    public List<User> getByLastName(String last_name) {
        return userRepository.findByLastName(last_name);
    }

    @Override
    public List<User> getByAge(int age) {
        return userRepository.findByAge(age);
    }

    @Override
    public User create(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("Name is null");
        }
        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            throw new IllegalArgumentException("LastName is null");
        }
        if (user.getAge() < 0 || user.getAge() > 100) {
            throw new IllegalArgumentException("Age must be between 0 and 100");
        }
        if (user.getRole() == null ) {
            throw new IllegalArgumentException("Role is null");
        }
        return userRepository.save(user);
    }

    @Override
    public User update(User user, int id_user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("Name is null");
        }
        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            throw new IllegalArgumentException("LastName is null");
        }
        if (user.getAge() < 0 || user.getAge() > 100) {
            throw new IllegalArgumentException("Age must be between 0 and 100");
        }
        if (user.getRole() == null ) {
            throw new IllegalArgumentException("Role is null");
        }
        User users = userRepository.findById(id_user).get();
        users.setName(user.getName());
        users.setAge(user.getAge());
        users.setActive(user.getActive());
        return userRepository.save(users);
    }

    @Override
    public void deleteById(int id_user) {
        userRepository.deleteById(id_user);
    }
}
