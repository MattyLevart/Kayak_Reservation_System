package pl.coderslab.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.kayak.Kayak;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT k FROM Kayak k JOIN Reservation r ON k MEMBER OF r.kayaks WHERE r.dateTime BETWEEN :start AND :end")
    List<Kayak> findUnavailableKayaks(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
