package tn.esprit.gestionfoyer_rami.services;

import tn.esprit.gestionfoyer_rami.entities.Foyer;

import java.util.List;

public interface FoyerService {
    List<Foyer> retrieveAllFoyers();

    Foyer addFoyer (Foyer f);

    Foyer updateFoyer (Foyer f);

    Foyer retrieveFoyer (long idFoyer);

    void removeFoyer (long idFoyer);

    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);
}
