create database hotel;

use hotel;

create table itens_de_consumo
(
	coditens_de_consumo int(10) not null auto_increment,
	descricao varchar(255) not null,
	preco float(10,2) not null,
	codigoItem smallint not null,
	primary key(coditens_de_consumo)
);

create table funcionario
(
	codFuncionario int(10) not null auto_increment,
	estado varchar(30),
	nome varchar(30) not null,
	endereco varchar(30),
	dataNascimento date,
	telefone varchar(10),
	cidade varchar(30),
	primary key(codFuncionario)
);

create table tipo_acomodacao
(
	codtipo_acomodacao int(10) not null auto_increment,
	descricao varchar(255) not null,
	valorDiaria float(10,2) not null,
	nomeDoTipo varchar(30) not null,
	primary key (codtipo_acomodacao)
);

create table hospede
(
	codHospede int(10) not null auto_increment,
	nome varchar(30) not null,
	endereco varchar(30),
	pais varchar(20),
	dataNascimento date,
	email varchar(30) not null,
	nomePai varchar(30),
	nomeMae varchar(30),
	estado varchar(30),
	telefone varchar(10),
	cidade varchar(30),
	documento int(11) not null UNIQUE,
	primary key(codHospede)
);

create table acomodacao
(
	nroAcomodacao int(5) not null,
	andar numeric(3) not null,
	nroAdultos smallint,
	nroCriancas smallint,
	codtipo_acomodacao int(10) not null,
	primary key(nroAcomodacao),
	foreign key(codtipo_acomodacao) references tipo_acomodacao(codtipo_acomodacao)
);

create table reserva
(
	codHospede int(10) not null,
	codReserva int(10) not null auto_increment,
	nroAcomodacao int(5) not null,
	dataChegada date,
	dataSaida date,
	horaChega time not null,
	horaSaida time not null,
	primary key(codReserva),
	foreign key(codHospede) references hospede(codHospede),
	foreign key(nroAcomodacao) references acomodacao(nroAcomodacao)
);

create table estadia
(
	codEstadia int(10) not null auto_increment,
	dataEntrada date not null,
	dataSaida date not null,
	horaEntrada time not null,
	horaSaida time not null,
	nroAcompanhantes smallint not null,
	codReserva int(10) not null,
	valorTotal float(10,2) not null,
	formaPagamento varchar(20) not null,
	primary key(codEstadia),
	foreign key(codReserva) references reserva(codReserva)
);

create table acompanhantes
(
	cpf int(11) not null UNIQUE,
	nome varchar(30) not null,
	idade smallint,
	codEstadia int(10) not null,
	primary key(cpf),
	foreign key(codEstadia) references estadia(codEstadia)
);

create table quitacao_fatura
(
	codFatura int(10) not null auto_increment,
	codEstadia int(10) not null,
	valorTotalPago float(10,2) not null,
	juros float(10,2),
	desconto float(10,2),
	dataVencimento date not null,
	multa float(10,2),
	nroFatura int(10) not null,
	dataPagamento date not null,
	primary key(codFatura,codEstadia),
	foreign key(codEstadia) references estadia(codEstadia)
);

create table consumo
(
	codConsumo int(10) not null auto_increment,
	codEstadia int(10) not null,
	codigoItens int(10) not null,
	valorUnitario float(10,2) not null,
	qtdConsumida int(10) not null,
	dataConsumo date,
	nroAcomodacao int(5) not null,
	codFuncionario int(10) not null,
	primary key(codConsumo,codEstadia),
	foreign key(codEstadia) references estadia(codEstadia),
	foreign key(codFuncionario) references funcionario(codFuncionario),
	foreign key(nroAcomodacao) references acomodacao(nroAcomodacao)
);

create table consumo_mais_itens
(
	codConsumo int(10) not null,
	coditens_de_consumo int(10) not null,
	primary key(codConsumo,coditens_de_consumo),
	foreign key(codConsumo) references consumo(codConsumo),
	foreign key(coditens_de_consumo) references itens_de_consumo(coditens_de_consumo)
);