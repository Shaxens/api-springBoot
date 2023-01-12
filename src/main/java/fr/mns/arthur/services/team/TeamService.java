package fr.mns.arthur.services.team;

import fr.mns.arthur.model.Team;
import fr.mns.arthur.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface TeamService {

    Team createTeam(Team team, Long leaderId);

    List<Team> teamList();

    Team team(Long id);

    Team update(Long id, Team team);

    String deleteTeam(Long id);
}
