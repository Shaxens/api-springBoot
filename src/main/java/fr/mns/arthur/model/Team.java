package fr.mns.arthur.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.mns.arthur.view.TeamView;
import fr.mns.arthur.view.UserView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "team")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({TeamView.class, UserView.class})
    private Long id;

    @Temporal(TemporalType.DATE)
    @JsonView({TeamView.class, UserView.class})
    private Date creatingDate;



    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    @JsonView(TeamView.class)
    private Set<User> userList = new HashSet<>();

    // External data

    // rendre cette propriété non null un chef doit être un utilisateur faisant partie de l'équipe
    @OneToOne
    @JoinColumn(nullable = false)
    @JsonView({TeamView.class, UserView.class})
    private User leader;


}
