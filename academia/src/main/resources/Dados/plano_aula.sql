CREATE TABLE plano_aula (
    id            SERIAL PRIMARY KEY,
    nome_plano    VARCHAR(100) NOT NULL,
    descricao     TEXT,
    duracao_meses INT NOT NULL,
    valor         DECIMAL(10,2) NOT NULL,
    modalidade    VARCHAR(50),
    data_criacao  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);