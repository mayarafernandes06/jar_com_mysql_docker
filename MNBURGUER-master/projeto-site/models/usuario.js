	'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Usuario = sequelize.define('Usuario',{
		id: {
			field: 'idCliente',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},		
		nome: {
			field: 'Nome_Cliente',
			type: DataTypes.STRING,
			allowNull: false
		},
		telefone: {
			field: 'Celular_Cliente',
			type: DataTypes.STRING,
			allowNull: false
		},
		login: {
			field: 'Email_Cliente',
			type: DataTypes.STRING,
			allowNull: false
		},
		senha: {
			field: 'Senha_Cliente',
			type: DataTypes.STRING,
			allowNull: false
		}
	}, 
	{
		tableName: 'Cliente', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Usuario;
};
