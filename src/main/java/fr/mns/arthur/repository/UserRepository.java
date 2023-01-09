package fr.mns.arthur.repository;

import fr.mns.arthur.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
