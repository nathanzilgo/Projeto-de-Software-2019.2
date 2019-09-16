package psoft.lab2;

public class Disciplina {
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
}
