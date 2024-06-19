package pl.coderslab.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.kayak.KayakRepository;
import pl.coderslab.reservation.ReservationRepository;
import pl.coderslab.user.UserRepository;
import pl.coderslab.user.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private ReservationRepository reservationRepository;
    private KayakRepository kayakRepository;

    public AdminController(UserService userService, ReservationRepository reservationRepository, KayakRepository kayakRepository){
        this.userService = userService;
        this.reservationRepository = reservationRepository;
        this.kayakRepository = kayakRepository;
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
    @GetMapping("/reservations")
    public String showReservationList(Model model){
        model.addAttribute("reservations", reservationRepository.findAll());
        return "admin/reservations";
    }

    @GetMapping("/kayaks")
    public String showKayaksList(Model model){
        model.addAttribute("kayaks", kayakRepository.findAll());
        return "admin/kayaks";
    }
}
