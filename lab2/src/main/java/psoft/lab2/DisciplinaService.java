package psoft.lab2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    private int atualID = 0;
    private HashMap<Integer, Disciplina> disciplinas = new HashMap<Integer, Disciplina>();

    public Disciplina criaNovaDisciplina(Disciplina disciplina) {
        Disciplina novaDisci = new Disciplina(this.atualID, disciplina.getNome(), disciplina.getNota());
        disciplinas.put(this.atualID, novaDisci);
        this.atualID++;
        return this.disciplinas.get(atualID - 1);
    }

    public ArrayList<Disciplina> listarDisciplinas() {
        ArrayList<Disciplina> disci = new ArrayList<Disciplina>();
        for (Integer item : disciplinas.keySet()) {
            disci.add(disciplinas.get(item));
        }

        return disci;

    }

    public Disciplina getDisciplina(int id) {
        return disciplinas.get(id);
    }

    public void mudaNome(int id, String nome) {
        disciplinas.get(id).setNome(nome);

    }

    public void mudaNota(int id, int nota) {
        disciplinas.get(id).setNota(nota);
    }

    public void deleteDisciplina(int id) {
        disciplinas.remove(id);

    }

    public boolean containID(int id) {
        if (disciplinas.containsKey(id)) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Disciplina> ranking() {
        ComparatorDisciplina comparator = new ComparatorDisciplina();
        ArrayList<Disciplina> disci = this.listarDisciplinas();
        disci.sort(comparator);
        return disci;

    }

}