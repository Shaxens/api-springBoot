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
    private final ProjectRepository projectRepository;

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
        return projectRepository.findById(id).orElse(null);
    }

    @PutMapping("/update/{id}")
    public Project updateLeader(@PathVariable Long id,@RequestBody Project project) {
        return projectService.update(id, project);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public String deleteTeam(@PathVariable Long id) {
        projectService.deleteProject(id);
        return "project deleted";
    }

}
