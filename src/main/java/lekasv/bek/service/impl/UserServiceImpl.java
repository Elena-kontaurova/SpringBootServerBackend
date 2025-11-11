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
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User findById(int id_user) {
        return userRepository.findById(id_user).get();
    }

    @Override
    public List<User> findByLastName(String last_name) {
        return userRepository.findByLastName(last_name);
    }

    @Override
    public List<User> findByAge(int age) {
        return userRepository.findByAge(age);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User save(User user, int id_user) {
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
