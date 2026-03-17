# 🥷 Cadastro de Ninjas — Spring Boot

API RESTful para gerenciamento de cadastro de ninjas e missões, desenvolvida com Spring Boot.

---

## 📋 Sobre o Projeto

O **Cadastro de Ninjas** é uma aplicação back-end que permite realizar operações CRUD sobre as entidades `Ninja` e `Missao`. O relacionamento entre elas é **ManyToOne / OneToMany**: uma missão pode ter vários ninjas, e cada ninja pertence a uma missão.

```
Missao (1) ◄────── (N) Ninja
```

O projeto segue boas práticas de desenvolvimento com Spring Boot, utilizando camadas bem definidas de Controller, Service e Repository.

---

## 🚀 Tecnologias Utilizadas

| Tecnologia | Finalidade |
|---|---|
| Java 17+ | Linguagem principal |
| Spring Boot 3.x | Framework base |
| Spring Web | Criação dos endpoints REST |
| Spring Data JPA | Persistência de dados |
| H2 Database | Banco de dados em memória |
| Flyway | Versionamento e migração do banco |
| Lombok | Redução de boilerplate |
| Maven | Gerenciamento de dependências |

---

## 📁 Estrutura do Projeto

```
src/
└── main/
    ├── java/
    │   └── com/exemplo/ninjas/
    │       ├── controller/
    │       │   ├── NinjaController.java
    │       │   └── MissaoController.java
    │       ├── service/
    │       │   ├── NinjaService.java
    │       │   └── MissaoService.java
    │       ├── repository/
    │       │   ├── NinjaRepository.java
    │       │   └── MissaoRepository.java
    │       ├── model/
    │       │   ├── Ninja.java
    │       │   └── Missao.java
    │       └── NinjasApplication.java
    └── resources/
        ├── application.properties
        └── db/migration/
            └── V1__create_tables.sql
```

---

## 🔧 Como Executar

### Pré-requisitos

- Java 17 ou superior
- Maven 3.8+

### Passos

```bash
# Clone o repositório
git clone https://github.com/savioquixada/Cadastro_De_Ninjas.git

# Entre na pasta do projeto
cd Cadastro_De_Ninjas

# Execute com Maven
./mvnw spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

---

## 📌 Endpoints — Ninja

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/ninjas` | Lista todos os ninjas |
| `GET` | `/ninjas/{id}` | Busca um ninja pelo ID |
| `POST` | `/ninjas` | Cadastra um novo ninja |
| `PUT` | `/ninjas/{id}` | Atualiza os dados de um ninja |
| `DELETE` | `/ninjas/{id}` | Remove um ninja pelo ID |

## 📌 Endpoints — Missão

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/missoes` | Lista todas as missões |
| `GET` | `/missoes/{id}` | Busca uma missão pelo ID |
| `POST` | `/missoes` | Cadastra uma nova missão |
| `PUT` | `/missoes/{id}` | Atualiza os dados de uma missão |
| `DELETE` | `/missoes/{id}` | Remove uma missão pelo ID |

---

## 📦 Exemplos de Payload

### Criar Missão — `POST /missoes`

```json
{
  "nome": "Proteger a Aldeia",
  "descricao": "Missão de alto risco para defender Konoha",
  "rank": "S"
}
```

### Criar Ninja — `POST /ninjas`

```json
{
  "nome": "Naruto Uzumaki",
  "rank": "Hokage",
  "aldeia": "Konoha",
  "missaoId": 1
}
```

### Resposta — `200 OK`

```json
{
  "id": 1,
  "nome": "Naruto Uzumaki",
  "rank": "Hokage",
  "aldeia": "Konoha",
  "missao": {
    "id": 1,
    "nome": "Proteger a Aldeia",
    "descricao": "Missão de alto risco para defender Konoha",
    "rank": "S"
  }
}
```

---

## 🔗 Relacionamento entre Entidades

```
┌──────────────────┐        ┌──────────────────┐
│     Missao       │        │      Ninja        │
│──────────────────│        │──────────────────│
│ id               │◄───────│ id               │
│ nome             │  N:1   │ nome             │
│ descricao        │        │ rank             │
│ rank             │        │ aldeia           │
│ ninjas (List)    │        │ missao (FK)      │
└──────────────────┘        └──────────────────┘
```

- Uma **Missão** pode ter **vários Ninjas** (`@OneToMany`)
- Cada **Ninja** pertence a **uma Missão** (`@ManyToOne`)

---

## 🗃️ Banco de Dados (H2)

Em ambiente de desenvolvimento é utilizado o **H2** (banco em memória), com as migrações gerenciadas pelo **Flyway**.


## ✅ Funcionalidades

- [x] CRUD de Ninjas
- [x] CRUD de Missões
- [x] Relacionamento ManyToOne/OneToMany entre Ninja e Missão
- [x] Migração de banco com Flyway

---

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature: `git checkout -b feature/minha-feature`
3. Commit suas alterações: `git commit -m 'feat: adiciona minha feature'`
4. Push para a branch: `git push origin feature/minha-feature`
5. Abra um Pull Request

---

<p align="center">Feito com ❤️ e muito chakra </p>
