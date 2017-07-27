/*Hello World!*/

/* SELECIONA PRIMEIRO NOME, �LTIMO NOME E NRO DE DEPARTAMENTO 
DA TABELA EMPREGADOS */
SELECT e.FIRST_NAME "Nome"
      ,e.LAST_NAME "Sobrenome"
      ,e.DEPARTMENT_ID "Departamento"
FROM EMPLOYEES e;

/* SELECIONA PRIMEIRO NOME, �LTIMO NOME PARA DEPARTMENT_ID = 90 */
SELECT e.FIRST_NAME "Nome"
      ,e.LAST_NAME "Sobrenome"
FROM EMPLOYEES e WHERE (e.DEPARTMENT_ID = 90);

/* SELECIONA PRIMEIRO NOME, �LTIMO NOME PARA DEPARTMENT_ID = 100, 110 E 120 */
SELECT e.FIRST_NAME "Nome"
      ,e.LAST_NAME "Sobrenome"
FROM EMPLOYEES e WHERE (e.DEPARTMENT_ID = 100) OR 
                       (e.DEPARTMENT_ID = 110) OR 
                       (e.DEPARTMENT_ID = 120);
                       
/* RESOLU��O 2*/ 
SELECT e.FIRST_NAME, 
       e.LAST_NAME
  FROM EMPLOYEES e     
  WHERE e.DEPARTMENT_ID IN (100, 110, 120);

/* SELECIONA SAL�RIOS SEM REPETI��ES */
SELECT DISTINCT e.SALARY FROM EMPLOYEES e;

/* SELECIONA SOBRENOME, SAL�RIO E SAL�RIO ANUAL */
SELECT e.LAST_NAME "Sobrenome"
      ,e.SALARY "Sal�rio Mensal"
      ,(e.SALARY*12) "Sal�rio Anual" /* SAL�RIO ANUAL � SAL�RIO MENSALx12 */
  FROM EMPLOYEES e;
  
/* NOME E SOBRENOME DOS EMPREGADOS QUE COMECEM COM "MA" */
SELECT e.FIRST_NAME
      ,e.LAST_NAME
  FROM EMPLOYEES e
  WHERE e.LAST_NAME LIKE 'Ma%';

/* NOME E SOBRENOME DOS EMPREGADOS QUE CONTENHAM A STRING 'ma' */
SELECT e.FIRST_NAME
      ,e.LAST_NAME 
  FROM EMPLOYEES e
  WHERE 
        e.LAST_NAME LIKE '%ma%' OR
        e.LAST_NAME LIKE 'Ma%';
        
/* NOME E SOBRENOME DOS EMPREGADOS COM SAL�RIO ENTRE 4000 E 10000 
DO DEPARTAMENTO 100 */
SELECT e.FIRST_NAME
      ,e.LAST_NAME
  FROM EMPLOYEES e
  WHERE (e.DEPARTMENT_ID = 100) AND
        (e.SALARY BETWEEN (4000) AND (10000)); /* (e.SALARY  >= 4000) AND (e.SALARY <= 10000) */
        
/* NOME, SOBRENOME E SAL�RIO ORDENADO ALFABETICAMENTE PELO SOBRENOME */
select e.FIRST_NAME
      ,e.LAST_NAME
      ,e.Salary
  from EMPLOYEES e 
  order by e.LAST_NAME;

/* NOME, SOBRENOME E SAL�RIO, ORDEM DECRESCENTE DE SAL�RIO E ORDENADO 
ALFABETICAMENTE PELO SOBRENOME */
select e.FIRST_NAME
      ,e.LAST_NAME
      ,e.Salary
  from EMPLOYEES e 
  order by e.SALARY desc
          ,e.LAST_NAME;
          
/* CONCATENA��ES */          
select last_name || ' possui a fun��o ' || job_id as 
       "Detalhes do Empregado" from Employees;

select D.department_name || ' possui o gerente ' 
       || E.first_name || ' ' || E.last_name AS 
       "Departamento e Gerente"
  from DEPARTMENTS D, EMPLOYEES E
  WHERE D.MANAGER_ID = E.EMPLOYEE_ID;
  
