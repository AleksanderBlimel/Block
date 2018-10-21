package BlocgApplication.BlocgApplication.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.Generated;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String email;
    private String password;

    @Embedded
    private AuditeEntity auditeEntity = new AuditeEntity();
}
