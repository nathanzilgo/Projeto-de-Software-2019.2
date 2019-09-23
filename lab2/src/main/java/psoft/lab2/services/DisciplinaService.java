package psoft.lab2.services;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psoft.lab2.entities.ComparatorDisciplinaLikes;
import psoft.lab2.entities.ComparatorDisciplinaNota;
import psoft.lab2.entities.Disciplina;
import psoft.lab2.entities.DisciplinasRepository;

import javax.annotation.PostConstruct;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinasRepository<Disciplina, Long> disciplinaDAO;

    @Autowired
    public DisciplinaService disciplinaService;

    private int atualID = 0;

    /**
     * toda logística de ler o arquivo JSON:
     */
    @PostConstruct
    public void initDisciplinas(){
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Disciplina>> reference = new TypeReference<List<Disciplina>>(){};
        InputStream stream = ObjectMapper.class.getResourceAsStream("./json/disciplinas.json");

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
        this.atualID++;
        this.disciplinaDAO.save(novaDisci);

        return novaDisci;
    }

    public List<Disciplina> listarDisciplinas() {

        List<Disciplina> disci = new ArrayList<Disciplina>();

        disci = disciplinaDAO.findAll();

        return disci;
    }

    public Optional<Disciplina> getDisciplina(Long id) {
        return disciplinaDAO.findById(id);
    }

    public Disciplina mudaNome(Long id, String nome) {

        if(disciplinaDAO.findById(id).isPresent()){

            Disciplina nova = disciplinaDAO.findById(id).get();
            nova.setNome(nome);
            disciplinaDAO.save(nova);

            return nova;
        }
        return null;
    }

    public Disciplina mudaNota(Long id, int nota) {

        if(disciplinaDAO.findById(id).isPresent()){

            Disciplina nova = disciplinaDAO.findById(id).get();
            nova.setNota(nota);
            disciplinaDAO.save(nova);
            return nova;
        }

        return null;
    }

    public void deleteDisciplina(Long id) {
        disciplinaDAO.deleteById(id);

    }

    public boolean containID(Long id) {

        if (disciplinaDAO.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    public List<Disciplina> rankingNota() {

        ComparatorDisciplinaNota comparator = new ComparatorDisciplinaNota();
        List<Disciplina> disci = this.listarDisciplinas();
        disci.sort(comparator);

        return disci;

    }

    public Disciplina putComment(long id, String comment) {

        if(this.disciplinaDAO.findById(id).isPresent()){
            Disciplina nova = disciplinaDAO.findById(id).get();
            nova.addComentario(comment);
            disciplinaDAO.save(nova);

            return nova;
        }
        return null;
    }

    public List<Disciplina> rankingLikes() {
        ComparatorDisciplinaLikes comparator = new ComparatorDisciplinaLikes();
        List<Disciplina> ranking = this.listarDisciplinas();
        ranking.sort(comparator);

        return ranking;
    }

    public Disciplina incrementaLikes(long id) {

        if(this.disciplinaDAO.findById(id).isPresent()){
            Disciplina nova = disciplinaDAO.findById(id).get();
            nova.setLikes(nova.getLikes() + 1);
            disciplinaDAO.save(nova);

            return nova;
        }
        return null;
    }
}