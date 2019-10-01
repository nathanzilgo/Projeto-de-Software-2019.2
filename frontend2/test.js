function create_pessoa(nome) {
    return {
        nome: nome,
        fale: function () {
            return "oi, meu confadre, eu sou " + nome
        }
    };
}

function create_turma(disciplina, vagas) {
    let turma = {};
    turma.alunosList = [];
    turma.vagasQuant = vagas;
    turma.disciplina = disciplina;

    turma.matricule = function (aluno) {
        if (this.vagasQuant > 0) {
            this.alunosList.push(aluno);
            this.vagasQuant -= 1;

            return true;
        }
        return false;
    }

    turma.alunos = function () {
        return this.alunosList;
    }

    turma.vagas = function () {
        return this.vagasQuant;
    }

    return turma;
}


var p = create_pessoa('Albert Einstein');
console.log(p.fale());


var t1 = create_turma('psoft', 30);
var t2 = create_turma('bd', 10);

console.log(t1.vagas());

for (var i = 0; i < 31; i++) {
    console.log(t1.matricule('kakau'));
}

console.log(t1.vagas());