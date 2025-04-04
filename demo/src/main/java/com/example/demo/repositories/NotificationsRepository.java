package com.example.demo.repositories;

import com.example.demo.models.Notifications;
import com.example.demo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NotificationsRepository extends JpaRepository<Notifications, UUID> {
    List<Notifications> findByDestinataireAndLueFalse(Users destinateire);
    Notifications findTopByDestinataireOrderByDateEnvoiDesc(Users destinataire);
    void deleteAllByDestinataire(Users destinataire);


}


