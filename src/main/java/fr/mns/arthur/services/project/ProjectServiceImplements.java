package fr.mns.arthur.services.project;

import fr.mns.arthur.model.Project;
import fr.mns.arthur.model.Team;
import fr.mns.arthur.model.User;
import fr.mns.arthur.repository.ProjectRepository;
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
public class ProjectServiceImplements implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> projectList() {
        return projectRepository.findAll();
    }

    @Override
    public Project project(Long id) {
        return projectRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + id + " . Please make sure this project exist."));
    }

    @Override
    public Project update(Long id, Project project) {
        return null;
    }

    @Override
    public String deleteProject(Long id) {
        return null;
    }
}
