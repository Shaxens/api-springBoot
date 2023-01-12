package fr.mns.arthur.model;

import com.fasterxml.jackson.annotation.*;
import fr.mns.arthur.view.UserView;
import fr.mns.arthur.view.WorkStationView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "work_station")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class WorkStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({WorkStationView.class, UserView.class})
    private Long id;

    @Column(nullable = false)
    @JsonView({WorkStationView.class, UserView.class})
    String title;

    @Column(nullable = false)
    @JsonView({WorkStationView.class, UserView.class})
    String description;

    @OneToMany(mappedBy = "workStation")
    @JsonView(WorkStationView.class)
    private Set<User> userList = new HashSet<>();
}
