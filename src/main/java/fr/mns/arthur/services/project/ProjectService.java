package fr.mns.arthur.services.project;

import fr.mns.arthur.model.Project;
import fr.mns.arthur.model.Team;

import java.util.List;

public interface ProjectService {

    Project createProject(Project project);

    List<Project> projectList();

    Project project(Long id);

    Project update(Long id, Project project);

    String deleteProject(Long id);
}
