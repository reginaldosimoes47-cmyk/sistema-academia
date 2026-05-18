-- Criação da tabela plano_aula para armazenar informações sobre planos de aula
CREATE TABLE plano_aula (
    -- Campo identificador único da tabela, chave primária com incremento automático
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    -- Nome do plano de aula, campo de texto com até 100 caracteres
    nome_plano  VARCHAR(100),
    -- Descrição detalhada do plano de aula, campo de texto com até 255 caracteres
    descricao   VARCHAR(255),
    -- Valor monetário do plano de aula, campo numérico de ponto flutuante
    valor       DOUBLE,
    -- Duração do plano em meses, campo numérico inteiro
    duracao_meses INTEGER
);

