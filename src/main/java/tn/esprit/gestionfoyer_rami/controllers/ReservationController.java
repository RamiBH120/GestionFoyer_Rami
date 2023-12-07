package tn.esprit.gestionfoyer_rami.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer_rami.entities.Reservation;
import tn.esprit.gestionfoyer_rami.services.ReservationService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<Reservation>> getReservations(){
        return new ResponseEntity<>(reservationService.retrieveAllReservation(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable long id){
        return new ResponseEntity<>(reservationService.retrieveReservation(id),HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation){
        return new ResponseEntity<>(reservationService.updateReservation(reservation),HttpStatus.OK);
    }

    @PostMapping("{idChambre}/{cinEtudiant}")
    public ResponseEntity<Reservation> ajouterReservation(@PathVariable long idChambre,@PathVariable long cinEtudiant) {
        return new ResponseEntity<>(reservationService.ajouterReservation(idChambre,cinEtudiant),HttpStatus.CREATED);
    }

    @PostMapping("addByDate")
    public ResponseEntity<Reservation> ajouterReservationByDate(@RequestParam LocalDate date, @RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.addReservationByDate(date,reservation),HttpStatus.CREATED);
    }

    @GetMapping("getByDate")
    public LocalDate getDateParam(@RequestParam LocalDate date) {
        return reservationService.getDateFromRequest(date);
    }

    @GetMapping("getByDate/{date}")
    public LocalDate getDatePath(@PathVariable("date") LocalDate date) {
        return reservationService.getDateFromRequest(date);
    }
    @PutMapping("{cinEtudiant}")
    public ResponseEntity<Reservation> annulerReservation(@PathVariable long cinEtudiant) {
        return new ResponseEntity<>(reservationService.annulerReservation(cinEtudiant),HttpStatus.OK);
    }

    @GetMapping("yearname")
    public ResponseEntity<List<Reservation>> getReservationParAnneeUniversitaireEtNomUniversite(@RequestParam Date anneeUniversite,
                                                                                @RequestParam String nomUniversite) {
        return new ResponseEntity<>(reservationService.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversite, nomUniversite),HttpStatus.OK);
    }

}
