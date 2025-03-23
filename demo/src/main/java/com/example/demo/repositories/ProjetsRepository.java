package com.example.demo.repositories;

import com.example.demo.models.Projets;
import com.example.demo.models.Statut;
import com.example.demo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProjetsRepository extends JpaRepository<Projets, UUID> {
  List<Projets> findByProprietaireAndStatut(Users proprietaire, Statut statut);
  List<Projets>  findByProprietaireOrMembres(Users   membre,Users proprietaire);
  List<Projets> findByProprietaire(Users users);
  List<Projets> findByMembresContaining(Users users);
  void  deleteByProprietaireOrMembres(Users users ,Users destinataire);

}

