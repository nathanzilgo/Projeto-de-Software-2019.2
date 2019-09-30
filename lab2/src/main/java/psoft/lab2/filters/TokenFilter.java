package psoft.lab2.filters;

import io.jsonwebtoken.*;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SignatureException;

public class TokenFilter extends GenericFilterBean {

    public final static int TOKEN_INDEX = 7;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String header = req.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            throw new ServletException("Token inexistente ou mal formatado!");
        }

        // Extraindo apenas o token do cabecalho.
        String token = header.substring(TOKEN_INDEX);

        try {
            Jwts.parser().setSigningKey("login do batman").parseClaimsJws(token).getBody();
        } catch(ExpiredJwtException | MalformedJwtException | PrematureJwtException | UnsupportedJwtException | IllegalArgumentException e) {

            //aqui optamos por tratar todas as exceções que podem ser lançadas da mesma forma e simplesmente
            //repassar a mensagem de erro
            //se quiser enviar mensagens em portugues mais personalizadas teria que capturar exceção
            //por exceção
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());

            return;//a requisição nem precisa passar adiante, retornar já para o cliente pois não pode prosseguir
            //daqui pra frente por falta de autorização
        }

        chain.doFilter(request, response);
    }
}
