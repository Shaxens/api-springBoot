package fr.mns.arthur.services.user;

import fr.mns.arthur.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> userList();

    User user(Long id);

    User update(Long id, User user);

    String deleteUser(Long id);
}
