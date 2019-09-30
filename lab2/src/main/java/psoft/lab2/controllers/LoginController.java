package psoft.lab2.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import psoft.lab2.entities.User;
import psoft.lab2.services.UserService;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.Optional;


class LoginResponse {
    public String token;

    public LoginResponse(String token) {
        this.token = token;
    }
}

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final String TOKEN_KEY = "thyago";

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public LoginResponse authenticate(@RequestBody User user) throws ServletException{

        Optional<User> authUsuario = userService.getUser(user.getEmail());

        if (!authUsuario.get().getSenha().equals(user.getSenha())) {
            throw new ServletException("Senha invalida!");
        }

        if(userService.verifyPassword(user.getEmail(), user.getSenha())){
            String token = geraToken(authUsuario.get().getEmail());

            return new LoginResponse(token);
        }

        throw new ServletException("Senha invalida!");
    }

    public String geraToken(String email) {
        return Jwts.builder().setSubject(email)
                .signWith(SignatureAlgorithm.HS512, TOKEN_KEY)
                .setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000)).compact();
    }
}
