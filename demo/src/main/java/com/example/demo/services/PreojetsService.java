package com.example.demo.services;

import com.example.demo.models.Projets;
import com.example.demo.models.Statut;
import com.example.demo.models.Users;
import com.example.demo.repositories.ProjetsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PreojetsService {
    final private ProjetsRepository projetsRepository;
    public PreojetsService(ProjetsRepository projetsRepository){
        this.projetsRepository=projetsRepository;
    }
    public List<Projets> afficherTousProjetsService(UUID user_id){
        Users  users=new Users();
        users.setId(user_id);
        return projetsRepository.findByProprietaireOrMembres(users,users);
    }
    public List<Projets> afficherProprietaireProjetsService(UUID user_id){
        Users users=new Users();
        users.setId(user_id);
        return projetsRepository.findByProprietaire(users);
    }
    public List<Projets> afficherMembresProjetsService(UUID user_id){
        Users users=new Users();
        users.setId(user_id);
        return projetsRepository.findByMembresContaining(users);
    }
    public void   envoiyerService( Projets projets){
        projetsRepository.save(projets);
    }
    public boolean ajouterMembreService(List<Users> membres,UUID projet_id){
        Optional<Projets> projet =projetsRepository.findById(projet_id);
        if(projet.isPresent()){
            Projets projets= projet.get();
            projets.getMembres().addAll(membres);
            projetsRepository.save(projets);
            return true;
        }else {
            return false;
        }

    }
    public  void suprimerTousService( UUID user_id) {
             Users users=new Users();
             users.setId(user_id);
             projetsRepository.deleteByProprietaireOrMembres(users,users);

    }
    public  boolean suprimerParProjetService(UUID projet_id){
        Optional<Projets> optional = projetsRepository.findById(projet_id);
        if (optional.isPresent()) {
            Projets projets = optional.get();
            projetsRepository.deleteById(projet_id);
            return true;
        } else {
            return false;
        }

    }
    public boolean modifierStatutService(UUID projet_id){
        Optional<Projets> optional =projetsRepository.findById(projet_id);
        if(optional.isPresent()){
            optional.get().setStatut(Statut.TERMINE);
            return  true;
        }else {
            return false;

        }
    }


}
