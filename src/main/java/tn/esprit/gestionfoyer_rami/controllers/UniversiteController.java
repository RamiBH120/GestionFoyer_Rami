package tn.esprit.gestionfoyer_rami.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer_rami.entities.Universite;
import tn.esprit.gestionfoyer_rami.services.UniversiteService;

import java.util.List;

@RestController
@RequestMapping("universites")
@RequiredArgsConstructor
public class UniversiteController {
    private final UniversiteService universiteService;

    @GetMapping
    public ResponseEntity<List<Universite>> getUniversites(){
        return new ResponseEntity<>(universiteService.retrieveAllUniversities(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Universite> getUniversite(@PathVariable long id){
        return new ResponseEntity<>(universiteService.retrieveUniversite(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Universite> addUniversite(@RequestBody Universite universite){
        return new ResponseEntity<>(universiteService.addUniversite(universite), HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Universite> updateUniversite(@RequestBody Universite universite){
        return new ResponseEntity<>(universiteService.updateUniversite(universite), HttpStatus.OK);
    }

    @PutMapping("{idFoyer}/{nomUniversite}")
    public ResponseEntity<Universite> affecterFoyerAUniversite(@PathVariable("idFoyer") long idFoyer,@PathVariable("nomUniversite") String nomUniversite) {
        return new ResponseEntity<>(universiteService.affecterFoyerAUniversite(idFoyer,nomUniversite), HttpStatus.OK);
    }

    @PutMapping("{idUniversite}")
    public ResponseEntity<Universite> desaffecterFoyerAUniversite(@PathVariable("idUniversite") long idUniversite) {
        return new ResponseEntity<>(universiteService.desaffecterFoyerAUniversite(idUniversite), HttpStatus.OK);
    }
}
