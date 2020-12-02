var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Leitura = require('../models').Leitura;

//RAM
router.get('/pegarmemoria', function(req, res, next) {
	console.log('Recuperando dados de Memoria');
	
	
	let instrucaoSql = `select top 10 PorcentagemUsoMemoria, DataHora from [dbo].[Leitura]
	 Inner join Maquina ON [dbo].[Leitura].fk_Maquina = [dbo].[Maquina].idMaquina;`;
	
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql).then(resultado => {
    console.log(`leitura: ${resultado.length}`);

		if(resultado.length > 0) {
			res.json(resultado);
		} else if (resultado.length == 0) {
			res.status(403).send('Erro na leitura de dados de Memória Ram');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});




// Disco
router.get('/pegardisco', function(req, res, next) {
	console.log('Recuperando dados de Disco');
	
	
	let instrucaoSql = `select top 10 PorcentagemUsoDisco, DataHora from [dbo].[Leitura]
	 Inner join Maquina ON [dbo].[Leitura].fk_Maquina = [dbo].[Maquina].idMaquina;`;
	
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql).then(resultado => {
    console.log(`leitura: ${resultado.length}`);

		if(resultado.length > 0) {
			res.json(resultado);
		} else if (resultado.length == 0) {
			res.status(403).send('Erro na leitura de dados de Memória Ram');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});


// CPU
router.get('/pegarcpu', function(req, res, next) {
	console.log('Recuperando dados de CPU');
	
	
	let instrucaoSql = `select top 10 PorcentagemUsoCpu, DataHora from [dbo].[Leitura]
	 Inner join Maquina ON [dbo].[Leitura].fk_Maquina = [dbo].[Maquina].idMaquina;`;
	
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql).then(resultado => {
    console.log(`leitura: ${resultado.length}`);

		if(resultado.length > 0) {
			res.json(resultado);
		} else if (resultado.length == 0) {
			res.status(403).send('Erro na leitura de dados de CPU');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});








/* Recuperar as últimas N leituras */
router.get('/ultimas', function(req, res, next) {
	
	// quantas são as últimas leituras que quer? 8 está bom?
	const limite_linhas = 7;

	var idcaminhao = req.params.idcaminhao;

	console.log(`Recuperando as ultimas ${limite_linhas} leituras`);
	
	
	const instrucaoSql = `select top ${limite_linhas} 
						maquina, 
						componente, 
						datahora,
						FORMAT(momento,'HH:mm:ss') as momento_grafico,
						valorL
						from Leitura
						where idcaminhao = ${idcaminhao}
						order by id desc`;

	sequelize.query(instrucaoSql, {
		model: Leitura,
		mapToModel: true 
	  })
	  .then(resultado => {
			console.log(`Encontrados: ${resultado.length}`);
			res.json(resultado);
	  }).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
	  });
});


// tempo real (último valor de cada leitura)
/*router.get('/tempo-real', function (req, res, next) {
	
	console.log(`Recuperando a ultima leitura`);

	const instrucaoSql = `select top 4 temperatura, umidade, FORMAT(momento,'HH:mm:ss') as momento_grafico, idcaminhao from leitura order by id desc`;

	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
		.then(resultado => {
			res.json(resultado[0]);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});
  
});
*/

router.get('/tempo-real', function(req, res, next) {
	console.log('Recuperando caminhões');

	//var idcaminhao = req.body.idcaminhao; // depois de .body, use o nome (name) do campo em seu formulário de login
	var idcaminhao = req.params.idcaminhao;

	let instrucaoSql = `select top 1 temperatura, umidade, FORMAT(momento,'HH:mm:ss') as momento_grafico, idcaminhao from leitura where idcaminhao = ${idcaminhao} order by id desc`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
		.then(resultado => {
			res.json(resultado[0]);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});
});

// estatísticas (max, min, média, mediana, quartis etc)
router.get('/estatisticas', function (req, res, next) {
	
	console.log(`Recuperando as estatísticas atuais`);

	const instrucaoSql = `select 
							max(temperatura) as temp_maxima, 
							min(temperatura) as temp_minima, 
							avg(temperatura) as temp_media,
							max(umidade) as umidade_maxima, 
							min(umidade) as umidade_minima, 
							avg(umidade) as umidade_media 
						from leitura`;

	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
		.then(resultado => {
			res.json(resultado[0]);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});
  
});


module.exports = router;
