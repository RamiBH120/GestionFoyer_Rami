package tn.esprit.gestionfoyer_rami.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;

    @ManyToOne
    @JsonIgnore
    private Foyer foyer;

    //**toone = fetchtype=eager, **tomany = fetchtype=lazy
    @OneToMany(mappedBy = "bloc",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Chambre> chambres;

}
