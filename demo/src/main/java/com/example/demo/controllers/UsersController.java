package com.example.demo.controllers;


import com.example.demo.models.Users;
import com.example.demo.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/inscription")
public class UsersController {
    final  private UsersService usersService;
    public  UsersController(UsersService usersService ){
        this.usersService=usersService;


    }
    @PostMapping("/ins")
    public ResponseEntity<String> inscription( @RequestBody Users users ){
         String resultat=usersService.inscriptionService(users);
         if (resultat.equals("le nom est deja utulise")){
             return  new ResponseEntity<>("erreure nom", HttpStatus.BAD_REQUEST);
         } else if (resultat.equals("l'email est deja  utulise")) {
             return  new ResponseEntity<>("erreure eamil",HttpStatus.BAD_REQUEST);
         }else{
             return new ResponseEntity<>(HttpStatus.CREATED);
         }
    }
    @PostMapping("/activation/{code}/{userid}")
    public  ResponseEntity<String> valider(@PathVariable String code , @PathVariable UUID userid){
        if(usersService.validerService(code ,userid)){
            return new ResponseEntity<>("ACTIVE",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("nest pas active",HttpStatus.BAD_REQUEST);
        }


    }
}
