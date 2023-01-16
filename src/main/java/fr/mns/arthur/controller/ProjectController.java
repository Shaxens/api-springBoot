package fr.mns.arthur.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.mns.arthur.model.Project;
import fr.mns.arthur.model.Team;
import fr.mns.arthur.model.User;
import fr.mns.arthur.repository.ProjectRepository;
import fr.mns.arthur.repository.TeamRepository;
import fr.mns.arthur.services.project.ProjectService;
import fr.mns.arthur.view.ProjectView;
import fr.mns.arthur.view.TeamView;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final TeamRepository teamRepository;
    private final ProjectRepository projectRepository;

    @Transactional
    @PostMapping("/create")
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }


    @GetMapping("/list")
    @JsonView(ProjectView.class)
    public List<Project> projectList() {
        return projectService.projectList();
    }

    @GetMapping("/{id}")
    public Project projectById(@PathVariable Long id) {
        return projectService.project(id);
    }

    @PutMapping("/update/{id}")
    public Project updateLeader(@PathVariable Long id,@RequestBody Project project) {
        return project;
    }

    @PutMapping("/add/{id}")
    public Project addUser(@PathVariable Long id, @RequestBody Project project) {
        /*Team team = teamRepository.findById(id).orElse(null);
        User userToAdd = userRepository.findById(user.getId()).orElse(null);

        if (userToAdd == null) {
            throw new IllegalArgumentException("The selected user doesn't exist !");
        } else if (userToAdd.getTeam() != null) {
            throw new IllegalArgumentException("The selected user is part of a team.");
        } else {
            if (team != null) {
                team.getUserList().add(userToAdd);
                userToAdd.setTeam(team);
                return teamRepository.save(team);
            } else {
                throw new NullPointerException("Team is null !");
            }
        }*/
        return project;
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public String deleteTeam(@PathVariable Long id) {
        /*Team team = teamRepository.findById(id).orElse(null);
        if (team == null) {
            return "Team not found";
        }
        team.getLeader().setTeam(null);
        team.getUserList().clear();
        teamRepository.deleteById(id);*/
        return "project deleted";
    }

}
