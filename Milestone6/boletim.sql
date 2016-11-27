CREATE TABLE alunos(
    id_aluno SERIAL,
    nome VARCHAR(100),
    matricula INT,
    senha VARCHAR(40),
    CONSTRAINT aluno_pk PRIMARY KEY(id_aluno)  
)

CREATE TABLE disciplinas(
    id_disciplina SERIAL,
    nome varchar(100),
    horario_dia VARCHAR(20),
    horario_hora VARCHAR(20),
    cargaHoraria int,
    CONSTRAINT disciplina_pk PRIMARY KEY(id_disciplina)
)

CREATE TABLE NOTAS(
    id_disciplina int,
    id_aluno int,
    nota_um decimal,
    sub_um decimal,
    nota_dois decimal,
    sub_dois decimal,
    prova_final decimal,
    CONSTRAINT disciplina_fk FOREIGN KEY(id_disciplina) REFERENCES disciplinas(id_disciplina),
    CONSTRAINT aluno_fk FOREIGN KEY(id_aluno) REFERENCES alunos(id_aluno)
)



create table anotacoes(
    id_anotacoes serial,
    id_aluno int,
    descricao varchar(500),
    titulo varchar(100),
    data_anotacao date,
    constraint anotacao_pk PRIMARY KEY(id_anotacoes),
    constraint anotacao_fk FOREIGN KEY(id_aluno) REFERENCES alunos(id_aluno)
   
)

create table calendario(
    id_aluno int,
    id_disciplina int,
    data_avaliacao date,
    constraint calendario_fk FOREIGN KEY(id_aluno) REFERENCES alunos(id_aluno),
    constraint disciplina_fk FOREIGN KEY(id_disciplina) REFERENCES disciplinas(id_disciplina)
    
)

INSERT INTO alunos values(1, 'Bruno', 1413080041, '1234');
INSERT INTO alunos values(2, 'Bruno', 1413080042, 'dias');
INSERT INTO disciplinas values(1, 'BD', 'Segunda', '18h30', 2);
INSERT INTO disciplinas values(2, 'SI', 'Terça', '18h30', 2);
INSERT INTO disciplinas values(3, 'LAB SI', 'Quarta', '18h30', 2);
INSERT INTO disciplinas values(4, 'LAB BD', 'Quinta', '18h30', 2);
INSERT INTO disciplinas values(5, 'MAP', 'Sexta', '18h30', 2);

INSERT INTO notas VALUES(1, 1, 0, 0, 0, 0, 0);
INSERT INTO notas VALUES(2, 1, 0, 0, 0, 0, 0);
INSERT INTO notas VALUES(3, 1, 0, 0, 0, 0, 0);
INSERT INTO notas VALUES(4, 1, 0, 0, 0, 0, 0);
INSERT INTO notas VALUES(5, 1, 0, 0, 0, 0, 0);
select * from alunos
