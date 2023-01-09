package fr.mns.arthur.model;

import com.fasterxml.jackson.annotation.JsonView;
import fr.mns.arthur.view.UserView;
import fr.mns.arthur.view.WorkStationView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(UserView.class)
    private Long id;

    @Column(length = 50)
    @JsonView(UserView.class)
    private String lastname;

    @Column(length = 50)
    @JsonView(UserView.class)
    private String firstname;

    @Column(length = 80)
    @JsonView(UserView.class)
    private String mail;

    @Column(length = 50)
    @JsonView(UserView.class)
    private String password;

    @Temporal(TemporalType.DATE)
    @JsonView(UserView.class)
    private Date effectiveDate;

    // external data

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonView(UserView.class)
    private WorkStation workStation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonView(UserView.class)
    private Rights rights;

}
