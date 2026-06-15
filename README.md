# 🛡️ Gestão de Gastos API

API REST desenvolvida para o gerenciamento inteligente e seguro de despesas e receitas pessoais. O projeto foi estruturado aplicando conceitos modernos de desenvolvimento backend, conteinização e segurança da informação (DevSecOps).

---

## 🚀 Tecnologias Utilizadas

* **Linguagem:** Java 17
* **Framework:** Spring Boot 3 (Spring Web, Spring Data JPA)
* **Banco de Dados:** MySQL (configurado via ambiente isolado)
* **Mapeamento & DTOs:** MapStruct
* **Ambiente:** Docker & Docker Compose
* **Controle de Versão:** Git & GitHub

---

## 🛡️ Diferenciais de Segurança & Boas Práticas (Mentalidade DevSecOps)

Este projeto não foca apenas na funcionalidade, mas também na resiliência e proteção dos dados:

* **Arquitetura Baseada em DTOs:** Utilização de DTOs (Data Transfer Objects) mapeados com MapStruct para evitar a exposição direta das entidades do banco de dados na camada de API, prevenindo vulnerabilidades de injeção de parâmetros em massa (*Mass Assignment*).
* **Proteção contra SQL Injection:** Uso nativo das interfaces do Spring Data JPA, garantindo que todas as consultas ao banco de dados sejam parametrizadas e seguras.
* **Isolamento de Credenciais:** Configuração de dados sensíveis do banco de dados utilizando variáveis de ambiente via Docker Compose, impedindo o vazamento acidental de senhas no código-fonte público.
* **Princípio do Menor Privilégio:** Banco de dados containerizado utilizando imagens minimalistas e configurações focadas apenas no escopo da aplicação.

---

## 📦 Como Executar o Projeto Localmente

### Pré-requisitos
* Java 17 ou superior instalado
* Docker e Docker Compose instalados

### Passo a Passo

1. Clone o repositório para a sua máquina:
```bash
git clone [https://github.com/walldev301089/gestao-gastos.git](https://github.com/walldev301089/gestao-gastos.git)
