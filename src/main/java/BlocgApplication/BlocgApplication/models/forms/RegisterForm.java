package BlocgApplication.BlocgApplication.models.forms;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;


@Getter
@Setter
public class RegisterForm {

    @Size( min =3, message = "Nazwa użytkowniak powinna zawierać min 3 znaki")

    private String userName;
    private String email;
    @Size( min = 6, max =15 ,message = "Nazwa użytkowniak powinna zawierać min 3 znaki")
    private String password;
}
