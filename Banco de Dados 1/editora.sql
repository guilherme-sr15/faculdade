create database editora;

use editora;

create table autor(
	codAutor int(5) not null auto_increment primary key,
	cpf int(9) not null unique, 
	rg int(9) not null,
	nome varchar(30) not null, 
	telefone int(9) not null,
	endereco varchar(30) not null, 
	cidade varchar(20) not null,
	uf varchar(2) not null
);

create table editora(
	codEd int not null primary key,
	cnpj int(9) not null unique, 
	nome varchar(20) not null, 
	telefone int (9) not null,
	endereco varchar(20) not null, 
	cidade varchar(20)  not null, 
	uf varchar(2) not null
);

create table livro(
	codLivro int(9) not null auto_increment primary key,
	isbn int(20) not null unique,
	titulo varchar(30) not null, 
	edicao smallint not null,
	ano smallint(4) not null, 
	codEd int,
	foreign key(codEd) references editora(codEd)
);

create table assunto(
	codAs int not null auto_increment primary key,
	descricao varchar(255) not null
);

create table autoria(
	codLivro int not null,
	codAutor int not null,
	primary key(codLivro, codAutor),
	foreign key (codLivro) references livro(codLivro),
	foreign key (codAutor) references autor(codAutor)
);

create table livroAssunto(
	codAs int not null,
	codLivro int not null,
	primary key(codAs, codLivro),
	foreign key (codAs) references assunto(codAs),
	foreign key (codLivro) references livro(codLivro)
);