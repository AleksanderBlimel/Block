package BlocgApplication.BlocgApplication.models.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class AuditeEntity {

    private Date added = new Date();
    private String addedBy;
    private Date modified;
    private String modifiedBy;

}
