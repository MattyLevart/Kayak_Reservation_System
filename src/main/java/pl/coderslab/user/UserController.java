package pl.coderslab.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.reservation.Reservation;
import pl.coderslab.reservation.ReservationService;
import pl.coderslab.role.Role;

import java.awt.print.Book;
import java.security.Principal;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserSecService userSecService;
    private final UserRepository userRepository;
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ReservationService reservationService;

    public UserController(UserRepository userRepository, UserService userService, BCryptPasswordEncoder passwordEncoder, UserSecService userSecService, ReservationService reservationService){
        this.userRepository = userRepository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.userSecService = userSecService;
        this.reservationService = reservationService;
    }
    @GetMapping("/home")
    public String showList(Model model, Principal principal, @AuthenticationPrincipal UserDetails userDetails){
        List<Reservation> nextReservations = reservationService.findNextTreeReservations(userDetails);
        String username = principal.getName();
        User user = userService.findByEmail(username);
        model.addAttribute("user", user);
        model.addAttribute("reservs", nextReservations);
        return "user/home";
    }
    @GetMapping("/details")
    public String showUserDetails(Model model, Principal principal){
        String username = principal.getName();
        User user = userService.findByEmail(username);
        model.addAttribute("user", user);
        return "user/list";
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
    public String editUser(@ModelAttribute User user, @AuthenticationPrincipal UserDetails userDetails){
        userService.update(user, userDetails);
        return "redirect:/user/home";
    }
    @RequestMapping("/delete")
    public String deleteUserAccount(Principal principal){
        String username = principal.getName();
        userService.deleteByEmail(username);
        return "redirect:/";
    }

//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new User());
//        return "home-page/register";
//    }
//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute("user") User user, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "home-page/register";
//        }
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//
//        Role userRole = new Role();
//        userRole.setName("ROLE_USER");
//        user.setRoles(Collections.singleton(userRole));
//
//        userService.save(user);
//
//        model.addAttribute("message", "Rejestracja przebiegła pomyślnie!");
//        return "redirect:/login";
//    }

}

