package pl.coderslab.kayak;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
   private String places;
   private boolean isAvailable;
   private String description;

}