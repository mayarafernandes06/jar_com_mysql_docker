var x = document.getElementById("login");
var y = document.getElementById("cadastro");
var z = document.getElementById("btn");

function cadastro() {
    x.style.left = "-400px";
    y.style.left = "50px";
    z.style.left = "110px";
}
function login() {
    x.style.left = "50px";
    y.style.left = "450px";
    z.style.left = "0";
}


// function entrar() {
//     event.preventDefault();

//     let email_login = (email1.value);
//     let senha_login = (senha1.value);

//     if (email_login.indexOf('@') == -1 || email_login.indexOf('.com') == -1 || !email_login) {
//         alert('O formato de email é: usuario@extensao.com')
//     }

//     else if (senha_login <= 5) {
//         alert('Sua senha deve conter até no mínimo cinco caracteres')
//     }
//     else {
//         window.location.href = 'dashboard.html';
//         return false;

//     }
// }


// function registrar() {
//     event.preventDefault();

//     let nome = (nomesobrenome.value);
//     nome = nome.trimStart().trimEnd();

//     let telefone = (tel.value);
//     telefone = telefone.trimStart().trimEnd();

//     let email_cadastro = (email2.value);
//     email_cadastro = email_cadastro.trimStart().trimEnd();

//     let senha_cadastro = (senha2.value);
//     senha_cadastro = senha_cadastro.trimStart().trimEnd();
//     texto2.innerHTML = '';
//     erros2 = [];
//     if (nome.length == 0 || nome.search(" ") == -1 ||
//         nome[nome.length - 1] == " " ||
//         nome[0] == " ") {
//         alert("Nome inválido");
//     }

//     if (telefone.length == 0) {
//         alert('Telefone inválido')
//     }

//     if (email_cadastro.indexOf('@') == -1 || email_cadastro.indexOf('.com') == -1 || !email_cadastro) {
//         alert('O formato de email é: usuario@extensao.com')
//     }

//     else if (senha_cadastro < 5) {
//         alert('Sua senha deve conter até no mínimo cinco caracteres')
//     }
//     else {
//         alert(`Estamos quase lá, ${nome}!! Verifique agora seu email para confirmação`);
//         window.location.href = 'subcadastro.html';
//         return false;

//     }

// }

type = "text/javascript" >
$("#tel").mask("(00) 00000-0000");
$("#cnpj").mask("00.000.000/0000-00");
$("#cep").mask("00000-000");
$("#num").mask("000");
