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

    public List<Kayak> getAllKayaks(){
        return kayakRepository.findAll();
    }

    public void saveKayak(Kayak kayak){
        kayakRepository.save(kayak);
    }

    public Kayak getKayakById(Long id){
        return kayakRepository.findById(id).orElse(null);
    }

    public void deleteKayak(Long id){
        kayakRepository.deleteById(id);
    }

}