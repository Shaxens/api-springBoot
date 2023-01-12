package fr.mns.arthur.repository;

import fr.mns.arthur.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
