package pl.coderslab;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.role.Role;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;
import pl.coderslab.user.UserSecService;
import pl.coderslab.user.UserService;

import java.util.Collections;

@Controller
public class HomeController {
    private final UserSecService userSecService;
    private final UserRepository userRepository;
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    public HomeController(UserRepository userRepository, UserService userService, BCryptPasswordEncoder passwordEncoder, UserSecService userSecService){
        this.userRepository = userRepository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.userSecService = userSecService;
    }

    @GetMapping("/")
    public String homePage() { return "/home-page/landing-page"; }

    @GetMapping("/reservationForm")
    public String showReservationForm() { return "home-page/reservationForm"; }

    @GetMapping("/register")
    public String showRegisterForm(Model model){

        model.addAttribute("user", new User());
        return "home-page/register";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "home-page/register";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        user.setRoles(Collections.singleton(userRole));

        userSecService.saveUser(user);

        model.addAttribute("message", "Rejestracja przebiegła pomyślnie!");
        return "redirect:/login";
    }
}