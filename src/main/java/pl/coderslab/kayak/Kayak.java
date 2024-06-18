package pl.coderslab.kayak;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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

}