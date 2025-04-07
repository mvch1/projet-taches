package com.example.demo.controllers;

import com.example.demo.models.Taches;
import com.example.demo.models.Users;
import com.example.demo.repositories.TachesRepository;
import com.example.demo.services.TachesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/taches")
public class TachesController {
    final private TachesService tachesService;
    public TachesController(TachesService tachesService){
        this.tachesService=tachesService;
    }
    @GetMapping("/ajouter")
    public void  ajouter(Taches taches){
        tachesService.ajouterService(taches);

    }
    @PutMapping("/modifier")
    public ResponseEntity<String> modifier(Taches taches){
        if(tachesService.modifierService(taches)==true){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/ajoutermembre")
    public ResponseEntity<String> modifierMembre(  @RequestBody List<Users> membres ,@RequestParam UUID taches){
        if(tachesService.ajouterMembresService(membres,taches)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/modifiertitre")
    public ResponseEntity<String> modifierTitre( String titre, UUID tache_id){
        if(tachesService.modifierTitreService(titre,tache_id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/modifierdescription")

    public ResponseEntity<String> modifierMembre(String description, UUID tache_id){
        if(tachesService.modifierDescriptionService(description,tache_id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/modifierddateecheance")

    public ResponseEntity<String> modifierDateEcheance(LocalDate date, UUID tache_id){
        if(tachesService.modifierDateEcheanceService(date,tache_id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/modifierStatut")
    public ResponseEntity<String> modifierStatut(@RequestParam UUID projet_id){
        if(tachesService.modifierStatutService(projet_id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/afficher")
    public  List<Taches> afficher(UUID user_id) {
         return  tachesService.afficherService(user_id);
    }
    @DeleteMapping("/suprimer")
    public  void suprimer(UUID tache_id){
        tachesService.suprimerService(tache_id);
    }
    @DeleteMapping("/suprimertous")
    public void  suprimerTous(UUID projet_id){
        tachesService.suprimerTous(projet_id);
    }


}
