package psoft.lab2.entities;

import java.util.Comparator;

public class ComparatorDisciplinaLikes implements Comparator<Disciplina>{

    @Override
    public int compare(Disciplina a, Disciplina b){

        if(a.getLikes() < b.getLikes()) return 1;
        else if(a.getLikes() > b.getLikes()) return -1;

        return 0;
    }
}
