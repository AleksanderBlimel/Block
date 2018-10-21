package BlocgApplication.BlocgApplication.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor

public class Post {
    //id title content

    @Id // pole unikalne kolumne id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String content;

    @Embedded
    private AuditeEntity audit = new AuditeEntity();

    @OneToMany(mappedBy = "post" , cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<PostComment> comments = new HashSet<>();

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "userId")
    @Getter
    @Setter
    private User user;


    public void addComment(PostComment postComment) {
        comments.add(postComment);
        postComment.setPost(this);

    }
}

