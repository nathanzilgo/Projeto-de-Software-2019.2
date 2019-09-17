package psoft.lab2.entities;

import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Objects;

@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;
    private double nota;
    private String comentarios;
    private int likes;

    public Disciplina(long id, String nome, double nota, String comentarios, int likes) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.comentarios = comentarios;
        this.likes = likes;
    }

    public Disciplina(long id, String nome, double nota) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.comentarios = "";
        this.likes = 0;
    }

    public Disciplina(String nome) {
        this.id = this.hashCode();      //TODO pensar melhor no id
        this.nome = nome;
        this.comentarios = "";
        this.likes = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Double.compare(that.nota, nota) == 0 &&
                likes == that.likes &&
                nome.equals(that.nome) &&
                Objects.equals(comentarios, that.comentarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, nota, comentarios, likes);
    }
}
