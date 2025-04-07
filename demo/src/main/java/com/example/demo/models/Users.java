package com.example.demo.models;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


@Entity(name ="Users")


public class Users implements UserDetails {
    @Id
    private UUID id=UUID.randomUUID() ;
    @Column(nullable = false,unique = true)
    private String name ;
    private String email;
    @Column(nullable = false)
    private String motdepasse;
    private  boolean actif=false;
    @OneToOne(cascade=CascadeType.ALL )
    private Role role;
    private LocalDateTime dateInscription=LocalDateTime.now();


    public void setActif(boolean actif) {
        this.actif = actif;
    }

    @ManyToMany
    @JoinTable(
            name = "Users_Projets",
            joinColumns = @JoinColumn(name = "Users_id"),
            inverseJoinColumns = @JoinColumn(name = "Projets_id")
    )
    private List<Projets> projets;
    @OneToMany(mappedBy = "proprietaire")
    private List<Projets> projetsPossedes;
    @OneToMany(mappedBy ="createPar" ,cascade = CascadeType.ALL)
    private List<Taches> taches;
    @ManyToMany(mappedBy = "assigneA")
    private List<Taches> tachesAssignees;
    @OneToMany(mappedBy = "proprietaire", cascade = CascadeType.ALL)
    private List<Notifications> notificationsEnvoyees;
    @OneToMany(mappedBy = "destinataire", cascade = CascadeType.ALL)
    private List<Notifications> notificationsRecues;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE"+this.role.getLibelle()));
    }


    @Override
    public boolean isAccountNonExpired() {
        return actif;
    }

    @Override
    public boolean isAccountNonLocked() {
        return actif;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return actif;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isEnabled() {
        return actif;
    }
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public LocalDateTime getDateInscription() {
        return dateInscription;
    }

    public List<Projets> getProjets() {
        return projets;
    }

    public List<Projets> getProjetsPossedes() {
        return projetsPossedes;
    }

    public List<Taches> getTaches() {
        return taches;
    }

    public List<Taches> getTachesAssignees() {
        return tachesAssignees;
    }

    public List<Notifications> getNotificationsEnvoyees() {
        return notificationsEnvoyees;
    }

    public List<Notifications> getNotificationsRecues() {
        return notificationsRecues;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setDateInscription(LocalDateTime dateInscription) {
        this.dateInscription = dateInscription;
    }

    public void setProjets(List<Projets> projets) {
        this.projets = projets;
    }

    public void setProjetsPossedes(List<Projets> projetsPossedes) {
        this.projetsPossedes = projetsPossedes;
    }

    public void setTaches(List<Taches> taches) {
        this.taches = taches;
    }

    public void setTachesAssignees(List<Taches> tachesAssignees) {
        this.tachesAssignees = tachesAssignees;
    }

    public void setNotificationsEnvoyees(List<Notifications> notificationsEnvoyees) {
        this.notificationsEnvoyees = notificationsEnvoyees;
    }

    public void setNotificationsRecues(List<Notifications> notificationsRecues) {
        this.notificationsRecues = notificationsRecues;
    }
}
