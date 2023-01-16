package fr.mns.arthur.model;

import com.fasterxml.jackson.annotation.JsonView;
import fr.mns.arthur.view.ProjectView;
import fr.mns.arthur.view.UserView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project")
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({ProjectView.class, UserView.class})
    private Long id;

    @Column(length = 40, nullable = false)
    @JsonView({ProjectView.class, UserView.class})
    private String title;

    @JsonView(ProjectView.class)
    private String description;

    @Temporal(TemporalType.DATE)
    @JsonView(ProjectView.class)
    private Date startingDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonView(ProjectView.class)
    Team team;

}
