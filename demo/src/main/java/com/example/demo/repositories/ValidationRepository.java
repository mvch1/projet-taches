package com.example.demo.repositories;

import com.example.demo.models.Users;
import com.example.demo.models.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public  interface ValidationRepository extends JpaRepository<Validation,Long> {
    Validation findByUsers(Users users);


}
