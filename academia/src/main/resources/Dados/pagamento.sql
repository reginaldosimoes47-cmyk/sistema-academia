CREATE TABLE pagamento (
    id              SERIAL PRIMARY KEY,
    aluno_id        INT NOT NULL REFERENCES cadastro_aluno(id),
    plano_id        INT NOT NULL REFERENCES plano_aula(id),
    valor_pago      DECIMAL(10,2) NOT NULL,
    data_pagamento  DATE NOT NULL,
    forma_pagamento VARCHAR(50),
    status          VARCHAR(30) DEFAULT 'PAGO',
    observacao      TEXT
);