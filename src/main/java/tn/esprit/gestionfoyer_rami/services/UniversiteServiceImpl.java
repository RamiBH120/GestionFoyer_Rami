package tn.esprit.gestionfoyer_rami.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.gestionfoyer_rami.entities.Foyer;
import tn.esprit.gestionfoyer_rami.entities.Universite;
import tn.esprit.gestionfoyer_rami.exceptions.EntityObjectNotFoundException;
import tn.esprit.gestionfoyer_rami.repositories.FoyerRepository;
import tn.esprit.gestionfoyer_rami.repositories.UniversiteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversiteServiceImpl implements UniversiteService{
    private final UniversiteRepository universiteRepository;
    private final FoyerRepository foyerRepository;

    @Override
    public List<Universite> retrieveAllUniversities() {
        return (List<Universite>) universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElseThrow(() -> new EntityObjectNotFoundException("universite not found"));
    }

    @Override
    @Transactional
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer=foyerRepository.findById(idFoyer).orElseThrow(() -> new EntityObjectNotFoundException("universite not found"));
        Universite universite=universiteRepository.findByNomUniversite(nomUniversite);
        universite.setFoyer(foyer);
        return universite;
    }

    @Override
    @Transactional
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite=universiteRepository.findById(idUniversite).orElseThrow(() -> new EntityObjectNotFoundException("universite not found"));
        universite.setFoyer(null);
        return universite;
    }


}
