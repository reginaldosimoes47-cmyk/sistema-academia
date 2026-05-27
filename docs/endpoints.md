# Endpoints da API - Academia Sistema

Este documento lista todos os endpoints disponíveis na API do Sistema de Academia, organizados por funcionalidade.

## Base URL
`http://localhost:8080`

---

## 1. Alunos (`/alunos`)
Gerencia o cadastro, consulta e atualização de alunos e suas medidas.

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **POST** | `/alunos/cadastrar` | Cadastra um novo aluno. |
| **GET** | `/alunos` | Lista todos os alunos cadastrados. |
| **GET** | `/alunos/buscar?nome={nome}` | Busca alunos pelo nome (contém e ignora case). |
| **PUT** | `/alunos/{id}` | Atualiza dados e medidas de um aluno. |
| **DELETE** | `/alunos/{id}` | Remove um aluno pelo ID. |

---

## 2. Pagamentos (`/pagamentos`)
Gerencia o histórico financeiro dos alunos.

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **POST** | `/pagamentos/cadastrar` | Registra um novo pagamento. |
| **GET** | `/pagamentos` | Lista todos os pagamentos realizados. |
| **GET** | `/pagamentos/aluno/{alunoId}` | Lista pagamentos de um aluno específico. |
| **DELETE** | `/pagamentos/{id}` | Remove um registro de pagamento. |

---

## 3. Planos de Aula (`/planos`)
Gerencia os tipos de planos e cronogramas oferecidos pela academia.

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **POST** | `/planos/cadastrar` | Cria um novo plano de aula. |
| **GET** | `/planos` | Lista todos os planos disponíveis. |
| **DELETE** | `/planos/{id}` | Remove um plano de aula pelo ID. |

---

## Observações
- Todas as requisições que enviam dados (**POST** e **PUT**) esperam um corpo em formato **JSON**.
- As respostas da API também são retornadas em formato **JSON**.
- Em caso de erro, a API retorna códigos HTTP apropriados (400 para erros de validação, 404 para não encontrado, etc).
