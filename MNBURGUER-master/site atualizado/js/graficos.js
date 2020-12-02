var config_cpu  = {
    type: 'line',
    data: {
        labels: [],
        datasets: [{
            label: 'CPU',
            backgroundColor: '#c11cff',
            borderColor: '#c11cff',
            data: [],
            fill: false,
        },
        ]
    },
    options: {
        responsive: true,
        title: {
            display: true,
            text: 'Gráfico de histórico de CPU'
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

var config_ram = {
    type: 'line',
    data: {
        labels: [],
        datasets: [{
            label: 'Memória RAM',
            backgroundColor: '#ff6781',
            borderColor: '#ff6781',
            data: [],
            fill: false,
        },
        ]
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

var config_disco  = {
    type: 'line',
    data: {
        labels: [],
        datasets: [{
            label: 'Disco',
            backgroundColor: '#5163ff',
            borderColor: '#5163ff',
            data: [],
            fill: false,
        },
        ]
    },
    options: {
        responsive: true,
        title: {
            display: true,
            text: 'Gráfico do histórico de Disco'
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
                    labelString: 'Porcentual de uso de Disco'
                }
            }]
        }
    }
};

window.onload = function() {
    var ctx = document.getElementById('graficoCPU').getContext('2d');
    var ctx2 = document.getElementById('graficoRAM').getContext('2d');
    var ctx3 = document.getElementById('graficoDISCO').getContext('2d');
    window.mycpu = new Chart(ctx, config_cpu);
    window.myram = new Chart(ctx2, config_ram);
    window.mydisco = new Chart(ctx3, config_disco);
    loop_cpu();
    loop_ram();
    loop_disco();
};

function gerarDadoCpu() {
    var dado = parseInt(Math.random() * 101);

    quantidade_cpu.innerHTML = `${dado}%`;
    if (dado <= 45) {
        resultado_cpu.innerHTML = `<span style="color: green;"><b>Oba, sua CPU está ótima!</b></span>`;;
    } else if (dado >= 90) {
        resultado_cpu.innerHTML = `<span style="color: red;"><b>Cuidado, sua CPU está sobrecarregada!</b></span>`;
    } else {
        resultado_cpu.innerHTML = `<span style="color: yellow;"><b>Sua CPU está boa!</b></span>`;
    }
    return dado;
}

function gerarDadoRam() {
    var dado = parseInt(Math.random() * 101);
    
    quantidade_ram.innerHTML = `${dado}%`;
    if (dado <= 45) {
        resultado_ram.innerHTML = `<span style="color: green;"><b>Oba, sua RAM está ótima!</b></span>`;;
    } else if (dado >= 90) {
        resultado_ram.innerHTML = `<span style="color: red;"><b>Cuidado, sua RAM está sobrecarregada!</b></span>`;
    } else {
        resultado_ram.innerHTML = `<span style="color: yellow;"><b>Sua RAM está boa!</b></span>`;
    }
   
    return dado;

}

function gerarDadoDisco() {
    var dado = parseInt(Math.random() * 101);

    quantidade_disco.innerHTML = `${dado}%`;
    if (dado <= 45) {
        resultado_disco.innerHTML = `<span style="color: green;"><b>Oba, seu Disco está ótimo!</b></span>`;;
    } else if (dado >= 90) {
        resultado_disco.innerHTML = `<span style="color: red;"><b>Cuidado, seu Disco está sobrecarregado!</b></span>`;
    } else {
        resultado_disco.innerHTML = `<span style="color: yellow;"><b>Seu Disco está bom!</b></span>`;
    }
   
    return dado;
}


function loop_cpu() {
    var i = 0;
    setInterval(function() {
        const momento_atual_cpu = new Date();
        const valor_hora_cpu = `${momento_atual_cpu.toLocaleDateString()} ${momento_atual_cpu.toLocaleTimeString()}`;
        i++;
        if (config_cpu.data.datasets[0].data.length >= 8) {
            config_cpu.data.datasets[0].data.splice(0, 1);
            config_cpu.data.labels.splice(0, 1);
        }
        config_cpu.data.labels.push(valor_hora_cpu);
        config_cpu.data.datasets[0].data.push(gerarDadoCpu());
        window.mycpu.update();
    }, 3000);
};

function loop_ram() {
    var i = 0;
    setInterval(function() {
        const momento_atual_ram = new Date();
        const valor_hora_ram = `${momento_atual_ram.toLocaleDateString()} ${momento_atual_ram.toLocaleTimeString()}`;
        i++;
        if (config_ram.data.datasets[0].data.length >= 8) {
            config_ram.data.datasets[0].data.splice(0, 1);
            config_ram.data.labels.splice(0, 1);
        }
        config_ram.data.labels.push(valor_hora_ram);
        config_ram.data.datasets[0].data.push(gerarDadoRam());
        window.myram.update();
    }, 3000);
}

function loop_disco() {
    var i = 0;
    setInterval(function() {
        const momento_atual_disco = new Date();
        const valor_hora_disco = `${momento_atual_disco.toLocaleDateString()} ${momento_atual_disco.toLocaleTimeString()}`;
        i++;
        if (config_disco.data.datasets[0].data.length >= 8) {
            config_disco.data.datasets[0].data.splice(0, 1);
            config_disco.data.labels.splice(0, 1);
        }
        config_disco.data.labels.push(valor_hora_disco);
        config_disco.data.datasets[0].data.push(gerarDadoDisco());
        window.mydisco.update();
    }, 3000);
};
