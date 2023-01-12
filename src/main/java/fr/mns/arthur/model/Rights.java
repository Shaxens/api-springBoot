package fr.mns.arthur.model;

import com.fasterxml.jackson.annotation.*;
import fr.mns.arthur.view.RightsView;
import fr.mns.arthur.view.UserView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rights")
@Getter
@Setter
public class Rights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({RightsView.class, UserView.class})
    private Long id;

    @Column(length = 40, nullable = false)
    @JsonView({RightsView.class, UserView.class})
    private String label;

}
