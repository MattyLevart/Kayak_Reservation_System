package pl.coderslab.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.kayak.KayakRepository;
import pl.coderslab.pointsHistory.PointsHistory;
import pl.coderslab.reservation.ReservationRepository;
import pl.coderslab.reservation.ReservationService;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;
import pl.coderslab.user.UserService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final ReservationRepository reservationRepository;
    private final KayakRepository kayakRepository;
    private final ReservationService reservationService;

    public AdminController(UserService userService, ReservationRepository reservationRepository, KayakRepository kayakRepository, ReservationService reservationService){
        this.userService = userService;
        this.reservationRepository = reservationRepository;
        this.kayakRepository = kayakRepository;
        this.reservationService = reservationService;
    }
    @GetMapping("/home")
    public String showAdminHomePage(){
        return "admin/home";
    }
    @GetMapping("/users")
    public String showUsersList(Model model){
        model.addAttribute("users", userService.findAll());
        return "admin/users";
    }
    @PostMapping("/users/points")
    public String updateUserPoints(@RequestParam("userId") Long userId, @RequestParam("points") int points){
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            if (points >= 0){
                userService.addPoints(user,points);
            } else {
                userService.minusPoints(user, -points);
            }
        }
        return "redirect:/admin/users";
    }
@GetMapping("/points-history")
    public String viewPointsHistory(@PathVariable Long userId, Model model){
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            List<PointsHistory> pointsHistories = userService.getPointsHistory(user);
            model.addAttribute("pointsHistories", pointsHistories);
        }
        return "admin/points-history";
    }
    @GetMapping("/reservations")
    public String showReservationList(Model model){
        model.addAttribute("reservations", reservationRepository.findAll());
        return "admin/reservations";
    }

    @PostMapping("/reservation/complete")
    public String completeReservation(@RequestParam("reservationId") Long reservationId) {
        reservationService.updateReservationStatus(reservationId, "Zakończona");
        return "redirect:/admin/reservations";
    }

//    @GetMapping("/kayaks")
//    public String showKayaksList(Model model){
//        model.addAttribute("kayaks", kayakRepository.findAll());
//        return "admin/kayaks";
//    }
}
