function disciplina(id, nome, creditos, pre_req) {
    let d = {
        id: id,
        nome: nome,
        creditos: creditos,
        pre_requisitos: pre_req,
    }

    d.get_nome = () => {
        d.nome;
    }

    d.id = () => {
        d.id;
    }

    d.creditos = () => {
        d.creditos;
    }

    d.set_nome = function (newNome) {
        d.nome = newNome;
    }

}