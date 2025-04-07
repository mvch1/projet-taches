package com.example.demo.services;

import com.example.demo.models.Role;
import com.example.demo.models.TypeRole;
import com.example.demo.models.Users;
import com.example.demo.models.Validation;
import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsersService  implements UserDetailsService {

      private UsersRepository usersRepository ;
      private BCryptPasswordEncoder bCryptPasswordEncoder;
      private ValidationService validationService;


    @Override
    public UserDetails loadUserByUsername(String email ) throws UsernameNotFoundException {
       return this.usersRepository
               .findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("aucun utulisateur "));

    }
  public  UsersService(){

    }
    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Autowired
    public void setBCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Autowired
    public void setValidationService(ValidationService validationService) {
        this.validationService = validationService;
    }
  public  String inscriptionService (Users users){
        Optional<Users> op1=usersRepository.findByName(users.getName());
        if (op1.isPresent()){
            return  "le nom est deja utulise";
        }
      Optional<Users> op2=usersRepository.findByEmail(users.getEmail());
        if (op2.isPresent()){
            return  "l'email est deja  utulise";

        }

      String crpmotdepass = bCryptPasswordEncoder.encode(users.getMotdepasse());
      users.setMotdepasse(crpmotdepass);
      Role roleusers = new Role();
      roleusers.setLibelle(TypeRole.MEMBRE);
      users.setRole(roleusers);
      Users us= this.usersRepository.save(users);
      validationService.valider(us);


      return  "est valide ";
  }
  public  boolean validerService(String code , UUID userid) {
      Instant inst = Instant.now();
      Users users;
      users = new Users();
      users.setId(userid);
      Validation validation = validationService.trouver(users);
      if (code == validation.getCode() && validation.getExpiration().isAfter(inst)) {
          users.setActif(true);
          usersRepository.save(users);
          return true;
      } else {
          return false;
      }

  }



}
