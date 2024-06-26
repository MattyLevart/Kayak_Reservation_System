package pl.coderslab.reservation;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.kayak.Kayak;
import pl.coderslab.user.User;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Data nie może być pusta")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future(message = "Wybierz prawidłową datę")
    private LocalDate date;
    @NotNull(message = "Wybierz godzinę spływu")
    private int hour;

    @NotEmpty(message = "Miejsce startu nie może być puste")
    private String placeOfStart;

    @Min(value = 0, message = "Liczba miejsc dla dzieci nie może być ujemna")
    private int babySeats;
    @Min(value = 0, message = "Liczba kajaków jednoosobowych nie może być ujemna")
    private int singleKayaks;
    @Min(value = 0, message = "Liczba kajaków dwuosobowych nie może być ujemna")
    private int doubleKayaks;

    @ManyToMany
    @JoinTable(name = "reservation_kayak",
    joinColumns = @JoinColumn(name = "reservation_id"),
    inverseJoinColumns = @JoinColumn(name = "kayak_id"))
    private List<Kayak> kayaks;
    @ManyToOne
    private User client;
    private String status;
    @NotEmpty(message = "Imię nie może być puste")
    private String firstName;
    @NotEmpty(message = "Nazwisko nie może być puste")
    private String lastName;
    @NotEmpty(message = "Email nie może być pusty")
    @Email(message = "Niepoprawny format email")
    private String email;
    @NotEmpty(message = "Numer telefonu nie może być pusty")
    @Size(min = 9, max = 15, message = "Numer telefonu musi zawierać od 9 do 15 znaków")
    private String phone;
    @Min(value = 0)
    private int price;
    private int points;

}
