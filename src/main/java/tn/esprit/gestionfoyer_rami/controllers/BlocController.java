package tn.esprit.gestionfoyer_rami.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer_rami.entities.Bloc;
import tn.esprit.gestionfoyer_rami.services.BlocService;

import java.util.List;

@RestController
@RequestMapping("blocs")
@RequiredArgsConstructor
@Tag(name = "BlocController",description = "BlocController")
public class BlocController {
    private final BlocService blocService;

    @GetMapping
    @Operation(summary = "gets all blocs")
    public List<Bloc> getBlocs() {
        return blocService.retrieveBlocs();
    }

    @GetMapping("{id}")
    @Operation(summary = "gets a bloc by its id")
    public ResponseEntity<Bloc> getBloc(@PathVariable long id) {
        return new ResponseEntity<>(blocService.retrieveBloc(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bloc> addBloc(@RequestBody Bloc bloc) {
        return new ResponseEntity<>(blocService.addBloc(bloc),HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Bloc> updateBloc(@RequestBody Bloc bloc) {
        return new ResponseEntity<>(blocService.updateBloc(bloc),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deleteBloc(@PathVariable long id) {
        blocService.removeBloc(id);
    }

    @PutMapping("{idBloc}")
    public ResponseEntity<Bloc> affecterChambresABloc(@RequestBody List<Long> numChambre, @PathVariable("idBloc") long idBloc) {
        return new ResponseEntity<>(blocService.affecterChambresABloc(numChambre, idBloc),HttpStatus.OK);
    }
}