/* nome e sobrenome dos empregados e o departamento */
select e.first_name || ' ' ||
       e.last_name || ' trabalha no departamento ' ||
       d.department_name AS "Empregados e departamentos"
  from EMPLOYEES e, DEPARTMENTS d 
  where D.department_id = E.department_id order by e.first_name;

/* nome e sobrenome dos empregados e o departamento usando inner join */
select e.first_name || ' ' ||
       e.last_name || ' trabalha no departamento ' ||
       d.department_name AS "Empregados e departamentos"
  from EMPLOYEES e
  join DEPARTMENTS d 
  on e.department_id  = d.department_id 
  order by e.first_name;
  
/* nome e sobrenome dos empregados e o departamento e 
a cidade usando inner join */
select e.first_name "Nome"
      ,e.last_name "Sobrenome"
      ,d.department_name "Departamento"
      ,l.CITY "Cidade"
  from EMPLOYEES e
  join DEPARTMENTS d
  on e.department_id = d.department_id
  join LOCATIONS l
  on d.location_id = l.location_id
  order by e.first_name;
  
select e.first_name, e.last_name, m.last_name "Gerente"
from employees e, employees m
where e.manager_id = m.employee_id;

select e.first_name, e.last_name, m.last_name "Gerente"
from employees e join employees m
on e.manager_id = m.employee_id;

/* Nome e sobrenome dos funcion�rios com sal�rio maior que 5000 */
select e.first_name
      ,e.last_name
      ,e.salary
      from employees e
   where e.salary >= 5000;
      
/* Nome e sobrenome dos funcion�rios com sal�rio entre 8000 e 10000 */
select e.first_name
      ,e.last_name
      ,e.salary
   from employees e
   where e.salary between 8000 and 10000;
   
/* T�tulos dos cargos com sal�rio entre 4000 e 10000 */
select distinct j.job_title
   from jobs j, 
        employees e
   where e.salary between 4000 and 10000;
   
/* Sobrenome, telefone e email dos programmers */
select e.first_name
      ,e.last_name
      ,e.PHONE_NUMBER
      ,e.email
      ,j.job_title
   from employees e, jobs j
   where j.job_title = 'Programmer'
   and j.JOB_ID = e.JOB_ID;

/* Nome e sobrenome de  Sales e Marketing */
select e.first_name
      ,e.last_name
      ,d.DEPARTMENT_NAME
   from employees e, DEPARTMENTS d
   where e.DEPARTMENT_ID = d.DEPARTMENT_ID
   and d.department_name in ('Sales', 'Marketing');
         
/* nome e sobrenome do gerente e nome de cada dpto. */
select m.first_name
      ,m.last_name
      ,d.department_name
   from employees m, departments d
   where m.EMPLOYEE_ID = d.MANAGER_ID;
   
/* Nome do departamento e sua cidade */
select d.department_name
      ,l.city
   from departments d, locations l
   where l.location_id = d.location_id;
   
/* Nome do departamento e sua cidade e pa�s */
select d.department_name
      ,l.city
      ,c.country_name
   from departments d, locations l, COUNTRIES c
   where l.location_id = d.location_id
   and l.country_id = c.country_id;
     
/* Nome do departamento e sua cidade e pa�s que tenha "United" no nome */
select d.department_name
      ,l.city
      ,c.country_name
   from departments d, countries c, locations l
   where d.LOCATION_ID = l.location_id
   and l.country_id = c.country_id
   and c.country_name like '%United%';
   
/* Nome, sobrenome e email dos funcion�rios em dptos. na Europe */   
select e.first_name
      ,e.last_name
      ,e.email
   from employees e
   join departments d
   on d.DEPARTMENT_ID = e.DEPARTMENT_ID
   join LOCATIONS l
   on d.department_id = l.location_id
   join countries c
   on c.country_id = l.country_id
   join regions r
   on c.region_id = r.region_id
   where region_name like '%Europe%';
   
/*10 - resolu��o 2 */
select e.first_name
      ,e.last_name
      ,e.email
   from EMPLOYEES e
       ,DEPARTMENTS d
       ,LOCATIONS l
       ,COUNTRIES c
       ,REGIONS r
   where e.department_id = d.DEPARTMENT_ID
   and d.LOCATION_ID = l.LOCATION_ID
   and l.country_id = c.COUNTRY_ID
   and c.region_id =r.region_id
   and r.region_name = 'Europe';
   