package pl.coderslab.reservation;

import org.springframework.stereotype.Service;
import pl.coderslab.kayak.Kayak;
import pl.coderslab.kayak.KayakRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.ThreadContext.removeAll;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final KayakRepository kayakRepository;

    public ReservationService(ReservationRepository reservationRepository, KayakRepository kayakRepository) {
        this.reservationRepository = reservationRepository;
        this.kayakRepository = kayakRepository;
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
}