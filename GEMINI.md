# Academia Sistema - Project Documentation

Este projeto é um sistema de gerenciamento de academia construído com Spring Boot, focado em gerenciar alunos, pagamentos e planos de aula.

## Tecnologias e Versões
- **Java:** 21
- **Spring Boot:** 3.5.14
- **Banco de Dados:** PostgreSQL
- **ORM:** Spring Data JPA (Hibernate)
- **Logging:** SLF4J com LoggerFactory
- **Gerenciador de Dependências:** Maven

## Estrutura do Projeto
O projeto está localizado na pasta `academia/` e segue o padrão arquitetural de camadas:
- `com.reginaldo.academia.controller`: Controladores REST que expõem os endpoints da API.
- `com.reginaldo.academia.service`: Camada de serviço contendo a lógica de negócio, validações e controle transacional.
- `com.reginaldo.academia.repository`: Interfaces JPA para persistência de dados.
- `com.reginaldo.academia.model`: Entidades JPA que mapeiam as tabelas do banco de dados.

## Entidades Principais
1. **Aluno:** Contém dados pessoais (Nome, CPF, Email, RG) e medidas antropométricas (Peso, Altura, Medidas de Biceps, Cintura, etc.).
2. **Pagamento:** Gerencia o histórico financeiro.
3. **PlanoAula:** Gerencia os cronogramas e tipos de planos oferecidos.

## Convenções e Padrões de Código

### 1. Camada de Serviço (Service)
- **Validação:** Realizar validações manuais antes de persistir dados (ex: verificar CPF duplicado, campos nulos).
- **Exceções:** Lançar `ResponseStatusException` com o `HttpStatus` adequado para erros de cliente ou servidor.
- **Transacionalidade:** Utilizar `@Transactional` para garantir a integridade em operações de escrita.
- **Injeção de Dependência:** Preferir injeção via construtor.

### 2. Banco de Dados
- **Configuração:** `spring.jpa.hibernate.ddl-auto=none`. O esquema não é alterado automaticamente pelo Hibernate.
- **Scripts:** Scripts de carga inicial e definição de dados estão em `src/main/resources/Dados/`.

### 3. Logging
- Registrar operações críticas (salvamento, edição, exclusão) utilizando `logger.info()`.

### 4. Idioma
- O código utiliza termos em Português para variáveis de negócio, comentários e mensagens de erro, mantendo a consistência com o contexto educacional/brasileiro do projeto.

## Comandos e Fluxos
- **Execução:** `mvn spring-boot:run` dentro do diretório `academia`.
- **Scripts SQL:** Localizados em `academia/src/main/resources/Dados/`.

## Diretrizes para o Gemini CLI
- Sempre valide a existência de registros antes de tentar editá-los ou excluí-los, seguindo o padrão do `AlunoService`.
- Mantenha a documentação e mensagens em Português.
- Ao adicionar novas funcionalidades, verifique se as novas tabelas/colunas precisam ser adicionadas manualmente aos scripts SQL, dado que o `ddl-auto` está desativado.
