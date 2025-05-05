
# 🔥 TinderJob

TinderJob é uma aplicação de recrutamento que conecta candidatos e empresas por meio de um sistema de "match", inspirado na dinâmica de aplicativos de relacionamento. Quando ambas as partes demonstram interesse, é possível iniciar uma conversa para oportunidades profissionais.

## 📚 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Arquitetura e Serviços](#arquitetura-e-serviços)
- [Como Executar o Projeto](#como-executar-o-projeto)
- [Funcionalidades](#funcionalidades)
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

- Frontend disponível em: http://localhost:4200  
- Backend (API) disponível em: http://localhost:8080  
- Adminer (visualização do banco): http://localhost:8081

## 🧩 Funcionalidades

- Cadastro e login com autenticação JWT
- CRUD de usuários (empresas e candidatos)
- Publicação e gerenciamento de vagas
- Interface amigável com Angular Material

## 📄 Licença

Este projeto está licenciado sob a licença [MIT](LICENSE).

## 👨‍💻 Autor

- **Davy Lopes**
  - [GitHub](https://github.com/DavyL0)
  - [LinkedIn](https://www.linkedin.com/in/davy-lopes/)
