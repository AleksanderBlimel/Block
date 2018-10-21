package BlocgApplication.BlocgApplication.Controllers;

import BlocgApplication.BlocgApplication.models.entities.User;
import BlocgApplication.BlocgApplication.models.forms.LoginForm;
import BlocgApplication.BlocgApplication.models.forms.RegisterForm;
import BlocgApplication.BlocgApplication.repositories.UserRepository;
import BlocgApplication.BlocgApplication.services.UserSessionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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

    @GetMapping("/register")
    public String registerPage(Model model){
    model.addAttribute("registerForm", new RegisterForm());
    return "register";
    }
    @PostMapping("/register")
    public String  registerUser(@ModelAttribute @Valid RegisterForm registerForm, BindingResult bindingResult){
    if (bindingResult.hasErrors()){
        System.out.println("Nie udało sie zalogowac");
        return "register";
    }
        User user = modelMapper.map(registerForm, User.class);
        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    userRepository.save(user);
    return "index";
    }

    @GetMapping("/login")
    public String loginPage (Model model){
    model.addAttribute("loginForm", new LoginForm());
    return "login";
    }
    @PostMapping("/login")
    public String loginUser(@ModelAttribute @Valid LoginForm loginForm, BindingResult bindingResult, Model model){

    boolean logged = userSessionService.loginUser(loginForm.getUserName(), loginForm.getPassword());
    if (!logged){
        bindingResult.rejectValue("userName",null,"User nie istnieje");
    }
    if(bindingResult.hasErrors()){
        return "login";
    }
    model.addAttribute("loggedUser", logged);
    return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        userSessionService.logout();
        return "redirect:/login";
    }
}
