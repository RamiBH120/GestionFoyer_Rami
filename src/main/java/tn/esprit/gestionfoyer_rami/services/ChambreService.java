package tn.esprit.gestionfoyer_rami.services;

import tn.esprit.gestionfoyer_rami.entities.Chambre;
import tn.esprit.gestionfoyer_rami.enums.TypeChambre;

import java.util.List;

public interface ChambreService {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre c);

    Chambre updateChambre (Chambre c);

    Chambre retrieveChambre (long idChambre);

    List<Chambre> getChambresParNomUniversite(String nomUniversite);

    List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);

    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type);
}
