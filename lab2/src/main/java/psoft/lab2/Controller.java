package psoft.lab2;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @PostMapping("/v1/auth/usuarios")
    public RequestMapping postUser(String email, String nome, String senha){

    }

    @GetMapping("/v1/auth/usuarios/{email}")
    public RequestMapping getUser(String email){

    }

    @PostMapping("/v1/auth/login")
    public RequestMapping verifyUser(String email, String senha){

    }

    @DeleteMapping("/v1/auth/usuarios")
    public RequestMapping deleteUser(){

    }

    @GetMapping("/v1/api/disciplinas")
    public RequestMapping getDisciplinas(){

    }

    @GetMapping("/v1/api/disciplinas/{id}")
    public RequestMapping getDisciplina(){

    }

    @PutMapping("/v1/api/disciplinas/{id}/likes")
    public RequestMapping updateLikes(){

    }

    @PutMapping("/v1/api/disciplinas/{id}/nota")
    public RequestMapping updateNota(){

    }

    @PostMapping("/v1/api/disciplinas/{id}/comentarios")
    public RequestMapping postComment(){

    }

    @GetMapping("/v1/api/disciplinas/ranking/notas")
    public RequestMapping
}
