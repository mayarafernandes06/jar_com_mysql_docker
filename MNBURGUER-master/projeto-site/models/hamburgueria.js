'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Hamburgueria = sequelize.define('Hamburgueria',{
		idrestaurante: {
			field: 'idRestaurante',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},		
		nomeh: {
			field: 'Nome_Restaurante',
			type: DataTypes.STRING,
			allowNull: false
		},
		cnpjh: {
			field: 'CNPJ',
			type: DataTypes.STRING,
			allowNull: false
		},
		ruah: {
			field: 'Rua_Restaurante',
			type: DataTypes.STRING,
			allowNull: false
		},
		ceph: {
			field: 'Cep_Restaurante',
			type: DataTypes.STRING,
			allowNull: false
        },
        nuenderecoh: {
			field: 'Numero_Endereco',
			type: DataTypes.STRING,
			allowNull: false
		},
		fkcliente: {
			field: 'fk_Cliente',
			type: DataTypes.INTEGER,
			allowNull: false
		},
	}, 
	{
		tableName: 'Restaurante', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Hamburgueria;
};
