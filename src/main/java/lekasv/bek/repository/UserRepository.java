package lekasv.bek.repository;

import lekasv.bek.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByName(String name);
    List<User> findByLastName(String lastName);
    List<User> findByAge(Integer age);
    User findByUserNameAndPassword(String userName, String password);
}
