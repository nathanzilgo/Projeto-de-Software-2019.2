let proto_pessoa = {
    nome: nome,
    fale: function (nome) {
        return "oi, eu sou " + nome;
    }
};

/**
 * Procedimento mais indicado para criar um objeto é especificando seu protótipo
 * @param {} nome 
 */
function create_pessoa(nome) {
    let pessoa = Object.create(proto_pessoa);

    return pessoa;
};

let p1 = create_pessoa('carlin');
let p2 = create_pessoa('kakau');
let p3 = create_pessoa('zequinha');

console.log(p1.fale == p2.fale);
console.log(p2.fale == p3.fale);
console.log(p2.fale == p3.fale);