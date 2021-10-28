class Validator {
    constructor(){
        this.validations = [
            'data-required',
            'data-min-length',
            'data-max-length',
            'data-email-validate'
        ]
    }
    // iniciar a validação de todos os campos
    validate(form){

        // resgata todas as validações
        let currentValidations = document.querySelectorAll('form .error-validation');

        if(currentValidations.length > 0) {
            this.cleanValidations(currentValidations);
        }

        // pegar os inputs
        let inputs = form.getElementsByTagName('input');

        // transformo uma HTMLCollections -> array (pra dar o loop)
        let inputsArray = [...inputs];

        // ver funcionando console.log(inputsArray);

        //loop nos inputs e validação mediante ao que for encontrado
        inputsArray.forEach(function(input){
            
            // loop em todas as validações existentes
            for(let i = 0; this.validations.length > i; i++){
                // verifica se a validação atual existe no input
                if(input.getAttribute(this.validations[i]) != null){

                    // limpando a string para virar um método
                    let method = this.validations[i].replace('data-', "").replace('-', '');

                    // valor do input para manipular quando precisar
                    let value = input.getAttribute(this.validations[i]);

                    // invocar o metodo
                    this[method](input, value);
                }
            }
        }, this);
    }

    // verifica se o input tem um número minimo de caracteres
    minlength(input, minValue){
        
        let inputLength = input.value.length;

        let errorMessage = `O campo precisa ter pelo menos ${minValue} caracteres`;

        if(inputLength < minValue){
            // console.log(errorMessage);

            this.printMessage(input, errorMessage);
        }
    }
    // verifica se um input passou do limite de caracteres
    maxlength(input, maxValue){
        let inputLength = input.value.length;

        let errorMessage = `O campo precisa ter menos que ${maxValue} caracteres`;

        if(inputLength > maxValue){
            this.printMessage(input, errorMessage);
        }
    }

    // valida emails
    emailvalidate(input){

        //email@email.com
        let re = /\S+@\S+\.\S+/; //validacao mais relevante no back

        let email = input.value;

        let errorMessage = `Insira um e-mail no padrão nome@email.com`;

        if(!re.test(email)){
            this.printMessage(input, errorMessage);
        }

    }

    // método para imprimir mensagens de erro na página
    printMessage(input, msg){

        // checa os erros presentes no input
        let errorQty = input.parentNode.querySelector('.error-validation');

        if(errorQty === null){
            let template = document.querySelector('.error-validation').cloneNode(true);

            template.textContent = msg;

            let inputParent = input.parentNode;

            template.classList.remove('template');

            inputParent.appendChild(template);
        }
        
    }

    // verifica se o input é requerido
    required(input){
        let inputValue = input.value;
        if(inputValue === ''){
            let errorMessage = `Este campo é obrigatório`;

            this.printMessage(input, errorMessage);
        }
    }

    // limpa as validações da tela
    cleanValidations(validations){
      validations.forEach(el => el.remove());  
    }
}


let form = document.getElementById("register-form"); //id do form
let submit = document.getElementById("btn-submit"); //botão

let validator = new Validator(); //obj

// evento que dispara as validações
submit.addEventListener('click', function(e) {

    e.preventDefault();

    // primeiro vai impidir o formulario de fazer sua execução basica que é enviar pro servidor

    validator.validate(form); //metodo

});

