package fr.mns.arthur.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.mns.arthur.model.Team;
import fr.mns.arthur.model.User;
import fr.mns.arthur.repository.TeamRepository;
import fr.mns.arthur.repository.UserRepository;
import fr.mns.arthur.services.team.TeamService;
import fr.mns.arthur.view.TeamView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
@AllArgsConstructor
public class TeamController {

    private final TeamService teamService;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    @PostMapping("/create")
    public Team createTeam(@RequestBody Team team, @RequestParam("leader") Long leaderId) {
        User leader = userRepository.findById(leaderId).orElse(null);
        team.getUserList().add(leader);
        if (leader != null && team.getUserList().contains(leader)) {
            team.setLeader(leader);
        } else {
            throw new IllegalArgumentException("The selected leader is not a member of the team.");
        }
        return teamRepository.save(team);
    }

    @GetMapping("/list")
    @JsonView(TeamView.class)
    public List<Team> userList() {
        return teamService.teamList();
    }

    @GetMapping("/{id}")
    public Team userById(@PathVariable Long id) {
        return teamService.team(id);
    }

    @PutMapping("/update/{id}")
    public Team update(@PathVariable Long id,@RequestBody Team team) {
        return teamService.update(id, team);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return teamService.deleteTeam(id);
    }

}
