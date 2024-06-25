package pl.coderslab.reservation;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.kayak.Kayak;
import pl.coderslab.kayak.KayakRepository;
import pl.coderslab.kayak.KayakService;
import pl.coderslab.user.User;
import pl.coderslab.user.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ReservationController {
    private final UserService userService;
    private final KayakService kayakService;
    private final ReservationService reservationService;

    public ReservationController(UserService userService, KayakService kayakService, ReservationService reservationService) {
        this.userService = userService;
        this.kayakService = kayakService;
        this.reservationService = reservationService;
    }


    @GetMapping("/reservationForm")
    public String showReservationForm(Model model, Principal principal) {
        Reservation reservation = new Reservation();
        if (principal != null) {
            User user = userService.findByEmail(principal.getName());
            reservation.setFirstName(user.getFirstName());
            reservation.setLastName(user.getLastName());
            reservation.setEmail(user.getEmail());
            reservation.setPhone(String.valueOf(user.getPhone()));
        }

        model.addAttribute("reservation", reservation);
        return "home-page/reservationForm";
    }

    @PostMapping("/reservationForm")
    public String processReservationForm(@ModelAttribute("reservation") @Valid Reservation reservation, BindingResult result, Principal principal, Model model) {
        if (result.hasErrors()) {
            return "home-page/reservationForm";
        }

        LocalDate date = reservation.getDate();
        int hour = reservation.getHour();

        List<Kayak> availableKayaks = reservationService.findAvailableKayaks(date);

        int singleKayaks = reservation.getSingleKayaks();
        int doubleKayaks = reservation.getDoubleKayaks();
        int babySeats = reservation.getBabySeats();
        int toPay = 0;

        List<Kayak> selectedKayaks = new ArrayList<>();
        int requiredBabyKayaks = babySeats;


        for (Kayak kayak : availableKayaks) {
            if (singleKayaks > 0 && kayak.getPlaces() == 1) {
                selectedKayaks.add(kayak);
                singleKayaks--;
                toPay += 50;
            }
            if (singleKayaks == 0) break;
        }

        for (Kayak kayak : availableKayaks) {
            if (doubleKayaks > 0 && kayak.getPlaces() == 2) {
                selectedKayaks.add(kayak);
                doubleKayaks--;
                toPay += 100;
            }
            if (doubleKayaks == 0) break;
        }

        for (Kayak kayak : availableKayaks) {
            if (requiredBabyKayaks > 0 && kayak.isBabyOption()) {
                selectedKayaks.add(kayak);
                requiredBabyKayaks--;
                toPay += 100;
            }
            if (requiredBabyKayaks == 0) break;
        }

        if (singleKayaks > 0 || doubleKayaks > 0 || requiredBabyKayaks > 0) {
            model.addAttribute("error", "Brak wystarczającej liczby dostępnych kajaków na wybrany termin.\n" +
                    "Spróbuj zamienić kajaki z dziećmi lub kajaki jednoosobowe na dwuosobowe.\n" +
                    "W razie niepowodzenia prosimy wybrać inną datę spływu kajakowego.");
            return "home-page/reservationForm";
        }

        reservation.setKayaks(selectedKayaks);
        reservation.setStatus("Oczekuje na potwierdzenie");

        if (principal != null) {
            User user = userService.findByEmail(principal.getName());
            reservation.setClient(user);
        }
        reservation.setPrice(toPay);

        reservationService.save(reservation);

        return "redirect:/reservationConfirmation";
    }

//    @GetMapping("/reservation/edit")
//    public String editReservationDetails(Model model, Reservation reservation, @AuthenticationPrincipal UserDetails userDetails){
//        User user = userService.findByEmail(userDetails.getUsername());
//        //model.addAttribute("user", user);
//            reservation.setFirstName(user.getFirstName());
//            reservation.setLastName(user.getLastName());
//            reservation.setEmail(user.getEmail());
//            reservation.setPhone(String.valueOf(user.getPhone()));
//
//        long reservationId = reservation.getId();
//        Optional<Reservation> rToEdit = reservationService.findReservationById(reservationId);
//        model.addAttribute("reservation", rToEdit);
//        return "home-page/reservationForm";
//    }
//    @PostMapping("/reservation/edit")
//    public String editReservationDetails(@ModelAttribute Reservation reservation, @AuthenticationPrincipal UserDetails userDetails){
//        //userService.update(user, userDetails);
//        return "redirect:/user/home";
//    }

    @GetMapping("/reservationConfirmation")
    public String showReservationConfirmation() {
        return "home-page/confirmation";
    }
}
