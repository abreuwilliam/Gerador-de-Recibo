const formulario = document.querySelector("form");

const ivalor = document.querySelector(".valor input");


formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    console.log(ivalor.value)
    
    
});