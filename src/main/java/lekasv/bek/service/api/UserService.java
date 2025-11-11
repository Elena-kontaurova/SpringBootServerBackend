package lekasv.bek.service.api;

import lekasv.bek.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getByName(String name);
    User getById(int id_user);
    List<User> getByLastName(String last_name);
    List<User> getByAge(int age);
    User create(User user);
    User update(User user, int id_user);
    void deleteById(int id_user);
}
