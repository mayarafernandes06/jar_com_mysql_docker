create database MNBurger;
use MNBurger;

create table cliente(
idCliente int primary key auto_increment,
Nome_Cliente varchar(50),
Celular_Cliente double,
Email_Cliente varchar(50),
Senha_Cliente char(10)
);

drop database MNBURGER;
create table Restaurante(
idRestaurante int primary key auto_increment,
Nome_Restaurante varchar(50),
CNPJ varchar(30),
Rua_Restaurante varchar(50),
Cep_Restaurante int,
Numero_Endereco int,
fk_Cliente int,
foreign key (fk_Cliente) references Cliente(idCliente)
);

create table Usuario(
idUsuario int primary key auto_increment,
Nome_Usuario varchar(40),
Cargo_Usuario varchar(30),
fk_Cliente int,
foreign key (fk_Cliente) references Cliente(idCliente),
fk_Restaurante int,
foreign key (fk_Restaurante) references Restaurante(idRestaurante)
);

create table Cadastro_Maquina(
idCadastro_maquina int primary key auto_increment,
Nome_Maquina varchar(50),
Hardware_pc varchar(60),
fk_Restaurante int,
foreign key (fk_Restaurante) references Restaurante(idRestaurante)
);

create table Componentes(
idComponentes int primary key auto_increment,
Nome_Componentes varchar(30),
Metrica varchar(30)
);

create table Config_software(
idConfig_software int primary key auto_increment,
fk_Cadastro_Maquina int,
foreign key (fk_Cadastro_Maquina) references Cadastro_Maquina(idCadastro_Maquina),
fk_Componentes int,
foreign key (fk_Componentes) references Componentes(idComponentes),
Alerta int
);

create table Leitura(

idLeitura int primary key auto_increment,
fk_Config_software int,
foreign key (fk_Config_software) references Config_software(idConfig_software),
DataHora datetime,
Valor_Leitura int
);

insert into cliente values
(null, 'Jóse Carlos', '11981726145', 'josecarlos@gmail.com', 'jose@1234'),
(null, 'Thiago Oliveira', '11976429875', 'thiagaooli@hotmail.com.br', 'thiagao#56'),
(null, 'Augusto carrera', '11963740174', 'augustinho@gmail.com', 'augusto%45'),
(null, 'Astolfo Lopes', '11963412845', 'astolfozinho@yahoo.com', 'astrufo@18');


insert into Restaurante values
(null, 'Burgao da docá', '16458713000133', 'Rua Euclides Ramos', '24813592', '13', '2'),
(null, 'PizBurguer', '89224373000150', 'Rua Miguel Barra', '59014590' ,'102', '1'),
(null, 'KrugMadero', '74757340000106', 'Rua Interlúdio', '04689115', '46', '4'),
(null, 'TitsBobs' ,'27236409000168', 'Rua Melvin Jones', '13321441','501', '3'); 

insert into usuario values
(null, 'Davi Souza', 'Gerente', '2', '1'),
(null, 'Fernanda caramico', 'Gerente', '1', '2'),
(null, 'Carlos da silva', 'Gerente', '4', '3'),
(null, 'Carol marleni', 'Gerente', '3', '4');

insert into cadastro_maquina values
(null, 'Tablet garçom 1', 'Qualcomm APQ8026 @ 1,2GHz (Quad Core), 2GB Ram', '1'),
(null, 'Tablet garçom 2', 'Qualcomm APQ8026 @ 1,2GHz (Quad Core), 2GB Ram', '1'),
(null, 'Caixa 1', 'Intel(R) Core(TM) i5-2450M CPU @ 2.50GHz, 8GB Ram', '2'),
(null, 'Caixa 2', 'Intel(R) Core(TM) i5-2450M CPU @ 2.50GHz, 8GB Ram', '2'),
(null, 'caixa 1', 'Intel(R) Core(TM) i5-2450M CPU @ 2.50GHz, 8GB Ram', '3'),
(null, 'Tablet 1', 'Qualcomm APQ8026 @ 1,2GHz (Quad Core), 2GB Ram', '3'),
(null, 'caixa 4', 'Intel(R) Core(TM) i5-2450M CPU @ 2.50GHz, 8GB Ram', '4'),
(null, 'Tablet 3', 'Qualcomm APQ8026 @ 1,2GHz (Quad Core), 2GB Ram', '4');

