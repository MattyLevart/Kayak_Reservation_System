package pl.coderslab.reservation;

import org.springframework.stereotype.Service;
import pl.coderslab.kayak.Kayak;
import pl.coderslab.kayak.KayakRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final KayakRepository kayakRepository;

    public ReservationService(ReservationRepository reservationRepository, KayakRepository kayakRepository) {
        this.reservationRepository = reservationRepository;
        this.kayakRepository = kayakRepository;
    }

    public List<Kayak> findAvailableKayaks(LocalDateTime start, LocalDateTime end) {
        List<Kayak> unavailableKayaks = reservationRepository.findUnavailableKayaks(start, end);
        List<Kayak> allKayaks = kayakRepository.findAll();
        allKayaks.removeAll(unavailableKayaks);
        return allKayaks;
    }

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}