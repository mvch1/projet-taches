package com.example.demo.controllers;


import com.example.demo.models.Produit;
import com.example.demo.services.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController{
    final ProduitService produitService;


    public UserController(ProduitService produitService){
        this.produitService=produitService;
    }
     @GetMapping("/afficher")
    public List<Produit> afficher(){
        return produitService.afficherProduit();
    }
    @PutMapping("modifier/{id}")
    public ResponseEntity<Produit> modfier(@PathVariable  Long id , @RequestBody Produit produit){
              Produit p=produitService.modifierProduit(id,produit);
              if(p!=null){
                  return  new ResponseEntity<>(p,HttpStatus.OK);
              }else{
                  return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
              }
    }
     @GetMapping("/trouver/{id}")
    public Optional<Produit> trouver(@PathVariable Long id){
        return produitService.trouverProduit(id);
    }
    @DeleteMapping("/suprimer")
    public void suprimer(@RequestParam Long id) {
        produitService.suprimerProduit(id);
    }

    @PostMapping("/enregestrer")
    public void  enregestrer(@RequestBody Produit produit){
        produitService.enregestrerProduit(produit);
    }




}
