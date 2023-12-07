package tn.esprit.gestionfoyer_rami.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import tn.esprit.gestionfoyer_rami.entities.Chambre;
import tn.esprit.gestionfoyer_rami.entities.Etudiant;
import tn.esprit.gestionfoyer_rami.entities.Reservation;
import tn.esprit.gestionfoyer_rami.exceptions.EntityObjectNotFoundException;
import tn.esprit.gestionfoyer_rami.repositories.ChambreRepository;
import tn.esprit.gestionfoyer_rami.repositories.EtudiantRepository;
import tn.esprit.gestionfoyer_rami.repositories.ReservationRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository repository;
    private final ChambreRepository chambreRepository;
    private final EtudiantRepository etudiantRepository;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return (List<Reservation>) repository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return repository.save(res);
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return repository.findById(idReservation).orElseThrow(() -> new EntityObjectNotFoundException("reservation not found"));
    }

    @Override
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        LocalDate start=LocalDate.of(LocalDate.now().getYear(),1,1);
        LocalDate end=LocalDate.of(LocalDate.now().getYear(),12,31);

        Assert.isTrue(repository.existsByAnneeUniversitaireBetweenAndEtudiantsCin(start,end,cinEtudiant),"student already has reseration");
        Chambre chambre=chambreRepository.findById(idChambre).orElseThrow(() -> new EntityObjectNotFoundException("chambre not found"));
        Reservation reservation=repository.findByEtudiantsCin(cinEtudiant);
        reservation.setIdReservation(chambre.getNumeroChambre()+"-"+chambre.getBloc().getNomBloc()+"-"+ LocalDate.now().getYear());

        List<Etudiant> etudiants=etudiantRepository.getEtudiantsByNumChambre(idChambre);
        if((chambre.getTypeC().toString().equals("SIMPLE") && etudiants.size() <1 && reservation.getEstValide() && reservation.getAnneeUniversitaire().getYear()==LocalDate.now().getYear())||
                (chambre.getTypeC().toString().equals("DOUBLE") && etudiants.size() <2 && reservation.getEstValide() && reservation.getAnneeUniversitaire().getYear()==LocalDate.now().getYear())||
                (chambre.getTypeC().toString().equals("TRIPLE") && etudiants.size() <3 && reservation.getEstValide() && reservation.getAnneeUniversitaire().getYear()==LocalDate.now().getYear())){
            reservation.setEstValide(false);
            return repository.save(reservation);
        }

        boolean test=repository.existsByAnneeUniversitaireBetweenAndEtudiantsCin(LocalDate.parse("01-01-2023"),LocalDate.parse("12-31-2023"),cinEtudiant);
        return reservation;
    }

    @Transactional
    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Reservation reservation=repository.findByEtudiantsCin(cinEtudiant);
        reservation.setEstValide(false);
        List<Etudiant> etudiants=etudiantRepository.findByCinNotLike(cinEtudiant);
        reservation.setEtudiants(etudiants);
        List<Reservation> reservations=repository.findByEtudiantsCinNotLike(cinEtudiant);

        Chambre chambre=chambreRepository.findByReservationsIdReservation(reservation.getIdReservation());
        chambre.setReservations(reservations);

        return reservation;
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) {
        return repository.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversite,nomUniversite);
    }

    @Override
    public Reservation addReservationByDate(LocalDate date,Reservation reservation){
        reservation.setAnneeUniversitaire(date);
        return repository.save(reservation);
    }

    @Override
    public LocalDate getDateFromRequest(LocalDate date){
        log.info(String.valueOf(date));
        return date;
    }
}
