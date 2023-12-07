package tn.esprit.gestionfoyer_rami.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;
    @Column(unique = true)
    private String nomUniversite;
    private String adresse;

    @OneToOne
    private Foyer foyer;
}
