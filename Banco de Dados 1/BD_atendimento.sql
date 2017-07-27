
create database atendimento;
use atendimento;

create table paciente(
	cpf int not null,
	nome varchar(30) not null,
	dataN date,
	idade int,
	primary key(cpf)
);

insert into paciente (cpf, nome, dataN, idade) values( 123, "João Carlos", "1999-01/10", 14);
insert into paciente (cpf, nome, dataN, idade) values( 456, "Maria Clara", "2000-02-20", 13);
insert into paciente (cpf, nome, dataN, idade) values( 789, "Ana Flávia", "2000-02-20", 20);

create table medico(
crm int not null,
nome varchar(30) not null,
especialidade varchar(30),
dataN date,
primary key(crm)
);

insert into medico values(555, "Mauro", "ortopedista", "1980-10-10");
insert into medico values(777, "Eduardo", "cardiologista", "1988-03-03");
insert into medico values(999, "Ronaldo", "ortopedista", "1970-02-20");

create table consulta(
	paciente int not null,
	medico int not null,
	data date not null,
	horario time not null,
	local varchar(30),
	primary key(paciente, medico, data, horario),
	foreign key(paciente) references paciente(cpf),
	foreign key(medico) references medico(crm)
);

insert into consulta values(123, 555, "2012-06-20", "13:30", "Sala A");
insert into consulta values(123, 777, "2012-06-22", "16:00", "Sala A");
insert into consulta values(789, 555, "2012-06-20", "17:30", "Sala B");

create table medicamento(
	codigo int not null,
	nome varchar(30) not null,
	ativo varchar(30),
	validade date,
	primary key(codigo)
);

insert into medicamento values(1, "descon Gotas", "Paracetamol", "2016-10-10");
insert into medicamento values(2, "Cefalium", "Paracetamol", "2012-03-05");
insert into medicamento values(3, "Asmapen", "Aminofilina", "2014-12-01");

create table receita(
	medicamento int not null,
	paciente int not null,
	medico int not null,
	data date not null,
	posologia varchar(100),
	primary key(medicamento, paciente, medico, data),
	foreign key(medicamento) references medicamento(codigo),
	foreign key(paciente) references paciente(cpf),
	foreign key(medico) references medico(crm)
);

insert into receita values(1, 123, 555, "2012-06-20", "20 gotas 3 X ao dia");
insert into receita values(3, 123, 555, "2012-06-20", "1 comprimido a cada 12 horas");
insert into receita values(1, 789, 555, "2012-06-20", "10 gotas pela manhã");

alter table medico add celular varchar(15) not null default "000";

alter table receita change posologia descricao varchar(90);

update paciente set idade = 16 where nome = "Ana Flávia";

alter table medico drop dataN;

#drop table medico;

select nome, especialidade from medico order by especialidade;

select idade from paciente;

select nome from paciente where idade >= 18;

select avg(idade) from paciente where cpf in (select distinct(paciente) from consulta) );

select nome from medico where crm in select distinct (medico) from consulta);

select nome from medico where especialidade LIKE 'O%';

select count(crm) from medico where especialidade = "cardiologista";

select count(paciente) from receita where medicamento = 1;

select nome from medicamento where codigo IN (select medicamento from receita where medico = 555);

select nome, ativo from medicamento where validade = (select MAX(validade) from medicamento);

select nome from medico where crm IN (select medico from consulta where local = "Sala A");

select count(medico) from consulta where horario < "12:00";

select concat(nome, " nasceu no mês: ", month(dataN)) from paciente;

select nome from paciente where cpf IN (select distinct paciente from receita where medicamento IN (select codigo from medicamento where ativo = "paracetamol"));

select * from consulta where local = "Sala A";

select posologia from receita where medico = 555 and data = "2012-06-20";

select concat(nome, " ", ativo) AS REMEDIO from medicamento;

select nome from medicamento where codigo IN (select distinct medicamento from receita) order by nome;