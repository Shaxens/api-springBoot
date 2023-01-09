package fr.mns.arthur.repository;

import fr.mns.arthur.model.User;
import fr.mns.arthur.model.WorkStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkStationRepository extends JpaRepository<WorkStation, Long> {


}
