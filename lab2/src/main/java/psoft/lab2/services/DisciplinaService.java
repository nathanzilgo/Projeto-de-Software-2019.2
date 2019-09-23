package psoft.lab2.services;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psoft.lab2.entities.ComparatorDisciplina;
import psoft.lab2.entities.Disciplina;
import psoft.lab2.entities.DisciplinasRepository;

import javax.annotation.PostConstruct;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinasRepository<Disciplina, Long> disciplinaDAO;

    public DisciplinaService(DisciplinasRepository disciplinaDAO){
        this.disciplinaDAO = disciplinaDAO;
    };

    private int atualID = 0;

    /**
     * toda logística de ler o arquivo JSON:
     */
    @PostConstruct
    public void initDisciplinas(){
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Disciplina>> reference = new TypeReference<List<Disciplina>>(){};
        InputStream stream = ObjectMapper.class.getResourceAsStream("/json/disciplinas.json");

        try{
            List<Disciplina> disciplinas = mapper.readValue(stream, reference);

            this.disciplinaDAO.saveAll(disciplinas);
            System.out.println("Disciplinas salvas no banco!");
        }
        catch(IOException excp){
            System.out.println("Não foi possível salvar as disciplinas: " + excp.getMessage());
        }
    }

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