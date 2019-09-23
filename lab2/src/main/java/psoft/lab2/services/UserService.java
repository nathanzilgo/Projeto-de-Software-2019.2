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
}
