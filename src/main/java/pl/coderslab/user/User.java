package pl.coderslab.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.pointsHistory.PointsHistory;
import pl.coderslab.reservation.Reservation;
import pl.coderslab.role.Role;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Hasło nie może być puste")
    @Size(min = 4, message = "Hasło musi zawierać minimum 4 znaki")
    private String password;
    @NotBlank(message = "Imię nie może być puste")
    @Size(max = 50, message = "Imię nie może być dłuższe niż 50 znaków")
    private String firstName;
    @NotBlank(message = "Nazwisko nie może być puste")
    @Size(max = 50, message = "Nazwisko nie może być dłuższe niż 50 znaków")
    private String lastName;
    @NotBlank(message = "Email nie może być pusty")
    @Email(message = "Wpisz prawidłowy email")
    private String email;
    @NotNull(message = "Numer telefonu nie może być pusty")
    @Digits(integer = 15, fraction = 0, message = "Wpisz prawidłowy numer")
    @Size(min = 9, max = 15, message = "Numer telefonu powinien zawierać od 9 do 15 cyfr")
    private String phone;
    private long points;
    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Role> roles;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PointsHistory> pointsHistories = new ArrayList<>();
}
