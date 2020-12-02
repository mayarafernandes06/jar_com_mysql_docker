function configurar(){
    var config_cpu = {
        type: 'line',
        data: {
        },
        options: {
            responsive: true,
            title: {
                display: true,
                text: 'Gráfico do histórico da CPU'
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
                        labelString: 'Porcentual de uso de CPU'
                    }
                }]
            }
        }
    };
    return config_cpu;
}


var dados = {labels: [],
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


    function receber_leitura(){
        fetch(`leituras/pegarmemoria`, {cache: 'no-store'}).then (function(response){ 
            if(response.ok) {
                response.json().then(registro => {
                    console.log(registro);
    
                    dados.datasets[0].data = []
                    dados.labels = []
                    dados.datasets[0].data.push(parseFloat(registro[0][0].PorcentagemUsoMemoria)) //dataset é grafico
                    dados.datasets[0].data.push(parseFloat(registro[0][1].PorcentagemUsoMemoria))
                    dados.datasets[0].data.push(parseFloat(registro[0][2].PorcentagemUsoMemoria))
    
    
                      dados.labels.push(registro[0][0].DataHora); //label é legenda
                      dados.labels.push(registro[0][1].DataHora);
                      dados.labels.push(registro[0][2].DataHora);
                      dados.labels.push(registro[0][3].Datahora);
                      plotarGrafico(dados);
                   
                })
            } else{
                console.log('Erro receber leitura');
            }
        })
    }
    
    function plotarGrafico(dados) {
            
    
        // Comecar();
    
        var ctx = document.getElementById('graficoCPU').getContext('2d');
      
       window.graficoLinha = new Chart.Line(ctx, {
           data: dados, options: configurar()
      });
    
        setTimeout(receber_leitura, 5000)
    
    }
    
    window.onload = function () {
	
        receber_leituras();
        receber_leituras2();
        receber_leituras3();
    }
    
    window.onload = plotarGrafico;