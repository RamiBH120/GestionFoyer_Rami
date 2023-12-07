package tn.esprit.gestionfoyer_rami.services;

import tn.esprit.gestionfoyer_rami.entities.Reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ReservationService {
    List<Reservation> retrieveAllReservation();

    Reservation updateReservation (Reservation res);

    Reservation retrieveReservation (Long idReservation);

    Reservation ajouterReservation(long idChambre, long cinEtudiant);

    Reservation addReservationByDate(LocalDate date, Reservation reservation);


    LocalDate getDateFromRequest(LocalDate date);

    Reservation annulerReservation(long cinEtudiant);

    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite);
}
