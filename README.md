
# 🔥 TinderJob

TinderJob é uma aplicação de recrutamento que conecta candidatos e empresas por meio de um sistema de "match", inspirado na dinâmica de aplicativos de relacionamento. Quando ambas as partes demonstram interesse, é possível iniciar uma conversa para oportunidades profissionais.

## 📚 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Arquitetura e Serviços](#arquitetura-e-serviços)
- [Como Executar o Projeto](#como-executar-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Endpoints da API](#endpoints-da-api)
- [Criando um Usuário Administrador](#criando-um-usuário-administrador)
- [Licença](#licença)
- [Autor](#autor)

## 💼 Sobre o Projeto

A proposta do TinderJob é facilitar o processo seletivo com uma interface moderna e interativa. Empresas podem divulgar vagas e visualizar perfis de candidatos, enquanto os candidatos podem visualizar e curtir vagas. Se ambos curtirem, ocorre o "match" e é possível iniciar uma comunicação.

## ⚙️ Tecnologias Utilizadas

### Backend - Java (Spring Boot)

- Java 17+
- Spring Boot
- Spring Security (com JWT)
- JPA / Hibernate
- PostgreSQL
- Maven

### Frontend - Angular

- Angular 15+
- Angular Material
- TypeScript
- RxJS

### DevOps / Outros

- Docker & Docker Compose
- Adminer (visualizador de banco)
- Git

## 📦 Arquitetura e Serviços

O projeto é composto por quatro serviços principais, definidos no `docker-compose.yml`:

- `postgres`: Banco de dados PostgreSQL.
- `adminer`: Interface web para visualizar o banco.
- `backend`: API em Java com Spring Boot e autenticação JWT.
- `frontend`: Aplicação Angular, servida via Nginx.

Rede: `tinderjob-network`  
Volume de dados persistente: `pgdata`

## 🚀 Como Executar o Projeto

### Pré-requisitos

- Git
- Docker e Docker Compose

### Passos

```bash
# Clone o repositório
git clone https://github.com/DavyL0/TinderJob.git
cd TinderJob

# Execute a aplicação com Docker
docker-compose up --build
```

- Frontend: http://localhost:4200  
- Backend (API): http://localhost:8080  
- Adminer: http://localhost:8081

## 🧩 Funcionalidades

- Cadastro e login com autenticação JWT
- CRUD de usuários (empresas e candidatos)
- Publicação e gerenciamento de vagas
- Candidatura a vagas
- Visualização de vagas com seus respectivos candidatos
- Interface amigável com Angular Material

## 📡 Endpoints da API

### 🔐 Autenticação

| Método | Endpoint         | Descrição                                  |
|--------|------------------|--------------------------------------------|
| POST   | `/auth/register` | Cadastro de novo usuário                   |
| POST   | `/auth/login`    | Login e geração de token JWT               |

**Exemplo de payload para `/auth/register`:**

```json
{
  "name": "Empresa XPTO",
  "email": "empresa@xpto.com",
  "password": "senhaSegura123",
  "admin": true
}
```

**Resposta esperada:**

```json
{
  "id": 1,
  "username": "Empresa XPTO",
  "token": "jwt.token.aqui",
  "admin": true
}
```

> Use o token retornado como header em chamadas autenticadas:
> `Authorization: Bearer <seu-token>`

---

### 👥 Usuários

| Método | Endpoint              | Descrição                           | Autenticação |
|--------|-----------------------|-------------------------------------|--------------|
| GET    | `/user/listar/{id}`   | Buscar usuário por ID               | ❌           |
| GET    | `/user/me`            | Retorna usuário autenticado         | ✅           |
| POST   | `/user`               | Criar novo usuário manualmente      | ❌           |
| PUT    | `/user/{email}`       | Atualizar usuário                   | ✅           |
| DELETE | `/user/{id}`          | Deletar usuário                     | ✅           |

**Exemplo de payload para PUT `/user/{email}`:**

```json
{
  "username": "Novo Nome",
  "password": "novaSenha123"
}
```

---

### 💼 Vagas

| Método | Endpoint                           | Descrição                                                  | Autenticação     |
|--------|------------------------------------|------------------------------------------------------------|------------------|
| GET    | `/vagas/listar`                    | Lista todas as vagas                                       | ❌               |
| GET    | `/vagas/{id}`                      | Busca vaga por ID                                          | ❌               |
| GET    | `/vagas/vagas-com-candidatos`      | Lista vagas com candidatos associados                      | ✅ (admin)       |
| POST   | `/vagas`                           | Cria nova vaga                                             | ✅ (admin/empresa) |
| PUT    | `/vagas/modificar/{id}`            | Atualiza uma vaga                                          | ✅ (admin/empresa) |
| DELETE | `/vagas/{id}`                      | Remove uma vaga                                            | ✅ (admin/empresa) |
| PUT    | `/vagas/{id}/candidatar`           | Usuário se candidata a uma vaga                            | ✅ (usuário)     |

**Exemplo de payload para POST/PUT vaga:**

```json
{
  "nome": "Desenvolvedor Backend",
  "descricao": "Atuar com APIs REST",
  "requisitos": "Java, Spring Boot",
  "status": "ABERTA"
}
```

---

## 🛠️ Criando um Usuário Administrador

Um usuário administrador é responsável por gerenciar as vagas na plataforma (cadastrar, editar e excluir). Para criar um, utilize o endpoint de registro:

### 1. Requisição

**POST** `/auth/register`

```json
{
  "name": "Admin Empresa",
  "email": "admin@empresa.com",
  "password": "senhaForte123",
  "admin": true
}
```

### 2. Resultado

O retorno será um objeto contendo `token` e `admin: true`. Use esse token nas requisições seguintes para endpoints protegidos.

> O campo `"admin": true` é o que determina que o usuário será uma empresa ou administrador com acesso a funcionalidades de vagas.

---

## 📄 Licença

Este projeto está licenciado sob a licença MIT.

## 👨‍💻 Autor

- **Davy Lopes**
  - [GitHub](https://github.com/DavyL0)
  - [LinkedIn](https://www.linkedin.com/in/davy-lopes/)
