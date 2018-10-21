package BlocgApplication.BlocgApplication.Controllers;

import BlocgApplication.BlocgApplication.repositories.UserRepository;
import BlocgApplication.BlocgApplication.services.UserSessionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserRepository userRepository;
    private UserSessionService userSessionService;
    private ModelMapper modelMapper;



@Autowired
    public UserController(UserRepository userRepository, UserSessionService userSessionService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userSessionService = userSessionService;
        this.modelMapper = modelMapper;
    }

}
