package com.example.demo.services;

import com.example.demo.models.Projets;
import com.example.demo.models.Statut;
import com.example.demo.models.Taches;
import com.example.demo.models.Users;
import com.example.demo.repositories.ProjetsRepository;
import com.example.demo.repositories.TachesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class TachesService{

     private TachesRepository tachesRepository;
     public TachesService(TachesRepository tachesRepository){
         this.tachesRepository=tachesRepository;
     }
     public void ajouterService(Taches taches){
         tachesRepository.save(taches);
     }
     public boolean  modifierService(Taches taches){
         Optional<Taches> optional=tachesRepository.findById(taches.getId());
         if(optional.isPresent()){
             tachesRepository.save(taches);
             return true;
         }else {
             return false;
         }
     }
     public  boolean ajouterMembresService(List<Users> membres, UUID tache_id){
         Optional<Taches> optional=tachesRepository.findById(tache_id);
         if (optional.isPresent()) {
             optional.get().setAssigneA(membres);
             tachesRepository.save(optional.get());
             return true;
         }else{
             return  false;
         }
     }

    public  boolean modifierTitreService(String titre, UUID tache_id){
        Optional<Taches> optional=tachesRepository.findById(tache_id);
        if (optional.isPresent()) {
            optional.get().setTitre(titre);
            tachesRepository.save(optional.get());
            return true;
        }else{
            return  false;
        }
    }
    public  boolean  modifierDescriptionService(String description, UUID tache_id){
        Optional<Taches> optional=tachesRepository.findById(tache_id);
        if (optional.isPresent()) {
            optional.get().setDescription(description);
            tachesRepository.save(optional.get());
            return true;
        }else{
            return  false;
        }
    }
    public  boolean modifierDateEcheanceService(LocalDate date, UUID tache_id){
        Optional<Taches> optional=tachesRepository.findById(tache_id);
        if (optional.isPresent()) {
            optional.get().setDateEcheance(date);
            tachesRepository.save(optional.get());
            return true;
        }else{
            return  false;
        }
    }
    public boolean modifierStatutService(UUID tache_id){
        Optional<Taches> optional =tachesRepository.findById(tache_id);
        if(optional.isPresent()){
            optional.get().setStatut(Statut.TERMINE);
            return  true;
        }else {
            return false;

        }
    }
    public List<Taches> afficherService(UUID user_id){
         Users users=new Users();
         users.setId(user_id);
         return  tachesRepository.findByCreateParOrAssigneA(users,users);
     }
     public  void suprimerService(UUID tache_id){
         tachesRepository.deleteById(tache_id);
     }
     public  void suprimerTous(UUID projet_id){
         Projets projets=new Projets();
         projets.setId(projet_id);
         tachesRepository.deleteByProjet(projets);
     }








}
