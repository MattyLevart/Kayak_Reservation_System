package pl.coderslab.kayak;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class KayakService {
    private final KayakRepository kayakRepository;

    public KayakService(KayakRepository kayakRepository) {
        this.kayakRepository = kayakRepository;
    }
//
//    public List<Kayak> findAvailableKayaks(LocalDateTime dateTime) {
//        LocalDate date = dateTime.toLocalDate();
//        List<Kayak> unavailableKayaks = kayakRepository.findUnavailableKayaks(date);
//        List<Kayak> allKayaks = kayakRepository.findAll();
//        allKayaks.removeAll(unavailableKayaks);
//        return allKayaks;
//    }
}