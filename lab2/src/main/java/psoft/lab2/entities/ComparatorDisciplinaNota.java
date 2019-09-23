package psoft.lab2.entities;

import java.util.Comparator;

public class ComparatorDisciplinaNota implements Comparator<Disciplina>{

    @Override
    public int compare(Disciplina a, Disciplina b){

        if(a.getNota() < b.getNota()) return 1;
        else if(a.getNota() > b.getNota()) return -1;

        return 0;
    }
}
