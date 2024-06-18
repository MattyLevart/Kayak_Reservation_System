package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() { return "/home-page/landing-page"; }

    @GetMapping("/reservationForm")
    public String showReservationForm() { return "home-page/reservationForm"; }

    @GetMapping("/register")
    public String showRegisterForm(){
        return "home-page/register";
    }
}