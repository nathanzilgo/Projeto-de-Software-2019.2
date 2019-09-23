package psoft.lab2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psoft.lab2.entities.Disciplina;
import psoft.lab2.entities.User;
import psoft.lab2.entities.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userDAO;

    public User newUser(String email, String nome, String senha) {
        User newUser = new User(email, nome, senha);
        userDAO.save(newUser);

        return newUser;
    }

    public User authenticateLogin(String email, String senha) {
        if(userDAO.findById(email).isPresent()){

            User u = (User) userDAO.findById(email).get();
            if (u.getSenha().equals(senha)){
                // TODO
            }
        }
    }
}
