package tn.esprit.gestionfoyer_rami.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer_rami.entities.Chambre;
import tn.esprit.gestionfoyer_rami.enums.TypeChambre;
import tn.esprit.gestionfoyer_rami.services.ChambreService;

import java.util.List;

@RestController
@RequestMapping("chambres")
@RequiredArgsConstructor
public class ChambreController {

    private final ChambreService chambreService;

    @GetMapping
    public ResponseEntity<List<Chambre>> getChambres(){
        return new ResponseEntity<>(chambreService.retrieveAllChambres(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Chambre> getChambre(@PathVariable long id){
        return new ResponseEntity<>(chambreService.retrieveChambre(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Chambre> addChambre(@RequestBody Chambre chambre){
        return new ResponseEntity<>(chambreService.addChambre(chambre),HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Chambre> updateChambre(@RequestBody Chambre chambre){
        return new ResponseEntity<>(chambreService.updateChambre(chambre),HttpStatus.OK);
    }

    @GetMapping("{nomUniversite}")
    public ResponseEntity<List<Chambre>> getChambresParNomUniversite(@PathVariable String nomUniversite) {
        return new ResponseEntity<>(chambreService.getChambresParNomUniversite(nomUniversite),HttpStatus.OK);
    }


    @GetMapping("{idBloc}")
    public ResponseEntity<List<Chambre>> getChambresParBlocEtType(@PathVariable long idBloc,@RequestParam("typeC") TypeChambre typeC) {
        return new ResponseEntity<>(chambreService.getChambresParBlocEtType(idBloc,typeC),HttpStatus.OK);
    }

    @GetMapping("nonreservedyeartype")
    public ResponseEntity<List<Chambre>> getChambresNonReserveParNomUniversiteEtTypeChambre(@RequestParam String nomUniversite,@RequestParam TypeChambre type) {
        return new ResponseEntity<>(chambreService.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite,type),HttpStatus.OK);
    }
}
