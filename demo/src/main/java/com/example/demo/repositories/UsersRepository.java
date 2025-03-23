package com.example.demo.repositories;

import com.example.demo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {
}
