package pl.coderslab.reservation;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.coderslab.kayak.Kayak;
import pl.coderslab.kayak.KayakRepository;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final KayakRepository kayakRepository;
    private final UserRepository userRepository;

    public ReservationService(ReservationRepository reservationRepository, KayakRepository kayakRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.kayakRepository = kayakRepository;
        this.userRepository = userRepository;
    }

    public List<Kayak> findUnavailableKayaks(LocalDate date, int hour) {
        return reservationRepository.findUnavailableKayaks(date, hour);
    }

    public List<Kayak> findAvailableKayaks(LocalDate date) {
        List<Reservation> reservations = reservationRepository.findReservationsByDate(date);

        List<Kayak> allKayaks = kayakRepository.findAll();

        List<Kayak> unavailableKayaks = new ArrayList<>();

        for (Reservation reservation : reservations) {
            List<Kayak> reservedKayaks = reservation.getKayaks();
            unavailableKayaks.addAll(reservedKayaks);
        }

        allKayaks.removeAll(unavailableKayaks);

        return allKayaks;
    }

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public List<Reservation> findFutureReservations(UserDetails userDetails) {
        String userMail = userDetails.getUsername();
        User byEmail = userRepository.findByEmail(userMail);
        return reservationRepository.findFutureUserReservations(byEmail.getId());
    }

    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

}