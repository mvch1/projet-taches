package com.example.demo.services;

import com.example.demo.models.Produit;
import com.example.demo.repositories.ProduitRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class ProduitService {

    final ProduitRepository produitRepository;
    public ProduitService(ProduitRepository produitRepository){
        this.produitRepository=produitRepository;
    }
    public List<Produit> afficherProduit(){
        return produitRepository.findAll();
    }
    public Optional<Produit> trouverProduit(Long id){
         return produitRepository.findById(id);
    }
    public void suprimerProduit(Long id){
        produitRepository.deleteById(id);

    }
    public void enregestrerProduit(Produit produit){
        produitRepository.save(produit);
    }


    public Produit  modifierProduit(Long id,Produit produit){
        Optional<Produit> produitExistant=produitRepository.findById(id);
        if(produitExistant.isPresent()){
            Produit p=produitExistant.get();
            p.setName(produit.getName());
            p.setEmail(produit.getEmail());
            return  produitRepository.save(p);

        }else {

            return null;
        }



    }
}

