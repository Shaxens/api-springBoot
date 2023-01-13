package fr.mns.arthur.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.mns.arthur.model.Team;
import fr.mns.arthur.model.User;
import fr.mns.arthur.repository.TeamRepository;
import fr.mns.arthur.repository.UserRepository;
import fr.mns.arthur.services.team.TeamService;
import fr.mns.arthur.view.TeamView;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Boolean.*;

@RestController
@RequestMapping("/team")
@AllArgsConstructor
public class TeamController {

    private final TeamService teamService;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    @Transactional
    @PostMapping("/create")
    public Team createTeam(@RequestBody Team team, @RequestParam("leader") Long leaderId) {
        User leader = userRepository.findById(leaderId).orElse(null);
        if(leader != null) {
            Team existingTeam = teamRepository.findTeamByLeader(leader);
            if(existingTeam != null) {
                throw new IllegalArgumentException("This user is already leader of a team ! Please update the leader before.");
            } else {
                team.getUserList().add(leader);
                if (leader != null && team.getUserList().contains(leader)) {
                    team.setLeader(leader);
                    leader.setTeam(team);
                    isLeader(team, leader);
                } else if (!team.getUserList().contains(leader)){
                    throw new IllegalArgumentException("The selected leader is not a member of the team.");
                } else {
                    throw new IllegalArgumentException("The selected leader does not exist as User type !");
                }
            }
        } else {
            throw new IllegalArgumentException("The selected leader does not exist as User type !");
        }
        return teamRepository.save(team);
    }


    @GetMapping("/list")
    @JsonView({TeamView.class})
    public List<Team> teamList() {
        return teamService.teamList();
    }

    @GetMapping("/{id}")
    public Team userById(@PathVariable Long id) {
        return teamService.team(id);
    }

    @PutMapping("/update/{id}")
    public Team update(@PathVariable Long id,@RequestBody Team team) {
        User leader = userRepository.findById(id).orElse(null);
        if (leader != null) {
            isLeader(team, leader);
        }
        return teamService.update(id, team);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return teamService.deleteTeam(id);
    }


    // Other Methods

    private void isLeader(Team team, User leader) {
        if (team.getLeader().getId() == leader.getId()) {
            team.setIsLeader(TRUE);
        } else {
            team.setIsLeader(FALSE);
        }
    }


}
