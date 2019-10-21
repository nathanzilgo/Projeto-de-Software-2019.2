let assert = require('assert');
let disciplina = require('./scoord').disciplina;
let estudante = require('./scoord').estudante;
let professor = require('./scoord').professor;

describe('factory Disciplina', function () {
  let d0;

  before(async () => {
    d0 = disciplina('prog1', 'Programação 1', 4, []);
  })

  it('deve criar disciplinas distintas a cada invocação', function () {
    d0 = disciplina('prog1', 'Programação 1', 4, []);
    d1 = disciplina('prog1', 'Programação 1', 4, []);
    d2 = disciplina('prog1', 'Programação 1', 4, []);
    assert.notEqual(d0, d1);
    assert.notEqual(d0, d2);
    assert.notEqual(d1, d2);
  });

  it('deve reter os dados de inicialização', function () {
    assert.equal('prog1', d0.id());
    assert.equal('Programação 1', d0.get_nome());
    assert.equal(4, d0.creditos);
    assert.deepEqual([], d0.pre_requisitos);
  });

  it('deve permitir atualização de nome', function () {
    d0.set_nome('Programação de Computadores I')
    assert.equal('prog1', d0.id());
    assert.equal('Programação de Computadores I', d0.get_nome());
    assert.deepEqual([], d0.pre_requisitos);
  });

  it('não deve permitir atualização de id via set_id', function () {
    assert.throws(function () {
      d0.set_id('outro')
    }, TypeError);
    assert.equal('prog1', d0.id());
  });

});

describe('factory Estudante', function(){
  let e0;

  before(async () => {
    e0 = estudante('116110522', 'dalton serey', 'dalton@dsc.ufcg.edu.br', '00000000000', 'https://google.com');
  });

  it('Deve criar estudantes distintos a cada invocação', function(){
    e1 = estudante('116110522', 'dalton serey', 'dalton@dsc.ufcg.edu.br', '00000000000', 'https://google.com');
    e2 = estudante('116110522', 'dalton serey', 'dalton@dsc.ufcg.edu.br', '00000000000', 'https://google.com');

    assert.notEqual(e0,e1);
    assert.notEqual(e0,e2);
    assert.notEqual(e2,e1);
  });

  it('Deve reter os dados de inicialização', function() {
    assert.equal('116110522', e0.get_matricula());
    assert.equal('dalton serey', e0.nome);
    assert.equal('dalton@dsc.ufcg.edu.br', e0.email);
    assert.equal('00000000000', e0.cpf);
    assert.equal('https://google.com', e0.url);
  });

  it('Deve permitir mudança de nome', function() {
    e0.set_nome('joao');
    assert.equal('joao', e0.nome);
  });

  it('Não deve permitir mudança de matricula por set_matricula', function(){
    assert.throws(function(){
      e0.set_matricula('outra')
    }, TypeError);
    assert.equal('116110522', e0.get_matricula);
  })

})

describe('factory Professor', function(){
  let p0;

  before(async () => {
    p0 = professor('3333', 'dalton', 'dalton@dsc.ufcg.edu.br', '8888888888', 'https://youtube.com');
  });

  it('')
})