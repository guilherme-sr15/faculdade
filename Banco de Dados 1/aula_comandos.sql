create database aula_comandos;

use aula_comandos;

create table pessoa(
	idPessoa int(5)  not null,
	nome varchar(20) not null,
	telefone varchar(11),
	idade int(2) check (idade > 0 AND idade < 50), 
	data_nasc date,
	primary key(idPessoa)
);

insert into pessoa(idPessoa, nome, telefone, idade, data_nasc) values (1, 'Guilherme', '996121786', 21, '1996-03-15');

alter table pessoa add cpf int not null unique;

insert into pessoa(idPessoa, nome, telefone, idade, data_nasc, cpf) values (2, 'Guilherme', '996121786', 21, '1996-03-15', 793689);

insert into pessoa(idPessoa, nome, data_nasc, cpf) values (3, 'Guilherme', '1996-03-15', 793682);

insert into pessoa(idPessoa, nome, idade, data_nasc, cpf) values (4, 'Guilherme', 80, '1996-03-15', 293682);

update pessoa set telefone = 000;

update pessoa set telefone = 123 where idade > 15;

update pessoa set telefone = 996121786 where idade > 15 AND nome = 'Guilherme';

create table dep(
	idDep int not null,
	nome varchar(20) not null,
	pessoa int,
	primary key (idDep),
	foreign key (pessoa) references pessoa(idPessoa)
);

insert into dep (idDep, nome, pessoa) values (1, 'Teste', 1);

delete from dep where idDep = 8;

delete fom dep;

delete from pessoa where ((telefone is not null) OR (telefone = '111'));