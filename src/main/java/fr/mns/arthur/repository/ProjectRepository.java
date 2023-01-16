package fr.mns.arthur.repository;

import fr.mns.arthur.model.Project;
import fr.mns.arthur.model.Team;
import fr.mns.arthur.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {


}
