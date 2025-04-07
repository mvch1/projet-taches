package com.example.demo.models;


import jakarta.persistence.*;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  int id ;
    private TypeRole libelle;

    public void setLibelle(TypeRole libelle) {
        this.libelle = libelle;
    }

    public TypeRole getLibelle() {
        return libelle;
    }
}
