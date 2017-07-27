create database empresa;

use empresa;

create table departamento(
	codDepartamento int(5) not null auto_increment, 
	nome varchar(30) not null,
	primary key (codDepartamento)
);

alter table departamneto change column nome nome varchar(50) not null;

alter table departamento add column telefone int (9);

alter table departamento drop column telefone;

create table cargo(
	codCargo int auto_increment primary key,
	nome varchar(30) not null,
	salario float(3.2) not null	
);

create table empregado(
	codEmpregado int(4) not null,
	nome varchar(50) not null,
	dataNasc date,
	departamento int(5),
	cargo int,
	primary key(codEmpregado),
	foreign key(departamento) references departamento(codDepartamento),
	foreign key(cargo) references cargo(codCargo)
);

alter table cargo add column horasTrabalho float not null;

alter table departamento add column ramal int not null;
