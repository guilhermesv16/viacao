-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

insert into ViacaoModel (nome) values('Xavante');
insert into ViacaoModel (nome) values('Real Maia');
insert into ViacaoModel (nome) values('Marly');

insert into PassageiroModel (nome, idade) values('Francisco', 28);
insert into PassageiroModel (nome, idade) values('Ricardo', 40);
insert into PassageiroModel (nome, idade) values('Roberta', 25);
insert into PassageiroModel (nome, idade) values('Claudio', 32);
insert into PassageiroModel (nome, idade) values('Lais', 24);

insert into PassagemModel (id, preco, origem, destino, assento, id_viacao) values(nextval('hibernate_sequence'), 144, 'Santana', 'Palmas', 19, 1); 
insert into PassagemModel (id, preco, origem, destino, assento, id_viacao) values(nextval('hibernate_sequence'), 230, 'Palmas', 'Goiania', 8, 2); 
insert into PassagemModel (id, preco, origem, destino, assento, id_viacao) values(nextval('hibernate_sequence'), 200, 'Belem', 'Teresina', 32, 2); 
insert into PassagemModel (id, preco, origem, destino, assento, id_viacao) values(nextval('hibernate_sequence'), 342, 'Brasilia', 'Sao Paulo', 1, 3); 

