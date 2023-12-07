package tn.esprit.gestionfoyer_rami.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer_rami.entities.Etudiant;
import tn.esprit.gestionfoyer_rami.repositories.EtudiantRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudiantServiceImpl implements EtudiantService{

    private final EtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return (List<Etudiant>) etudiantRepository.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return (List<Etudiant>) etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}
