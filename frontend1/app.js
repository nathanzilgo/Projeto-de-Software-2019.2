console.log('app rodando!');

var $disciplinas = document.querySelector("div");

function fetch_disciplinas(){
    let URL = 'https://lab01-projsw-ufcg.herokuapp.com/api/disciplinas';
    fetch(URL)
    .then(response => response.json())
    .then(dados => {
        console.log(dados);
        window.disciplinas = dados;
        

        dados.forEach(element => {
            var content = document.createElement('p');
            content.innerText = "id: " + element.id + "; nome: " + element.nome + "; nota: " + element.nota;

            $disciplinas.appendChild(content);

        });
    });
}

window.fd = fetch_disciplinas;
fetch_disciplinas();

