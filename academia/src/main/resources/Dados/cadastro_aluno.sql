
CREATE TABLE alunos (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY, -- Identificador único do aluno, chave primária com incremento automático
    nome        VARCHAR(100), -- Nome completo do aluno, até 100 caracteres
    email       VARCHAR(100), -- Endereço de email do aluno, até 100 caracteres
    cpf         VARCHAR(14), -- Número do CPF do aluno, formato XXX.XXX.XXX-XX
    rg          VARCHAR(20), -- Número do RG do aluno, até 20 caracteres
    idade       INTEGER, -- Idade do aluno em anos
    matricula   VARCHAR(50), -- Número de matrícula do aluno na academia, até 50 caracteres
    plano       VARCHAR(50), -- Tipo de plano contratado pelo aluno, até 50 caracteres
    peso        DOUBLE, -- Peso corporal do aluno em quilogramas
    altura      DOUBLE, -- Altura do aluno em metros
    medida_biceps      DOUBLE, -- Medida do bíceps do aluno em centímetros
    medida_triceps     DOUBLE, -- Medida do tríceps do aluno em centímetros
    medida_cintura     DOUBLE, -- Medida da cintura do aluno em centímetros
    medida_panturrilha DOUBLE, -- Medida da panturrilha do aluno em centímetros
    medida_peitoral    DOUBLE, -- Medida do peitoral do aluno em centímetros
    medida_quadril     DOUBLE -- Medida do quadril do aluno em centímetros
    
);
