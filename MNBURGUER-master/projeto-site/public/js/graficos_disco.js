function configurar3(){
    var config_disco = {
        type: 'line',
        data: {
        },
        options: {
            responsive: true,
            title: {
                display: true,
                text: 'Gráfico do histórico do disco'
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
                        labelString: 'Porcentual de uso do DISCO'
                    }
                }]
            }
        }
    };
    return config_disco;
}


var dados3 = {labels: [],
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


    function receber_leitura3(){
        fetch(`leituras/pegardisco`, {cache: 'no-store'}).then (function(response){ 
            if(response.ok) {
                response.json().then(registro => {
                    console.log(registro);
    
                    dados3.datasets[0].data = []
                    dados3.labels = []
                    dados3.datasets[0].data.push(parseFloat(registro[0][0].PorcentagemUsoMemoria)) //dataset é grafico
                    dados3.datasets[0].data.push(parseFloat(registro[0][1].PorcentagemUsoMemoria))
                    dados3.datasets[0].data.push(parseFloat(registro[0][2].PorcentagemUsoMemoria))
    
    
                      dados3.labels.push(registro[0][0].DataHora); //label é legenda
                      dados3.labels.push(registro[0][1].DataHora);
                      dados3.labels.push(registro[0][2].DataHora);
                      dados3.labels.push(registro[0][3].Datahora);
                      plotarGrafico(dados3);
                   
                })
            } else{
                console.log('Erro receber leitura');
            }
        })
    }
    
    function plotarGrafico3(dados3) {
            
    
        // Comecar();
    
        var ctx = document.getElementById('graficoDISCO').getContext('2d');
      
       window.graficoLinha = new Chart.Line(ctx, {
           data: dados3, options: configurar()
      });
    
        setTimeout(receber_leitura, 5000)
    
    }
    
    
    window.onload = plotarGrafico;