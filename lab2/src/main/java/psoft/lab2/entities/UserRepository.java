package psoft.lab2.entities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository<T, String> extends JpaRepository<User, String> {
}
