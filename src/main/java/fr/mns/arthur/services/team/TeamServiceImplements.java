package fr.mns.arthur.services.team;

import fr.mns.arthur.model.Team;
import fr.mns.arthur.model.User;
import fr.mns.arthur.repository.TeamRepository;
import fr.mns.arthur.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class TeamServiceImplements implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Team createTeam(Team team, Long leaderId) {
        User leader = userRepository.findById(leaderId).
                orElseThrow(() -> new EntityNotFoundException("User not found with id " + leaderId));
        team.setLeader(leader);
        return teamRepository.save(team);
    }

    @Override
    public List<Team> teamList() {
        return teamRepository.findAll();
    }

    @Override
    public Team team(Long id) {
        return teamRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Team not found with ID: " + id + " . Please make sure this team exist."));
    }

    @Override
    public Team update(Long id, Team team) {
        return teamRepository.findById(id).map(t -> {
            t.setCreatingDate(team.getCreatingDate());
            t.setLeader(team.getLeader());
            return teamRepository.save(t);
        }).orElseThrow(() -> new RuntimeException("Team not found"));
    }

    @Override
    public String deleteTeam(Long id) {
        teamRepository.deleteById(id);
        return "Warning : Team "+ id + " has been deleted !";
    }
}
