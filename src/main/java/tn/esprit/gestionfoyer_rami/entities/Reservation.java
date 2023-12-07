package tn.esprit.gestionfoyer_rami.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
    @Id
    private String idReservation;
    private LocalDate anneeUniversitaire;
    private Boolean estValide;

    @ManyToMany
    private List<Etudiant> etudiants;
}
