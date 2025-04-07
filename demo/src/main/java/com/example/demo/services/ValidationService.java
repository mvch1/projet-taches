package com.example.demo.services;

import com.example.demo.models.Users;
import com.example.demo.models.Validation;
import com.example.demo.repositories.ValidationRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Service

public class ValidationService {
   final private ValidationRepository validationRepository;
   final  private  NotificationValidationService notificationValidationService;
   public ValidationService(ValidationRepository validationRepository, NotificationValidationService notificationValidationService){
       this.validationRepository=validationRepository;
       this.notificationValidationService=notificationValidationService;
   }
   public  void valider(Users users){
       Validation validation =new Validation();
       validation.setUsers(users);
       Instant creation=Instant.now();
       Instant expiration=creation.plus(10, ChronoUnit.MINUTES);
       Random random =new Random();
       int rand=random.nextInt(999999);
       String code =String.format("%06d",rand);
       validation.setCode(code);
       validation.setCreation(creation);
       validation.setExpiration(expiration);
       validationRepository.save(validation);
       notificationValidationService.envoiyer(validation);

   }
   public  Validation trouver(Users users){
       return validationRepository.findByUsers(users);
   }
}
