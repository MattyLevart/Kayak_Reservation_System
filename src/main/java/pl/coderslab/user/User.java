package pl.coderslab.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.reservation.Reservation;
import pl.coderslab.role.Role;

import javax.persistence.*;
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
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private long phone;
    private long points;
    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
