package pl.coderslab;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.reservation.Reservation;
import pl.coderslab.reservation.ReservationRepository;
import pl.coderslab.role.Role;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;
import pl.coderslab.user.UserSecService;
import pl.coderslab.user.UserService;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class HomeController {
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    public HomeController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String homePage() {
        return "/home-page/landing-page";
    }


    @GetMapping("/register")
    public String showRegisterForm(Model model) {

        model.addAttribute("user", new User());
        return "home-page/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "home-page/register";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (userService.emailExists(user.getEmail())) {
            result.rejectValue("email", "error.user", "Podany email już istnieje");
            return "home-page/register";
        }

        userService.save(user);
        return "redirect:/login";


    }
}