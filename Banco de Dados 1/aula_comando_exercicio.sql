create database exer_comandos;
 
use exer_comandos;

create table ambulatorio(
	nro_amb int not null primary key,
	andar int not null,
	capacidade int not null
);

create table medicos(
	cod_med int not null primary key,
	nome varchar(30) not null, 
	idade int(3) not null,
	especialidade varchar(30) not null,
	cpf varchar(12) not null unique,
	cidade varchar(30) not null,
	nro_amb int,
	foreign key (nro_amb) references ambulatorio(nro_amb)
);

create table paciente(
	cod_pac int not null primary key,
	nome varchar(30) not null, 
	idade int not null, 
	cidade varchar(30) not null, 
	cpf varchar(12) not null unique,
	doenca varchar(30) not null
);

create table funcionarios(
	cod_func int not null primary key,
	nome varchar(30) not null,
	idade int not null, 
	cidade varchar(30) not null,
	salario float not null, 
	cpf varchar(12) not null unique
);

create table consultas(
	cod_med int not null,
	cod_pac int not null,
	data Date not null, 
	hora Time not null,
	primary key (data, hora),
	foreign key (cod_med) references medicos(cod_med),
	foreign key (cod_pac) references paciente(cod_pac)
);

insert into ambulatorio(nro_amb, andar, capacidade) values (1, 1, 30);
insert into ambulatorio(nro_amb, andar, capacidade) values (2, 1, 50);
insert into ambulatorio(nro_amb, andar, capacidade) values (3, 2, 40);
insert into ambulatorio(nro_amb, andar, capacidade) values (4, 2, 25);
insert into ambulatorio(nro_amb, andar, capacidade) values (5, 2, 55);

insert into medicos(cod_med, nome, idade, especialidade, cpf, cidade, nro_amb) values (1, 'Joao', 40, 'ortopedia', '1000100000', 'Florioanopolis', 1);
insert into medicos(cod_med, nome, idade, especialidade, cpf, cidade, nro_amb) values (2, 'Maria', 42, 'traumatologia', '1000110000', 'Blumenau', 2);
insert into medicos(cod_med, nome, idade, especialidade, cpf, cidade, nro_amb) values (3, 'Pedro', 51, 'pediatria', '1100010000', 'Sao Jose', 2);
insert into medicos(cod_med, nome, idade, especialidade, cpf, cidade) values (4, 'Carlos', 28, 'ortopedia', '1100011000', 'Joinville');
insert into medicos(cod_med, nome, idade, especialidade, cpf, cidade, nro_amb) values (5, 'Marcia', 33, 'neurologia', '1100011100', 'Biguacu', 3);

insert into paciente(cod_pac, nome, idade, cidade, cpf, doenca) values (1, 'Ana', 20, 'Florioanopolis', '20000200000', 'gripe');
insert into paciente(cod_pac, nome, idade, cidade, cpf, doenca) values (2, 'Paulo', 24, 'Palhoca', '20000220000', 'fratura');
insert into paciente(cod_pac, nome, idade, cidade, cpf, doenca) values (3, 'Lucia', 30, 'Biguacu', '22000200000', 'tendinite');
insert into paciente(cod_pac, nome, idade, cidade, cpf, doenca) values (4, 'Carlos', 28, 'Joinville', '11000110000', 'sarampo');

insert into funcionarios (cod_func, nome, idade, cidade, salario, cpf) values (1, 'Rita', 32, 'Sao Jose', 1200, '2000100000');
insert into funcionarios (cod_func, nome, idade, cidade, salario, cpf) values (2, 'Maria', 55, 'Palhoca', 1220, '3000110000');
insert into funcionarios (cod_func, nome, idade, cidade, salario, cpf) values (3, 'Caio', 45, 'Florioanopolis', 1100, '4100100000');
insert into funcionarios (cod_func, nome, idade, cidade, salario, cpf) values (4, 'Carlos', 44, 'Florioanopolis', 1200, '5100100000');
insert into funcionarios (cod_func, nome, idade, cidade, salario, cpf) values (5, 'Paula', 33, 'Florioanopolis', 2500, '6100100000');

insert into consultas ( cod_med, cod_pac, data, hora) values (1, 1, '2006/06/12', '14:00:00');
insert into consultas ( cod_med, cod_pac, data, hora) values (1, 4, '2006/06/13', '10:00:00');
insert into consultas ( cod_med, cod_pac, data, hora) values (2, 1, '2006/06/13', '09:00:00');
insert into consultas ( cod_med, cod_pac, data, hora) values (2, 2, '2006/06/13', '11:00:00');
insert into consultas ( cod_med, cod_pac, data, hora) values (2, 3, '2006/06/14', '14:00:00');
insert into consultas ( cod_med, cod_pac, data, hora) values (2, 4, '2006/06/14', '17:00:00');
insert into consultas ( cod_med, cod_pac, data, hora) values (3, 1, '2006/06/19', '18:00:00');
insert into consultas ( cod_med, cod_pac, data, hora) values (3, 3, '2006/06/12', '10:00:00');
insert into consultas ( cod_med, cod_pac, data, hora) values (3, 4, '2006/06/19', '13:00:00');
insert into consultas ( cod_med, cod_pac, data, hora) values (4, 4, '2006/06/20', '13:00:00');
insert into consultas ( cod_med, cod_pac, data, hora) values (4, 4, '2006/06/22', '19:30:00');

