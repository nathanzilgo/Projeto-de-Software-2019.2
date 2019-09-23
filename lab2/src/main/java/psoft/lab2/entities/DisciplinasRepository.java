package psoft.lab2.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface DisciplinasRepository<T, ID extends Serializable> extends JpaRepository<Disciplina, Long> {
}
