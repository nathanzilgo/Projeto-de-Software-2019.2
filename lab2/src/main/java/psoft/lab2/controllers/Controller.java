package psoft.lab2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import psoft.lab2.entities.User;
import psoft.lab2.services.DisciplinaService;
import psoft.lab2.entities.Disciplina;
import psoft.lab2.services.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private DisciplinaService disciplinaService;
    @Autowired
    private UserService userService;

    @PostMapping("/auth/usuarios")
    public ResponseEntity<User> postUser(String email, String nome, String senha){
        return new ResponseEntity<User>(userService.newUser(email, nome, senha), HttpStatus.OK);
    }

    @GetMapping("/auth/usuarios/{email}")
    public RequestMapping getUser(String email){

    }

    @PostMapping("/auth/login")
    public RequestMapping verifyUser(String email, String senha){

    }

    @DeleteMapping("/auth/usuarios")
    public ResponseEntity deleteUser(){

    }

    @GetMapping("/api/disciplinas")
    public ResponseEntity<List<Disciplina>> getDisciplinas(){
        return new ResponseEntity<List<Disciplina>>(disciplinaService.listarDisciplinas(), HttpStatus.OK);
    }

    @GetMapping("/api/disciplinas/{id}")
    public ResponseEntity getDisciplina(long id){
        return new ResponseEntity(disciplinaService.getDisciplina(id), HttpStatus.OK);
    }

    @PutMapping("/api/disciplinas/{id}/likes")
    public ResponseEntity updateLikes(long id){
        return new ResponseEntity(disciplinaService.incrementaLikes(id), HttpStatus.OK);
    }

    @PutMapping("/api/disciplinas/{id}/nota")
    public ResponseEntity updateNota(long id, int nota){
        return new ResponseEntity<Disciplina>(disciplinaService.mudaNota(id, nota), HttpStatus.OK);
    }

    @PutMapping("/api/disciplinas/comentarios/{id}")
    public ResponseEntity putComment(long id, String comment){
        return new ResponseEntity(disciplinaService.putComment(id, comment), HttpStatus.OK);
    }

    @GetMapping("/api/disciplinas/ranking/notas")
    public ResponseEntity rankingNotas(){
        return new ResponseEntity(disciplinaService.rankingNota(), HttpStatus.OK);
    }

    @GetMapping("/api/disciplinas/ranking/likes")
    public ResponseEntity rankingLikes(){
        return new ResponseEntity(disciplinaService.rankingLikes(), HttpStatus.OK);
    }

}
