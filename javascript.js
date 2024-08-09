
document.addEventListener('DOMContentLoaded', function() {
    const formulario = document.querySelector("form");
    const ivalor = document.querySelector(".valor input");
    const inomepagador = document.querySelector(".nomepagador ");
    const icpfpagador = document.querySelector(".cpfpagador ");
    const ireferencia = document.querySelector(".referencia ");
    const inomeemissor = document.querySelector(".nomeemissor ");
    const icpfemissor = document.querySelector(".cpfemissor ");
    const itelefone = document.querySelector(".telefone ");
    const icidade = document.querySelector(".cidade ");
    const idata = document.querySelector(".data ");
    const iformapagamento = document.querySelector(".formapagamento ");

    formulario.addEventListener('submit', function gerar(event) {
        event.preventDefault();
        
        // Aqui capturamos o valor do input
        const valorInput = ivalor.value;
        const nomepagador = inomepagador.value;
        const cpfpagador = icpfpagador.value;
        const referencia = ireferencia.value;
        const nomeemissor = inomeemissor.value;
        const cpfemissor = icpfemissor.value;
        const telefone = itelefone.value;
        const cidade = icidade.value;
        const data = idata.value;
        const formapagamento = iformapagamento.value;
        
        
        fetch('http://localhost:8080/user', {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: 'POST',
            body: JSON.stringify({
                // Usamos o valor capturado aqui
                valor: valorInput ,
                nomepagador: nomepagador,
                cpfpagador: cpfpagador,
                referencia: referencia,
                nomeemissor: nomeemissor,
                cpfemissor: cpfemissor,
                telefone: telefone,
                cidade: cidade,
                data: data,
                formapagamento: formapagamento,

            })
        })
        .then(function(res) { console.log(res); })
        .catch(function(error) { console.error(error); });
    });
});

