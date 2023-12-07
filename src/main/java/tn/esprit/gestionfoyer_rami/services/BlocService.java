package tn.esprit.gestionfoyer_rami.services;

import tn.esprit.gestionfoyer_rami.entities.Bloc;

import java.util.List;

public interface BlocService {
    List<Bloc> retrieveBlocs();

    Bloc updateBloc (Bloc bloc);

    Bloc addBloc (Bloc bloc);

    Bloc retrieveBloc (long idBloc);

    void removeBloc (long idBloc);

    Bloc affecterChambresABloc(List<Long> numChambre, long idBloc);
}
