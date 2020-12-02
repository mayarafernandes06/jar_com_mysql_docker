'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Leitura = sequelize.define('Leitura',{	
		id: {
			field: 'idLeitura',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},	
		pcpu: {
			field: 'PorcentagemUsoCpu',
			type: DataTypes.INTEGER,
			allowNull: false
		},
		pmemoria: {
			field: 'PorcentagemUsoMemoria',
			type: DataTypes.INTEGER,
			allowNull: false
		},
		pdisco: {
			field: 'PorcentagemUsoDisco',
			type: DataTypes.INTEGER,
			allowNull: false
		},
		datahora: {
			field: 'Datahora',
			type: DataTypes.DATE, // NÃO existe DATETIME. O tipo DATE aqui já tem data e hora
			allowNull: false
		},
		fkmaquina: {
			field: 'fk_Maquina',
			type: DataTypes.INTEGER,
			allowNull: false
		},
		momento_grafico: {
			type: DataTypes.VIRTUAL, // campo 'falso' (não existe na tabela). Deverá ser preenchido 'manualmente' no select
			allowNull: true
		}
	}, 
	{
		tableName: 'Leitura', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Leitura;
};
