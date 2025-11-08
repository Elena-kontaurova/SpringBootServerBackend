package lekasv.bek.controller;

import lekasv.bek.model.User;
import lekasv.bek.model.Xyu;
import lekasv.bek.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/name/{name}")
    public User getAllByName(@PathVariable String name) {
        return userRepository.findByName(name);
    }

    @GetMapping("/{id_user}")
    public User getById(@PathVariable int id_user) {
        return userRepository.findById(id_user).get();
    }

    @GetMapping("/lastName/{last_name}")
    public List<User> getLastByName(@PathVariable String last_name) {
        return userRepository.findByLastName(last_name);
    }

    @GetMapping("/age/{age}")
    public List<User> getByAge(@PathVariable int age) {
        return userRepository.findByAge(age);
    }

    @PostMapping()
    public User postUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id_user}")
    public User puyUser(@RequestBody User user, @PathVariable int id_user) {
        User users = userRepository.findById(id_user).get();
        users.setName(user.getName());
        users.setAge(user.getAge());
        users.setActive(user.getActive());
        return userRepository.save(users);
    }

    @DeleteMapping("/{id_user}")
    public void deleteUser(@PathVariable int id_user) {
        userRepository.deleteById(id_user);
    }

}
