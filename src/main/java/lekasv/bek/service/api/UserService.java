package lekasv.bek.service.api;

import lekasv.bek.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByName(String name);
    User findById(int id_user);
    List<User> findByLastName(String last_name);
    List<User> findByAge(int age);
    User save(User user);
    User save(User user, int id_user);
    void deleteById(int id_user);
}
