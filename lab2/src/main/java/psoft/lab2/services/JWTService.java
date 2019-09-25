package psoft.lab2.services;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;
import psoft.lab2.entities.User;

import javax.servlet.ServletException;
import java.security.SignatureException;
import java.util.Optional;

@Service
public class JWTService {
    private UserService userService;

    public JWTService(UserService usuariosService) {
        super();
        this.userService = usuariosService;
    }

    public boolean usuarioExiste(String authorizationHeader) throws ServletException {
        String subject = getSujeitoDoToken(authorizationHeader);

        return userService.getUser(subject).isPresent();
    }

    public boolean usuarioTemPermissao(String authorizationHeader, String email) throws ServletException {
        String subject = getSujeitoDoToken(authorizationHeader);

        Optional<User> optUsuario = userService.getUser(subject);
        return optUsuario.isPresent() && optUsuario.get().getEmail().equals(email);
    }

    private String getSujeitoDoToken(String authorizationHeader) throws ServletException {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new ServletException("Token inexistente ou mal formatado!");
        }

        // Extraindo apenas o token do cabecalho.
        String token = authorizationHeader.substring(psoft.lab2.filters.TokenFilter.TOKEN_INDEX);

        String subject = null;
        try {
            subject = Jwts.parser().setSigningKey("login do batman").parseClaimsJws(token).getBody().getSubject();

        } catch (SignatureException e) {
            throw new ServletException("Token invalido ou expirado!");
        }
        return subject;
    }
}
