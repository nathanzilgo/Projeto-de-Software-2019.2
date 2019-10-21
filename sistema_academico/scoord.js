possiveisEstados = ["planejada", "ativa", "concluída"];

function disciplina(id, nome, creditos, pre_req) {

    let d = {
        id: id,
        nome: nome,
        creditos: creditos,
        pre_requisitos: pre_req,

        get_nome: function () {
            return nome;
        },

        id: function () {
            return id;
        },

        set_nome: function (newNome) {
            nome = newNome
        },
    }

    return d;
}

function turma(disc, periodo) {

    let t = {
        disciplina: disc,
        periodo: periodo,
        professor: null,
        estudantes: [],

        setProfessor: function (nome) {
            this.professor = nome;
        },

        matriculaEstudantes: function (estudante) {
            if (!(estudante in this.estudantes) && status != possiveisEstados[2]) {
                this.estudantes.push(estudante);
            }
        },

        status: possiveisEstados[0],

        set_status: function (novo) {
            if (novo in possiveisEstados) {
                this.status = novo;
            }
        }
    }

    return t;
}

function professor(matricula, nome, email, cpf, foto) {
    let privateMatricula = matricula;

    let p = {
        nome: nome,
        email: email,
        cpf: cpf,
        foto: foto,
        turmas: [],

        get_Matricula: () => {
            return privateMatricula
        },

        set_Nome: function (novo) {
            this.nome = novo;
        },

        aloca_turma: function (t) {
            t.professor = this;
        },

        turmas(semestre) {
            return this.turmas.filter(t.periodo == semestre).disciplina;
        }
    }

    return p;
}

function estudante(matricula, nome, email, cpf, url) {
    let privateMatricula = matricula;

    let e = {
        nome: nome,
        email: email,
        cpf: cpf,
        foto: foto,
        turmas: [],

        get_Matricula: () => {
            return privateMatricula;
        },

        matricula: function (turma) {
            turma.matriculaEstudantes(this);
            this.turmas.push(turma);
        },

        turmas: function (semestre) {
            return this.turmas.filter(t.periodo == semestre).disciplina;
        }
    }

    return e;
}

exports.disciplina = disciplina;