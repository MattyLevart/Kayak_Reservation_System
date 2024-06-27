package pl.coderslab.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.kayak.Kayak;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    @Query("SELECT DISTINCT k FROM Kayak k JOIN k.reservations r " +
            "WHERE (r.date = :date AND r.hour = :hour)")
    List<Kayak> findUnavailableKayaks(@Param("date") LocalDate date, @Param("hour") int hour);

//    @Query("SELECT r FROM Reservation r WHERE r.date = :date AND r.hour = :hour")
//    List<Reservation> findReservationsByDateAndHour(@Param("date") LocalDate date, @Param("hour") int hour);

    @Query("SELECT r FROM Reservation r WHERE r.date = :date")
    List<Reservation> findReservationsByDate(@Param("date") LocalDate date);

//    @Query("SELECT r FROM Reservation r where r.date > now() and r.client.id = :clientId")
//    List<Reservation> findFutureUserReservations(@Param("clientId") Long clientId);

    @Query("SELECT r from Reservation r where r.client.id = :clientId ORDER BY r.date")
    List<Reservation> findAllUserReservationsSortedByDate(@Param("clientId") Long clientId);


}
