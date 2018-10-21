package BlocgApplication.BlocgApplication.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String comment;

    @Embedded
    private AuditeEntity audit = new AuditeEntity();

    @ManyToOne
    @JoinColumn(name = "postid")
    private Post post;

}
