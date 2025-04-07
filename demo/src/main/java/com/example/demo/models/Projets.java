package com.example.demo.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static com.example.demo.models.Statut.EN_COURS;

@Entity(name = "Projets")


public class Projets {
    @Id
    private UUID id ;
    @Column(nullable = false,unique = true)
    private  String nom;
    private   String description;
    private LocalDateTime dateCreation=LocalDateTime.now() ;
    @Enumerated(EnumType.STRING)
    private Statut statut=Statut.EN_COURS;

    @ManyToOne()
    @JoinColumn(name = "proprietaire_id")
    private Users proprietaire;
    @ManyToMany(mappedBy = "projets")
    private     List<Users> membres;
    @OneToMany(mappedBy ="projet" ,cascade = CascadeType.ALL )
    private List<Taches> taches ;
    @OneToMany(mappedBy = "projets")
    private  List<Notifications> notifications;
    public Projets(){}

    public UUID getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public Statut getStatut() {
        return statut;
    }

    public Users getProprietaire() {
        return proprietaire;
    }

    public List<Users> getMembres() {
        return membres;
    }

    public List<Taches> getTaches() {
        return taches;
    }

    public List<Notifications> getNotifications() {
        return notifications;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public void setMembres(List<Users> membres) {
        this.membres = membres;
    }

    public void setProprietaire(Users proprietaire) {
        this.proprietaire = proprietaire;
    }

    public void setTaches(List<Taches> taches) {
        this.taches = taches;
    }

    public void setNotifications(List<Notifications> notifications) {
        this.notifications = notifications;
    }
}
