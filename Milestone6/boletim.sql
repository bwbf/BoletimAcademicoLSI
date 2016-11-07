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
    CONSTRAINT disciplina_pk PRIMARY KEY(id_displina)
)

CREATE TABLE NOTAS(
    id_disciplina int,
    id_aluno int,
    nota_um decimal,
    sub_um decimal,
    nota_dois decimal,
    sub_dois decimal,
    prova_final decimal,
    CONSTRAINT disciplina_fk FOREIGN KEY(id_disciplina) REFERENCES disciplina(id_disciplina),
    CONSTRAINT aluno_fk FOREIGN KEY(id_aluno) REFERENCES aluno(id_aluno)
);



create table anotacoes(
    id_anotacoes serial,
    id_aluno int,
    descricao varchar(500),
    titulo varchar(100),
    date data_anotacao,
    constraint anotacao_pk PRIMARY KEY(id_anotacao),
    constraint anotacao_fk FOREIGN KEY(id_aluno) REFERENCES alunos(id_aluno)
   
)

create table calendario(
    id_aluno int,
    id_disciplina int,
    date data_avaliacao,
    constraint calendario_fk FOREIGN KEY(id_aluno) REFERENCES alunos(id_aluno),
    constraint disciplina_fk FOREIGN KEY(id_disciplina) REFERENCES disciplinas(id_disciplina)
    
)