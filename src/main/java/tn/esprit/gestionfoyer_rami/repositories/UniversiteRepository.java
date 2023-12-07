package tn.esprit.gestionfoyer_rami.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.gestionfoyer_rami.entities.Universite;


public interface UniversiteRepository extends CrudRepository<Universite,Long> {

    Universite findByNomUniversite(String nomUniversite);
}
