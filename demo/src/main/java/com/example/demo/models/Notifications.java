package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name ="Notifications")


public class Notifications {
    @Id
    private UUID id;
    private String message;
    @ManyToOne(optional = true)
    @JoinColumn(name = "destinataire_id")
    private Users destinataire;
    private boolean lue=false ;
    private  LocalDateTime dateEnvoi=LocalDateTime.now();
    @ManyToOne(optional = true)
    @JoinColumn(name = "Taches_id")
    private Taches tache;
    @ManyToOne(optional = true)
    @JoinColumn(name ="proprietaire_id")
    private  Users proprietaire;
    @ManyToOne(optional = true)
    @JoinColumn(name = "Projets_id")
    private  Projets projets ;

    public Notifications(){}
    public UUID getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Users getDestinataire() {
        return destinataire;
    }

    public boolean isLue() {
        return lue;
    }

    public LocalDateTime getDateEnvoi() {
        return dateEnvoi;
    }

    public Taches getTache() {
        return tache;
    }

    public Users getProprietaire() {
        return proprietaire;
    }

    public Projets getProjets() {
        return projets;
    }

    public void setProjets(Projets projets) {
        this.projets = projets;
    }

    public void setProprietaire(Users proprietaire) {
        this.proprietaire = proprietaire;
    }

    public void setTache(Taches tache) {
        this.tache = tache;
    }

    public void setDateEnvoi(LocalDateTime dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public void setLue(boolean lue) {
        this.lue = lue;
    }

    public void setDestinataire(Users destinataire) {
        this.destinataire = destinataire;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
