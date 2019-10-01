function Pessoa(nome) {
    //this = Object.create(Pessoa.prototype);
    this.nome = nome;
    this.fale = function () {
        return "oi, eu sou " + this.nome;
    };
    //return this;
}
/**
 * Por baixo dos panos o que o operador new faz é exatamente o que falta ao código acima.
 */
let p1 = new Pessoa('charles');

// EXEMPLO:

function Pessoa(nome) {
    this.nome = nome;
    return this;
}

Pessoa.prototype.fale = function () {
    return "oi, eu sou " + this.nome;
}

let p2 = new Pessoa('geraldo');
console.log(p2.fale());