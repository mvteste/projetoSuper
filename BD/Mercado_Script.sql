-- ========================================
-- CRIAÇÃO DO BANCO
-- ========================================
CREATE DATABASE IF NOT EXISTS MercadoDAO
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;

USE MercadoDAO;

-- ========================================
-- FORNECEDOR
-- ========================================
CREATE TABLE fornecedor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cnpj VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(100),
    endereco VARCHAR(150)
) ENGINE=InnoDB;

-- ========================================
-- FUNCIONARIOS
-- ========================================
CREATE TABLE funcionarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf CHAR(11) NOT NULL UNIQUE,
    telefone VARCHAR(15),
    email VARCHAR(100),
    endereco VARCHAR(150),
    data_admissao DATE NOT NULL,
    data_nascimento DATE NOT NULL,
    status BOOLEAN NOT NULL
) ENGINE=InnoDB;

-- ========================================
-- CARGO
-- ========================================
CREATE TABLE cargo_funcionarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(150)
) ENGINE=InnoDB;

-- ========================================
-- CATEGORIA PRODUTOS
-- ========================================
CREATE TABLE categoria_produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(150)
) ENGINE=InnoDB;

-- ========================================
-- PEDIDO COMPRA
-- ========================================
CREATE TABLE pedido_compra (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quantidade INT NOT NULL,
    total DECIMAL(10,2),
    fornecedor_id INT NOT NULL,
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id)
) ENGINE=InnoDB;

-- ========================================
-- PRODUTOS
-- ========================================
CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE,
    descricao VARCHAR(150),
    preco DECIMAL(10,2) NOT NULL,
    data_vencimento DATE NOT NULL,
    categoria_produto_id INT NOT NULL,
    pedido_compra_id INT NOT NULL,
    FOREIGN KEY (categoria_produto_id) REFERENCES categoria_produtos(id),
    FOREIGN KEY (pedido_compra_id) REFERENCES pedido_compra(id)
) ENGINE=InnoDB;

-- ========================================
-- CLIENTES
-- ========================================
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    cpf CHAR(11) NOT NULL UNIQUE,
    endereco VARCHAR(150),
    telefone VARCHAR(15)
) ENGINE=InnoDB;

-- ========================================
-- VENDAS
-- ========================================
CREATE TABLE vendas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(150),
    data DATE NOT NULL,
    clientes_id INT NOT NULL,
    funcionarios_id INT NOT NULL,
    FOREIGN KEY (clientes_id) REFERENCES clientes(id),
    FOREIGN KEY (funcionarios_id) REFERENCES funcionarios(id)
) ENGINE=InnoDB;

-- ========================================
-- ESTOQUE
-- ========================================
CREATE TABLE estoque (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quantidade INT NOT NULL,
    produtos_id INT NOT NULL,
    FOREIGN KEY (produtos_id) REFERENCES produtos(id)
) ENGINE=InnoDB;

-- ========================================
-- CAIXA
-- ========================================
CREATE TABLE caixa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    valor DECIMAL(10,2) NOT NULL
) ENGINE=InnoDB;

-- ========================================
-- CONTAS A PAGAR
-- ========================================
CREATE TABLE contas_pagar (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    data_vencimento DATE NOT NULL,
    caixa_id INT NOT NULL,
    pedido_compra_id INT NOT NULL,
    FOREIGN KEY (caixa_id) REFERENCES caixa(id),
    FOREIGN KEY (pedido_compra_id) REFERENCES pedido_compra(id)
) ENGINE=InnoDB;

-- ========================================
-- CONTAS A RECEBER
-- ========================================
CREATE TABLE contas_receber (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    data_recebimento DATE NOT NULL,
    caixa_id INT NOT NULL,
    vendas_id INT NOT NULL,
    FOREIGN KEY (caixa_id) REFERENCES caixa(id),
    FOREIGN KEY (vendas_id) REFERENCES vendas(id)
) ENGINE=InnoDB;

-- ========================================
-- CARRINHO (RELACIONAMENTO N:N)
-- ========================================
CREATE TABLE carrinho (
    vendas_id INT NOT NULL,
    produtos_id INT NOT NULL,
    quantidade INT NOT NULL,
    valor DECIMAL(10,2),
    PRIMARY KEY (vendas_id, produtos_id),
    FOREIGN KEY (vendas_id) REFERENCES vendas(id),
    FOREIGN KEY (produtos_id) REFERENCES produtos(id)
) ENGINE=InnoDB;

-- ========================================
-- CONTRATOS
-- ========================================
CREATE TABLE contratos (
    cargo_funcionarios_id INT NOT NULL,
    funcionarios_id INT NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE,
    PRIMARY KEY (cargo_funcionarios_id, funcionarios_id),
    FOREIGN KEY (cargo_funcionarios_id) REFERENCES cargo_funcionarios(id),
    FOREIGN KEY (funcionarios_id) REFERENCES funcionarios(id)
) ENGINE=InnoDB;