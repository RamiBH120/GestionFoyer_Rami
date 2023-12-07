package tn.esprit.gestionfoyer_rami.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer_rami.entities.Chambre;
import tn.esprit.gestionfoyer_rami.enums.TypeChambre;
import tn.esprit.gestionfoyer_rami.repositories.ChambreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChambreServiceImpl implements ChambreService{

    private final ChambreRepository chambreRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return (List<Chambre>) chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        return chambreRepository.findByBloc_Foyer_UniversiteNomUniversite(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepository.findByBloc_IdBlocAndTypeC(idBloc,typeC);
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        return chambreRepository.getChambresNonReservesByTypeCAndNomUniversite(type.name(),nomUniversite);
    }


}
