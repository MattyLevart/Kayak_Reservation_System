package pl.coderslab.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.role.Role;

import java.awt.print.Book;
import java.security.Principal;
import java.util.Collections;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, UserService userService, BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping("/home")
    public String showList(Model model, Principal principal){
        String username = principal.getName();
        User user = userService.findByEmail(username);
        model.addAttribute("user", user);
        return "user/home";
    }

    @GetMapping("/reservations")
    public String showUserReservations(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findByEmail(username);
        model.addAttribute("reservations", user.getReservations());
        return "user/reservations";
    }

    @GetMapping("/edit")
    public String showUserEditForm(Model model, Principal principal){
        String username = principal.getName();
        User user = userService.findByEmail(username);
        model.addAttribute("user", user);
        return "user/form";
    }
    @PostMapping("/edit")
    public String editUser(@ModelAttribute User user, Principal principal){
        String username = principal.getName();
        User existingUser = userService.findByEmail(username);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setPhone(user.getPhone());
        userService.save(existingUser);
        return "redirect:/user/home";
    }
    @RequestMapping("/delete")
    public String deleteUserAccount(Principal principal){
        String username = principal.getName();
        userService.deleteByEmail(username);
        return "redirect:/logout";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
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

        userService.save(user);

        model.addAttribute("message", "Rejestracja przebiegła pomyślnie!");
        return "redirect:/login";
    }

}

