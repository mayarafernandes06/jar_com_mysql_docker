'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Maquina = sequelize.define('Maquina',{
		idmaquina: {
			field: 'idMaquina',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},		
		nomem: {
			field: 'Nome_maquina',
			type: DataTypes.STRING,
			allowNull: false
		},
		fkrestaurante: {
			field: 'fk_restaurante',
			type: DataTypes.INTEGER,
			allowNull: false
		},
	}, 
	{
		tableName: 'Maquina', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Maquina;
};
