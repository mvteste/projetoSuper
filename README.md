# 🛒 Projeto Supermercado - Sistema de Gestão

## 📖 Sobre o Projeto

O **Projeto Supermercado** é um sistema desktop desenvolvido em **Java** como atividade acadêmica do curso **Técnico em Desenvolvimento de Sistemas – SENAC**.

O objetivo do sistema é auxiliar na administração de um supermercado, permitindo o gerenciamento de produtos, clientes, fornecedores, funcionários, estoque e vendas, utilizando banco de dados MySQL e arquitetura em camadas.

---

## 🚀 Tecnologias Utilizadas

* Java
* Java Swing
* MySQL
* JDBC
* NetBeans
* Apache Ant
* MySQL Workbench

---

## 📂 Estrutura do Projeto

```
projetoSuper-lucas/
│
├── src/
│   ├── app/
│   ├── controller/
│   ├── dao/
│   ├── model/
│   └── View/
│
├── Dump20260526/
│   ├── Scripts SQL do banco
│   └── Tabelas
│
├── Modelo relacional supermercado.mwb
├── build.xml
└── README.md
```

---

## 🏗 Arquitetura

O projeto segue uma separação em camadas para facilitar a manutenção e organização do código.

### 📌 Model

Responsável pelas classes que representam as entidades do sistema.

Exemplos:

* Produto
* Cliente
* Funcionário
* Fornecedor
* Categoria
* Estoque
* Venda
* Pagamento

---

### 📌 DAO (Data Access Object)

Responsável pela comunicação com o banco de dados.

Cada entidade possui sua própria classe DAO contendo operações como:

* Inserir
* Atualizar
* Excluir
* Buscar registros

Também possui uma classe de conexão (`Conexao.java`) e uma DAO genérica (`GenericDAO.java`).

---

### 📌 Controller

Realiza a comunicação entre a interface gráfica e a camada de dados.

É responsável por aplicar as regras de negócio antes de acessar o banco de dados.

---

### 📌 View

Interface gráfica construída utilizando Java Swing.

Possui telas para gerenciamento dos principais módulos do sistema.

---

## 📦 Funcionalidades

O sistema contempla os seguintes módulos:

* Cadastro de Produtos
* Cadastro de Categorias
* Cadastro de Clientes
* Cadastro de Fornecedores
* Cadastro de Funcionários
* Controle de Estoque
* Controle de Vendas
* Controle de Pagamentos
* Controle de Tipos de Funcionários
* Gerenciamento de Contas a Pagar
* Gerenciamento de Contas a Receber

---

## 🗄 Banco de Dados

O projeto utiliza **MySQL**.

O repositório contém:

* Modelo relacional (.mwb)
* Dumps SQL
* Estrutura das tabelas
* Procedures (quando disponíveis)

Antes de executar o sistema, importe o banco utilizando os arquivos presentes na pasta:

```
Dump20260526/
```

---

## ▶ Como executar

### 1. Clone o projeto

```bash
git clone <URL_DO_REPOSITORIO>
```

### 2. Abra no NetBeans

Abra o projeto normalmente utilizando o NetBeans.

### 3. Configure o banco

Edite a classe:

```
src/dao/Conexao.java
```

e informe:

* Host
* Porta
* Nome do banco
* Usuário
* Senha

---

### 4. Execute

Inicie a aplicação pela classe:

```
app/main.java
```

---

## 📚 Organização do Projeto

```
Model
   ↓
Controller
   ↓
DAO
   ↓
Banco de Dados
```

A interface gráfica (View) comunica-se com os Controllers, que executam as regras de negócio e utilizam as DAOs para persistir os dados.

---

## 🎯 Objetivos do Projeto

* Aplicar os conceitos de Programação Orientada a Objetos.
* Utilizar o padrão DAO.
* Trabalhar com JDBC.
* Desenvolver interfaces gráficas utilizando Java Swing.
* Integrar Java com banco de dados MySQL.
* Organizar o código utilizando arquitetura em camadas.

---

## 👨‍💻 Autor

**Lucas Goerler Colvero**

Projeto desenvolvido como atividade do curso **Técnico em Desenvolvimento de Sistemas – SENAC**.

---

## 📄 Licença

Projeto desenvolvido para fins acadêmicos e de aprendizado.
