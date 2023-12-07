package tn.esprit.gestionfoyer_rami.services;

import tn.esprit.gestionfoyer_rami.entities.Universite;

import java.util.List;

public interface UniversiteService {
    List<Universite> retrieveAllUniversities();

    Universite addUniversite (Universite u);

    Universite updateUniversite (Universite u);

    Universite retrieveUniversite (long idUniversite);

    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);

    Universite desaffecterFoyerAUniversite(long idUniversite);
}
