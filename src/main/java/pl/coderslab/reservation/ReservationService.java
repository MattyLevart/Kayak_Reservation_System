package pl.coderslab.reservation;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.coderslab.kayak.Kayak;
import pl.coderslab.kayak.KayakRepository;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;
import pl.coderslab.user.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final KayakRepository kayakRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    public ReservationService(ReservationRepository reservationRepository, KayakRepository kayakRepository, UserRepository userRepository, UserService userService) {
        this.reservationRepository = reservationRepository;
        this.kayakRepository = kayakRepository;
        this.userRepository = userRepository;
        this.userService = userService;
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

//    public List<Reservation> findFutureReservations(UserDetails userDetails) {
//        String userMail = userDetails.getUsername();
//        User byEmail = userRepository.findByEmail(userMail);
//        return reservationRepository.findFutureUserReservations(byEmail.getId());
//    }

    public List<Reservation> getAllUserReservationsSortedByDate(UserDetails userDetails){
        String userMail = userDetails.getUsername();
        User byMail = userRepository.findByEmail(userMail);
        return reservationRepository.findAllUserReservationsSortedByDate(byMail.getId());
    }

    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    public void updateReservationStatus(Long reservationId, String status) {
        Optional<Reservation> optionalReservation = findById(reservationId);
        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            reservation.setStatus(status);

            if ("Zakończona".equals(status)) {
                User user = reservation.getClient();
                if (user != null) {
                    int points = calculatePoints(reservation);
                    reservation.setPoints(points);
                    userService.addPoints(user, points);
                }
            }

            reservationRepository.save(reservation);
        }
    }

    private int calculatePoints(Reservation reservation){
        int points = 0;
        for (Kayak kayak : reservation.getKayaks()){
            if (kayak.getPlaces() == 1){
                points += 1;
            }else if (kayak.getPlaces() == 2){
                points += 2;
            }
//            if (kayak.isBabyOption()){
//                points += 2;
//            }
        } return points;
    }

}