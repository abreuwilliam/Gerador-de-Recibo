const formulario = document.querySelector("form");

const ivalor = document.querySelector(".valor input");
const inomepagador = document.querySelector(".nomepagador ");
const icpfpagador = document.querySelector(".cpfpagador input");
const ireferencia = document.querySelector(".referencia input");
const inomeemissor = document.querySelector(".nomeemissor input");
const icpfemissor = document.querySelector(".cpfemissor input");
const itelefone = document.querySelector(".telefone input");
const icidade = document.querySelector(".cidade input");
const idata = document.querySelector(".data input");

formulario.addEventListener('submit', function (event) {
    event.preventDefault();
    const dataSelecionada = idata.value;

    // Enviando os dados para o servlet usando Fetch
    fetch('/seu-servlet', {
        method: 'POST',
        body: JSON.stringify({ data: dataSelecionada })
    })
    .then(response => response.json())
    .then(data => console.log('Success:', data))
    .catch(error => console.error('Error:', error));
});