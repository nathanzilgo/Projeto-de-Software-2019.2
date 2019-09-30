function create_pessoa(nome) {
    let pessoa = {}; // Criação do objeto vazio
    pessoa.nome = nome; // Adiciona o atributo nome
    pessoa.fale = function () { // Adiciona a função fale
        return "oi meu confadre eu sou " + pessoa.nome
    };

    return pessoa;
}

function create_turma(disciplina, vagas) {
    let turma = {};
    turma.alunos = [];
    turma.vagas = vagas;
    turma.disciplina = disciplina;

    turma.matricule = function (aluno) {
        if (this.vagas > 0) {
            this.alunos.push(aluno);
            this.vagas--;

            return true;
        }
        return false;
    }

    turma.alunos = function () {
        return this.alunos;
    }

    turma.vagas = function () {
        return this.vagas;
    }
}

/**
 * p = create_pessoa('Albert Einstein');
    console.log(p.fale());
 */

t1 = create_turma('psoft', 30);
t2 = create_turma('bd', 10);