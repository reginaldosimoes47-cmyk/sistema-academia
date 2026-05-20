-- Criação da tabela pagamento para armazenar informações de pagamentos dos alunos
CREATE TABLE pagamento (
    -- Chave primária da tabela, identificador único do pagamento com incremento automático
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    -- Chave estrangeira que referencia o ID do aluno na tabela alunos
    aluno_id      BIGINT,
    -- Data em que o pagamento foi realizado
    data_pagamento DATE,
    -- Valor monetário do pagamento em formato decimal
    valor         DOUBLE,
    -- Status atual do pagamento (ex: pago, pendente, cancelado)
    status        VARCHAR(50),
    -- Definição da chave estrangeira que garante integridade referencial com a tabela alunos
    FOREIGN KEY (aluno_id) REFERENCES aluno(id)
);


