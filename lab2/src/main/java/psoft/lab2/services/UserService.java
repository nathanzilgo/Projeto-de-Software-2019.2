package psoft.lab2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psoft.lab2.entities.Disciplina;
import psoft.lab2.entities.User;
import psoft.lab2.entities.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userDAO;

    public User newUser(String email, String nome, String senha) {
        User newUser = new User(email, nome, senha);
        userDAO.save(newUser);

        return newUser;
    }

    public Optional<User> getUser(String email){
        if(userDAO.findById(email).isPresent()){
            return userDAO.findById(email);
        }

        throw new IllegalArgumentException("Usuario não encontrado!");
    }

    public boolean verifyPassword(String email, String senha) {

        if(userDAO.findById(email).isPresent()){
            User tmp = (User) userDAO.findById(email).get();
            if(tmp.getSenha().equals(senha)){
                return true;
            }
            return false;
        }

        throw new IllegalArgumentException("Email não encontrado!");
    }
}
