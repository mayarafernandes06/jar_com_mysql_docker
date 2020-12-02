function configurar2(){
    var config_ram = {
        type: 'line',
        data: {
        },
        options: {
            responsive: true,
            title: {
                display: true,
                text: 'Gráfico do histórico de memória RAM'
            },
            tooltips: {
                mode: 'index',
                intersect: false,
            },
            hover: {
                mode: 'nearest',
                intersect: true
            },
            scales: {
                xAxes: [{
                    display: true,
                    scaleLabel: {
                        display: true,
                        labelString: 'Horário da Leitura'
                    }
                }],
                yAxes: [{
                    display: true,
                    scaleLabel: {
                        display: true,
                        labelString: 'Porcentual de uso de memória RAM'
                    }
                }]
            }
        }
    };
    return config_ram;
}



var dados2 = {labels: [],
    datasets: [{
        data: [],
        backgroundColor: [
            '#ff6781',
        ],
        borderColor: [
            '#ff6781',
        ],
        borderWidth: 2,
        pointBackgroundColor: '#ffd000',
        pointBorderWidth: 1,
        fill: false,
        
    }]}


         





// window.onload = function() {
//     var ctx = document.getElementById('graficoCPU').getContext('2d');
//     var ctx2 = document.getElementById('graficoRAM').getContext('2d');
//     var ctx3 = document.getElementById('graficoDISCO').getContext('2d');
//     window.mycpu = new Chart(ctx, config_cpu);
//     window.myram = new Chart(ctx2, config_ram);
//     window.mydisco = new Chart(ctx3, config_disco);
//     loop_cpu();
//     loop_ram();
//     loop_disco();
// };

// function gerarDadoCpu() {
//     var dado = parseInt(Math.random() * 101);

//     quantidade_cpu.innerHTML = `${dado}%`;
//     if (dado <= 45) {
//         quantidade_cpu.innerHTML = `<h2><span style="color: green;">${dado}%</span></h2>`;;
//     } else if (dado >= 90) {
//         quantidade_cpu.innerHTML = `<h2><span style="color: red;">${dado}%</span></h2>`;
//     } else {
//         quantidade_cpu.innerHTML = `<h2><span style="color: yellow;">${dado}%</span></h2>`;
//     }
//     return dado;
// }

// function gerarDadoRam() {
//     var dado = parseInt(Math.random() * 101);
    
//     quantidade_ram.innerHTML = `${dado}%`;
//     if (dado <= 45) {
//         quantidade_ram.innerHTML = `<h2><span style="color: green;">${dado}%</span></h2>`;;
//     } else if (dado >= 90) {
//         quantidade_ram.innerHTML = `<h2><span style="color: red;">${dado}%</span></h2>`;
//     } else {
//         quantidade_ram.innerHTML = `<h2><span style="color: yellow;">${dado}%</span></h2>`;
//     }
   
//     return dado;

// }

// function gerarDadoDisco() {
//     var dado = parseInt(Math.random() * 101);

//     quantidade_disco.innerHTML = `${dado}%`;
//     if (dado <= 45) {
//         quantidade_disco.innerHTML = `<h2><span style="color: green;">${dado}%</span></h2>`;;
//     } else if (dado >= 90) {
//         quantidade_disco.innerHTML = `<h2><span style="color: red;">${dado}%</span></h2>`;
//     } else {
//         quantidade_disco.innerHTML = `<h2><span style="color: yellow;">${dado}%</span></h2>`;
//     }
   
//     return dado;
// }




// function loop_ram() {
//     var i = 0;
//     setInterval(function() {
//         const momento_atual_ram = new Date();
//         const valor_hora_ram = `${momento_atual_ram.toLocaleDateString()} ${momento_atual_ram.toLocaleTimeString()}`;
//         i++;
//         if (config_ram.data.datasets[0].data.length >= 8) {
//             config_ram.data.datasets[0].data.splice(0, 1);
//             config_ram.data.labels.splice(0, 1);
//         }
//         config_ram.data.labels.push(valor_hora_ram);
//         config_ram.data.datasets[0].data.push(gerarDadoRam());
//         window.myram.update();
//     }, 3000);
// }



function receber_leitura2(){
    fetch(`leituras/pegarmemoria`, {cache: 'no-store'}).then (function(response){ 
        if(response.ok) {
            response.json().then(registro => {
                console.log(registro);

				dados2.datasets[0].data = []
				dados2.labels = []
				dados2.datasets[0].data.push(parseFloat(registro[0][0].PorcentagemUsoMemoria)) //dataset é grafico
			  	dados2.datasets[0].data.push(parseFloat(registro[0][1].PorcentagemUsoMemoria))
				dados2.datasets[0].data.push(parseFloat(registro[0][2].PorcentagemUsoMemoria))


				  dado2s.labels.push(registro[0][0].DataHora); //label é legenda
				  dados2.labels.push(registro[0][1].DataHora);
				  dados2.labels.push(registro[0][2].DataHora);
                  dados2.labels.push(registro[0][3].Datahora);
				  plotarGrafico2(dados2);
               
            })
        } else{
            console.log('Erro receber leitura');
        }
    })
}

function plotarGrafico2(dados2) {
		

    // Comecar();

    var ctx = document.getElementById('graficoRAM').getContext('2d');
  
   window.graficoLinha = new Chart.Line(ctx, {
       data: dados2, options: configurar2()
  });

    setTimeout(receber_leitura, 5000)

}


window.onload = plotarGrafico2;