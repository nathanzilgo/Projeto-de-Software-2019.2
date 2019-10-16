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
    };
    return d;
}

exports.disciplina = disciplina;