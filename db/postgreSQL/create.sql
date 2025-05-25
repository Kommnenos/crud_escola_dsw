-- Tipos
CREATE TYPE PERIODOS AS ENUM ('MATUTINO', 'VESPERTINO', 'NOTURNO', 'INTEGRAL');

-- Tabelas
CREATE TABLE Classe(id SERIAL PRIMARY KEY,
                    nome VARCHAR(120) NOT NULL,
                    sala_num INT NOT NULL,
                    predio CHAR(1) NOT NULL,
                    periodo PERIODOS NOT NULL,
                    em_curso BOOL NOT NULL DEFAULT FALSE,
                    serie INT CHECK(serie >= 1 AND serie <= 12) NOT NULL,
                    ano INT NOT NULL
                   );

CREATE TABLE Aluno(id SERIAL PRIMARY KEY,
                   nome VARCHAR(40) NOT NULL,
                   sobrenome VARCHAR(40) NOT NULL,
                   pcd BOOL NOT NULL DEFAULT FALSE,
                   ano_nasc INT NOT NULL CHECK(ano_nasc BETWEEN 1900 AND EXTRACT(YEAR FROM CURRENT_DATE)),
                   classe_id INT,
                   cursando BOOL NOT NULL DEFAULT TRUE,
                   FOREIGN KEY (classe_id) references Classe(id) ON DELETE SET NULL
                  );

-- Indices para foreign tables
CREATE INDEX idx_aluno_classe_id ON Aluno(classe_id);


-- Inserir 2 classes na tabela Classe
INSERT INTO Classe (nome, sala_num, predio, periodo, em_curso, serie, ano)
VALUES ('Sala Professora Maria Borges',101, 'A', 'MATUTINO', TRUE, 5, 2024),
       ('Laboratório Beato Carlos da Áustria',202, 'B', 'VESPERTINO', FALSE, 8, 2023);

-- Inserir 10 alunos na tabela Aluno
INSERT INTO Aluno (nome, sobrenome, pcd, ano_nasc, classe_id, cursando)
VALUES ('João', 'Silva', FALSE, 2010, 1, TRUE),
       ('Maria', 'Oliveira', TRUE, 2009, 1, TRUE),
       ('Lucas', 'Santos', FALSE, 2011, 1, TRUE),
       ('Ana', 'Souza', FALSE, 2010, 1, TRUE),
       ('Pedro', 'Lima', TRUE, 2009, 1, TRUE),
       ('Carla', 'Ferreira', FALSE, 2008, 2, FALSE),
       ('Rafael', 'Pereira', FALSE, 2008, 2, FALSE),
       ('Fernanda', 'Costa', TRUE, 2007, 2, FALSE),
       ('Roberto', 'Mendes', FALSE, 2008, 2, FALSE),
       ('Juliana', 'Barbosa', FALSE, 2007, 2, FALSE);