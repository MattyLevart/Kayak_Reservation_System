package pl.coderslab.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.pointsHistory.PointsHistory;
import pl.coderslab.reservation.Reservation;
import pl.coderslab.reservation.ReservationService;

import java.security.Principal;
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
    @GetMapping("/reservations")
    public String showList(Model model, @AuthenticationPrincipal UserDetails userDetails){
        List<Reservation> nextReservations = reservationService.findFutureReservations(userDetails);
        User user = userService.findByEmail(userDetails.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("reservs", nextReservations);
        return "user/reservations";
    }
    @GetMapping("/details")
    public String showUserDetails(Model model, Principal principal){
        String username = principal.getName();
        User user = userService.findByEmail(username);
        model.addAttribute("user", user);
        return "user/list";
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
        return "redirect:/user/reservations";
    }
    @RequestMapping("/delete")
    public String deleteUserAccount(Principal principal){
        String username = principal.getName();
        userService.deleteByEmail(username);
        return "redirect:/";
    }
@GetMapping("/points-history")
    public String viewPointHistory(@AuthenticationPrincipal UserDetails currentUser, Model model){
        if (currentUser != null){
            User user = userService.findByEmail(currentUser.getUsername());
            List<PointsHistory> pointsHistories = userService.getPointsHistory(user);
            model.addAttribute("pointsHistories", pointsHistories);
        }
        return "user/points-history";
    }

}

