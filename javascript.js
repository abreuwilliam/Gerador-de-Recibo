
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
// Função para limpar os campos
document.querySelector('.Limpar').addEventListener('click', function() {
    limparCampos();
});

function limparCampos() {
    ivalor.value = '';
    inomepagador.value = '';
    icpfpagador.value = '';
    ireferencia.value = '';
    inomeemissor.value = '';
    icpfemissor.value = '';
    itelefone.value = '';
    icidade.value = '';
    idata.value = '';
    iformapagamento.value = '';

}

icpfpagador.addEventListener('keypress', () =>{
let icpfpagadorlegth = icpfpagador.value.length

if(icpfpagadorlegth === 3 || icpfpagadorlegth === 7){
    icpfpagador.value += '.'
}else if (icpfpagadorlegth === 11){
    icpfpagador.value += "-"
}
})
icpfemissor.addEventListener('keypress', () =>{
    let icpfemissorlegth = icpfemissor.value.length
    
    if(icpfemissorlegth === 3 || icpfemissorlegth === 7){
        icpfemissor.value += '.'
    }else if (icpfemissorlegth === 11){
        icpfemissor.value += "-"
    }
    })
    itelefone.addEventListener('keypress', () =>{
        let itelefonelegth = itelefone.value.length
        
        if(itelefonelegth === 0 ){
            itelefone.value += '('
        }else if (itelefonelegth === 3){
            itelefone.value += ")"
        }
        })

  function  formatarCPF(cpfpagador) {
        let cpf = input.value.replace(/\D/g, ''); // Remove todos os caracteres não numéricos

        if (cpf.length <= 11) {
            cpf = cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, "$1.$2.$3-$4"); // Formata o CPF com pontos e hífen
        } else {
            cpf = cpf.replace(/(\d{2})(\d{3})(\d{3})(\d{4})(\d{2})/, "$1.$2.$3/$4-$5"); // Formata o CNPJ
        }

        input.value = cpf; // Atualiza o valor do input
    }
});
