package pl.coderslab.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.kayak.KayakRepository;
import pl.coderslab.pointsHistory.PointsHistory;
import pl.coderslab.reservation.Reservation;
import pl.coderslab.reservation.ReservationRepository;
import pl.coderslab.reservation.ReservationService;
import pl.coderslab.user.User;
import pl.coderslab.user.UserService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final ReservationRepository reservationRepository;
    private final ReservationService reservationService;

    public AdminController(UserService userService, ReservationRepository reservationRepository, ReservationService reservationService) {
        this.userService = userService;
        this.reservationRepository = reservationRepository;
        this.reservationService = reservationService;
    }

    @GetMapping("/users")
    public String showUsersList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/users";
    }

    @PostMapping("/users/points")
    public String updateUserPoints(@RequestParam("userId") Long userId, @RequestParam("points") int points) {
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (points >= 0) {
                userService.addPoints(user, points);
            } else {
                userService.minusPoints(user, -points);
            }
        }
        return "redirect:/admin/users";
    }

    @GetMapping("/points-history")
    public String viewPointsHistory(@RequestParam("userId") Long userId, Model model) {
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            List<PointsHistory> pointsHistories = userService.getPointsHistory(user);
            model.addAttribute("pointsHistories", pointsHistories);
            model.addAttribute("user", user);
        }
        return "admin/points-history";
    }

    @GetMapping("/reservations")
    public String showReservationList(Model model) {
        List<Reservation> waitingReservations = reservationRepository.findByStatusOrderByDateAsc("Oczekuje na potwierdzenie");
        List<Reservation> confirmedReservations = reservationRepository.findByStatusOrderByDateAsc("Potwierdzona");
        model.addAttribute("waitingReservations", waitingReservations);
        model.addAttribute("confirmedReservations", confirmedReservations);
        return "admin/reservations";
    }

    @GetMapping("/archive")
    public String showArchive(Model model) {
        List<Reservation> finishedReservations = reservationRepository.findByStatusOrderByDateAsc("Zakończona");
        List<Reservation> cancelledReservations = reservationRepository.findByStatusOrderByDateAsc("Odwołana");
        model.addAttribute("completedReservations", finishedReservations);
        model.addAttribute("cancelledReservations", cancelledReservations);
        return "admin/archive";
    }

    @PostMapping("/reservation/updateStatus")
    public String updateReservationStatus(@RequestParam("reservationId") Long id, @RequestParam("status") String status) {
        reservationService.updateReservationStatus(id, status);
        return "redirect:/admin/reservations";
    }

    @PostMapping("/reservation/confirm")
    public String confirmReservation(@RequestParam("reservationId") Long id) {
        reservationService.updateReservationStatus(id, "Potwierdzona");
        return "redirect:/admin/reservations";
    }

    @PostMapping("/reservation/complete")
    public String completeReservation(@RequestParam("reservationId") Long reservationId) {
        reservationService.updateReservationStatus(reservationId, "Zakończona");
        return "redirect:/admin/reservations";
    }

    @PostMapping("/reservation/cancel")
    public String cancelReservation(@RequestParam("reservationId") Long id) {
        reservationService.updateReservationStatus(id, "Odwołana");
        return "redirect:/admin/reservations";
    }

    @GetMapping("/reservation/details")
    public String showReservationDetails(@RequestParam("id") Long id, Model model) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            model.addAttribute("reservation", reservation);
            model.addAttribute("user", reservation.getClient());
            return "admin/reservationDetails";
        } else {
            return "redirect:/admin/reservations";
        }
    }
}
