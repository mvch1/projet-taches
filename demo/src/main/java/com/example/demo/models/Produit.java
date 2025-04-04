package com.example.demo.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name ="produit")
public class Produit {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false)
    public String name ;
    public String email;
    public Produit(){}
    public Long getId(){
        return id;
    }
    public void  setId(Long id){
        this.id=id;
    }

    public String getName(){
        return name;

    }
    public void  setName(String name){
        this.name=name;
    }
    public String getEmail(){
        return email;

    }
    public void  setEmail(String email){
        this.email=email;
    }
}
