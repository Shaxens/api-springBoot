package fr.mns.arthur.services.user;

import fr.mns.arthur.model.User;
import fr.mns.arthur.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImplements implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }

    @Override
    public User user(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id + " . Please make sure this user exist."));
    }

    @Override
    public User update(Long id, User user) {
        return userRepository.findById(id).map(u -> {
            u.setFirstname(user.getFirstname());
            u.setLastname(user.getLastname());
            u.setMail(user.getMail());
            u.setPassword(user.getPassword());
            u.setWorkStation(user.getWorkStation());
            u.setRights(user.getRights());
            return userRepository.save(u);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "Warning : User "+ id + " has been deleted !";
    }
}
