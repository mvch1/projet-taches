package com.example.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "Taches")

public class Taches {
    @Id
    private UUID id;
    private String titre;
    private String description;
    private Statut statut ;
    private LocalDate dateEcheance;
    @ManyToMany
    @JoinTable(
            name = "Taches_Assignees",
            joinColumns = @JoinColumn(name = "tache_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Users> assigneA;
    @ManyToOne
    @JoinColumn(name = "Users_id")
    private Users createPar;
    private LocalDateTime dateCreation;
    @ManyToOne
    @JoinColumn(name = "Projets_id")
    private Projets projet;
    @OneToMany(mappedBy = "tache")
    List<Notifications> notifications;
    public Taches(){}

    public UUID getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Statut getStatut() {
        return statut;
    }

    public LocalDate getDateEcheance() {
        return dateEcheance;
    }

    public List<Users> getAssigneA() {
        return assigneA;
    }

    public Users getCreatePar() {
        return createPar;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public Projets getProjet() {
        return projet;
    }

    public List<Notifications> getNotifications() {
        return notifications;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateEcheance(LocalDate dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public void setAssigneA(List<Users> assigneA) {
        this.assigneA = assigneA;
    }

    public void setCreatePar(Users createPar) {
        this.createPar = createPar;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setProjet(Projets projet) {
        this.projet = projet;
    }

    public void setNotifications(List<Notifications> notifications) {
        this.notifications = notifications;
    }
}
