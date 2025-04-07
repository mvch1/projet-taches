package com.example.demo.services;


import com.example.demo.models.Validation;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class NotificationValidationService {
    JavaMailSender javaMailSender;
    public  NotificationValidationService(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }
    public void  envoiyer(@org.jetbrains.annotations.NotNull Validation validation){
        SimpleMailMessage mailMessage =new SimpleMailMessage();
        mailMessage.setFrom("mvcheikhna@gmail.com");
        mailMessage.setTo(validation.getUsers().getEmail());
        mailMessage.setSubject("validation email ");
        mailMessage.setText(String.format("bon joour %s votre code est %s",validation.getUsers().getName(),validation.getCode()));
        javaMailSender.send(mailMessage);
    }
}
