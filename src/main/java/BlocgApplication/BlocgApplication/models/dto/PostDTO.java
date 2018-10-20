package BlocgApplication.BlocgApplication.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor // daje nam konstruktor który zawiera wszystkie
public class PostDTO {

    private Long id;
    private String title;
    private String content;
    private Long idOfUser;
    private Date created;
}
