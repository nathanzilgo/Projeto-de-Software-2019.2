package psoft.lab2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import psoft.lab2.entities.User;
import psoft.lab2.services.UserService;

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/usuarios")
    public ResponseEntity<User> postUser(String email, String nome, String senha){
        try{
            return new ResponseEntity(userService.newUser(email, nome, senha), HttpStatus.OK);
        }catch(Exception exc){
            return new ResponseEntity(HttpStatus.UNAUTHORIZED); //TODO
        }

    }

    @GetMapping("/auth/usuarios/{email}")
    public ResponseEntity getUser(String email){
        //TODO
    }


    @DeleteMapping("/auth/usuarios")
    public ResponseEntity deleteUser(){
        //TODO
    }
}
