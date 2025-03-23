package com.example.demo.repositories;

import com.example.demo.models.Taches;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TachesRepository extends JpaRepository<Taches, UUID> {
}
