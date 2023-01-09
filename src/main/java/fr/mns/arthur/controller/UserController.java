package fr.mns.arthur.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.mns.arthur.model.User;
import fr.mns.arthur.services.user.UserService;
import fr.mns.arthur.view.UserView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/list")
    @JsonView(UserView.class)
    public List<User> userList() {
        return userService.userList();
    }

    @GetMapping("/{id}")
    public User userById(@PathVariable Long id) {
        return userService.user(id);
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable Long id,@RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

}
