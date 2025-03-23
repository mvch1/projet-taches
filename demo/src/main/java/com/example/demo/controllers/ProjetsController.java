package com.example.demo.controllers;


import com.example.demo.models.Projets;
import com.example.demo.models.Users;
import com.example.demo.services.PreojetsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/projets")
public class ProjetsController {
    final private PreojetsService preojetsService;
    public ProjetsController(PreojetsService  preojetsService){
        this.preojetsService=preojetsService;
    }
    @GetMapping("/affichertous")
    public List<Projets> afficherTous(@RequestParam UUID user_id){
         return preojetsService.afficherTousProjetsService(user_id);

    }
    @GetMapping("/afficherProprietaire")
    public  List<Projets> afficherProprietaireProjets( @RequestParam  UUID user_id){
        return preojetsService.afficherProprietaireProjetsService(user_id);

    }
    @GetMapping("/afficherMembresProjets")
    public  List<Projets> afficherMembresProjets(@RequestParam UUID user_id){
        return preojetsService.afficherMembresProjetsService(user_id);
    }
    @PostMapping("/envoiyer")
    public void envoiyer(@RequestBody Projets projets) {
        preojetsService.envoiyerService(projets);
    }
    @PostMapping("/ajouterMembre")
    public  void ajouterMembre(@RequestBody  List<Users> membres ,@RequestParam  UUID projet_id){
        preojetsService.ajouterMembreService(membres,projet_id);
    }
    @DeleteMapping("/suprimerTous")
    public void suprimerTous(@RequestParam UUID user_id){
        preojetsService.suprimerTousService(user_id);
    }
    @DeleteMapping("/suprimerParProjet")
    public ResponseEntity<String> suprimerParProjet(@RequestParam UUID  projet_id){
        if (preojetsService.suprimerParProjetService(projet_id)==true) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/modifierStatut")
    public ResponseEntity<String> modifierStatut(@RequestParam UUID projet_id){
        if(preojetsService.modifierStatutService(projet_id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }





}
