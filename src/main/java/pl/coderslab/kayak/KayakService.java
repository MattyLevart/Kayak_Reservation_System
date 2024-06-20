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

}