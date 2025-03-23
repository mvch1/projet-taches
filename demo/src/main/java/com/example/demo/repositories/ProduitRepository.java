package com.example.demo.repositories;

import com.example.demo.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {

}
