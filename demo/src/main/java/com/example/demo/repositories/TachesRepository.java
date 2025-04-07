package com.example.demo.repositories;

import com.example.demo.models.Projets;
import com.example.demo.models.Taches;
import com.example.demo.models.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TachesRepository extends JpaRepository<Taches, UUID> {

    List<Taches> findByCreateParOrAssigneA(Users assigneA, Users createPar);
    void  deleteByProjet(Projets projets);

}
