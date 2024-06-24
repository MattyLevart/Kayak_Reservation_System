package pl.coderslab.kayak;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.reservation.Reservation;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Kayak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    @NotNull
    @Max(value = 2, message = "W kajaku mogą być maksymalnie dwie osoby.")
    @Min(value = 1, message = "Kajak nie może być pusty.")
    private int places;
    private boolean babyOption;
    private String description;
    @ManyToMany
    @JoinTable(name = "reservation_kayak",
            joinColumns = @JoinColumn(name = "kayak_id"),
            inverseJoinColumns = @JoinColumn(name = "reservation_id"))
    private List<Reservation> reservations;

}