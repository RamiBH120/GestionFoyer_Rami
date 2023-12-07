package tn.esprit.gestionfoyer_rami.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer_rami.entities.Bloc;
import tn.esprit.gestionfoyer_rami.entities.Foyer;
import tn.esprit.gestionfoyer_rami.entities.Universite;
import tn.esprit.gestionfoyer_rami.repositories.BlocRepository;
import tn.esprit.gestionfoyer_rami.repositories.FoyerRepository;
import tn.esprit.gestionfoyer_rami.repositories.UniversiteRepository;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FoyerServiceImpl implements FoyerService{

    private final FoyerRepository foyerRepository;
    private final UniversiteRepository universiteRepository;
    private final BlocRepository blocRepository;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).get();
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite=universiteRepository.findById(idUniversite).get();
        blocRepository.saveAll(foyer.getBlocs());
        //create blocs?
        foyer.setUniversite(universite);
        return foyerRepository.save(foyer);
    }
}
