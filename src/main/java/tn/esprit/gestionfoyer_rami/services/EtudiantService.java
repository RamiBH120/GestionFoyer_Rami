package tn.esprit.gestionfoyer_rami.services;

import tn.esprit.gestionfoyer_rami.entities.Etudiant;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    List<Etudiant> addEtudiants (List<Etudiant> etudiants);

    Etudiant updateEtudiant (Etudiant e);

    Etudiant retrieveEtudiant(long idEtudiant);

    void removeEtudiant(long idEtudiant);
}