insert into componentes values
(null, 'Computer_system', 'Ghz'),
(null, 'Processor', 'Ghz'),
(null, 'Memory', 'GB'),
(null, 'Cpu', 'Ghz'),
(null, 'Processes', 'Ghz'),
(null, 'Services', 'Ghz'),
(null, 'Sensors', 'Ghz'),
(null, 'Power sources', 'Ghz'),
(null, 'Disk', 'GB'),
(null, 'File system', 'Ghz'),
(null, 'Network interfaces', 'Ghz'),
(null, 'Network paraments', 'Ghz'),
(null, 'Ip statistic', 'Ghz'),
(null, 'Displays', 'Ghz'),
(null, 'Usb Devices', 'Ghz'),
(null, 'Sound cards', 'Ghz'),
(null, 'Hardware', ''),
(null, 'Graphics cards', 'Ghz');

insert into config_software values
(null, '1', '4', '70'),
(null, '1', '3', '60'),
(null, '1', '9', '60'),
(null, '4', '4', '80'),
(null, '4', '3', '70'),
(null, '4', '9', '60'),
(null, '6', '4', '80'),
(null, '6', '3', '61'),
(null, '6', '9', '70'),
(null, '8', '4', '73'),
(null, '8', '3', '65'),
(null, '8', '9', '64');

insert into leitura values
(null, '1', '2020-05-23 16:41:05', '25'),
(null, '2', '2020-05-23 16:41:05', '52'),
(null, '3', '2020-05-23 16:41:05', '10'),
(null, '4', '2020-05-23 18:04:30', '25'),
(null, '5', '2020-05-23 18:04:32', '66'),
(null, '6', '2020-05-23 18:04:32', '2'),
(null, '7', '2020-10-20 15:44:15', '46'),
(null, '8', '2020-10-20 15:44:20', '5'),
(null, '9', '2020-10-20 15:44:25', '10'),
(null, '10', '2020-10-20 15:44:45', '7'),
(null, '11', '2020-10-20 15:44:45', '46'),
(null, '12', '2020-10-20 15:44:45', '15');

select * from cliente;
select * from Restaurante;
select * from usuario;
select * from cadastro_maquina;
select * from componentes;
select * from config_software;
select * from leitura;

-- Mostra todos os conteudos das tabelas -> Cliente, Restaurante, Cadastro_maquina, Componentes, Config_software, leitura
select * from cliente, restaurante, cadastro_maquina, componentes, config_software, leitura where fk_cliente = idCliente and fk_Restaurante = idRestaurante
and fk_Cadastro_Maquina = idCadastro_maquina and fk_Componentes = idComponentes and fk_config_software = idConfig_software;

-- Mostra todos os conteudos das tabelas -> Cadastro_maquina, Componentes, Config_software, leitura
select * from cadastro_maquina as m, Componentes as c, config_software as s, leitura where fk_cadastro_maquina = m.idCadastro_Maquina
and fk_componentes = c.idComponentes and fk_config_software = s.idConfig_software; 

-- Mostra todos os conteudos das tabelas -> Cliente, Restaurante, Cadastro_maquina, Componentes, Config_software, leitura, mas só de um cliente específico
select * from cliente, restaurante, cadastro_maquina, componentes, config_software, leitura where Nome_Cliente like 'jóse Carlo' and fk_Cliente = idCliente and
fk_Restaurante = idRestaurante and fk_Cadastro_Maquina = idCadastro_maquina and fk_Componentes = idComponentes and fk_Config_software = idConfig_software;
