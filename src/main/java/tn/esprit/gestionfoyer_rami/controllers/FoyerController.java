package tn.esprit.gestionfoyer_rami.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer_rami.entities.Foyer;
import tn.esprit.gestionfoyer_rami.entities.Reservation;
import tn.esprit.gestionfoyer_rami.services.FoyerService;

import java.util.List;

@RestController
@RequestMapping("foyers")
@RequiredArgsConstructor
public class FoyerController {

    private final FoyerService foyerService;

    @GetMapping
    public ResponseEntity<List<Foyer>> getFoyers(){
        return new ResponseEntity<>(foyerService.retrieveAllFoyers(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Foyer> getFoyer(@PathVariable long id){
        return new ResponseEntity<>(foyerService.retrieveFoyer(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Foyer> addFoyer(@RequestBody Foyer foyer){
        return new ResponseEntity<>(foyerService.addFoyer(foyer),HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Foyer> updateFoyer(@RequestBody Foyer foyer){
        return new ResponseEntity<>(foyerService.updateFoyer(foyer),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deleteFoyer(@PathVariable long id){
        foyerService.removeFoyer(id);
    }

    @PostMapping("{idUniversite}")
    public ResponseEntity<Foyer> ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer,@PathVariable long idUniversite) {
        return new ResponseEntity<>(foyerService.ajouterFoyerEtAffecterAUniversite(foyer,idUniversite),HttpStatus.CREATED);
    }

}
