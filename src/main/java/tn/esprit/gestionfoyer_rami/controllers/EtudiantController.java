package tn.esprit.gestionfoyer_rami.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer_rami.entities.Etudiant;
import tn.esprit.gestionfoyer_rami.services.EtudiantService;

import java.util.List;

@RestController
@RequestMapping("etudiants")
@RequiredArgsConstructor
public class EtudiantController {
    private final EtudiantService etudiantService;

    @GetMapping
    public ResponseEntity<List<Etudiant>> getEtudiants(){
        return new ResponseEntity<>(etudiantService.retrieveAllEtudiants(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Etudiant> getEtudiant(@PathVariable long id){
        return new ResponseEntity<>(etudiantService.retrieveEtudiant(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<Etudiant>> addEtudiant(@RequestBody List<Etudiant> etudiants){
        return new ResponseEntity<>(etudiantService.addEtudiants(etudiants),HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Etudiant> updateEtudiant(@RequestBody Etudiant etudiant){
        return new ResponseEntity<>(etudiantService.updateEtudiant(etudiant),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deleteEtudiant(@PathVariable long id){
        etudiantService.removeEtudiant(id);
    }
}
