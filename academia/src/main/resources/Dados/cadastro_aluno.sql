CREATE TABLE cadastro_aluno (
    id              SERIAL PRIMARY KEY,
    nome            VARCHAR(100) NOT NULL,
    cpf             VARCHAR(14)  NOT NULL UNIQUE,
    email           VARCHAR(100) NOT NULL UNIQUE,
    telefone        VARCHAR(20),
    data_nascimento DATE,
    endereco        VARCHAR(200),
    data_cadastro   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);