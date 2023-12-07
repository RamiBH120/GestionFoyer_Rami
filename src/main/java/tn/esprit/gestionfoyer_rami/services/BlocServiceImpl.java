package tn.esprit.gestionfoyer_rami.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer_rami.entities.Bloc;
import tn.esprit.gestionfoyer_rami.entities.Chambre;
import tn.esprit.gestionfoyer_rami.exceptions.EntityObjectNotFoundException;
import tn.esprit.gestionfoyer_rami.repositories.BlocRepository;
import tn.esprit.gestionfoyer_rami.repositories.ChambreRepository;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlocServiceImpl implements BlocService{

    private final BlocRepository blocRepository;
    private final ChambreRepository chambreRepository;

    @Override
    public List<Bloc> retrieveBlocs() {
        return (List<Bloc>) blocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElseThrow(() -> new EntityObjectNotFoundException("bloc not found"));
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc=blocRepository.findById(idBloc).orElseThrow(() -> new EntityObjectNotFoundException("bloc not found"));
        List<Chambre> chambres = chambreRepository.findByNumeroChambreIn(numChambre);
        //numChambre.forEach(aLong -> chambres.add(chambreRepository.findByNumeroChambre(aLong).get()));

        bloc.setChambres(chambres);
        return bloc;
    }

    @Scheduled(fixedRate = 6000)
    public void testScheduler(){
        List<Bloc> blocs= (List<Bloc>) blocRepository.findAll();
        for(Bloc bloc:blocs){
            log.info(String.valueOf(bloc.getChambres().size()));
        }
    }
}
