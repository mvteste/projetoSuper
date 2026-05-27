CREATE DATABASE IF NOT EXISTS supermercado;
USE supermercado;

-- =====================================================
-- TABELA: CLIENTES
-- =====================================================

CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    endereco VARCHAR(150),
    telefone VARCHAR(15),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP
);

-- =====================================================
-- TABELA: FORNECEDORES
-- =====================================================

CREATE TABLE fornecedor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cnpj VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(100),
    endereco VARCHAR(150),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP
);

-- =====================================================
-- TABELA: CATEGORIA PRODUTO
-- =====================================================

CREATE TABLE categoria_produto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP
);

-- =====================================================
-- TABELA: PRODUTOS
-- =====================================================

CREATE TABLE produtos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    preco DECIMAL(10,2) NOT NULL,
    data_vencimento DATE,

    categoria_id INT NOT NULL,
    fornecedor_id INT NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_produto_categoria
        FOREIGN KEY (categoria_id)
        REFERENCES categoria_produto(id),

    CONSTRAINT fk_produto_fornecedor
        FOREIGN KEY (fornecedor_id)
        REFERENCES fornecedor(id)
);

-- =====================================================
-- TABELA: ESTOQUE
-- =====================================================

CREATE TABLE estoque (
    id INT PRIMARY KEY AUTO_INCREMENT,

    produtos_id INT NOT NULL UNIQUE,

    quantidade INT NOT NULL DEFAULT 0,
    quantidade_minima INT DEFAULT 0,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_estoque_produto
        FOREIGN KEY (produtos_id)
        REFERENCES produtos(id)
);

-- =====================================================
-- TABELA: CARGO FUNCIONÁRIOS
-- =====================================================

CREATE TABLE cargo_funcionarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP
);

-- =====================================================
-- TABELA: FUNCIONÁRIOS
-- =====================================================

CREATE TABLE funcionarios (
    id INT PRIMARY KEY AUTO_INCREMENT,

    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    telefone VARCHAR(15),
    email VARCHAR(100) UNIQUE,
    endereco VARCHAR(150),

    data_admissao DATE,
    data_nascimento DATE,

    status ENUM('ATIVO', 'INATIVO') DEFAULT 'ATIVO',

    cargo_funcionarios_id INT NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_funcionario_cargo
        FOREIGN KEY (cargo_funcionarios_id)
        REFERENCES cargo_funcionarios(id)
);

-- =====================================================
-- TABELA: CONTRATOS
-- =====================================================

CREATE TABLE contratos (
    id INT PRIMARY KEY AUTO_INCREMENT,

    descricao VARCHAR(255),
    salario DECIMAL(10,2) NOT NULL,
    historico TEXT,

    funcionarios_id INT NOT NULL UNIQUE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_contrato_funcionario
        FOREIGN KEY (funcionarios_id)
        REFERENCES funcionarios(id)
);

-- =====================================================
-- TABELA: VENDAS
-- =====================================================

CREATE TABLE vendas (
    id INT PRIMARY KEY AUTO_INCREMENT,

    clientes_id INT NOT NULL,
    funcionarios_id INT NOT NULL,

    data_venda DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    valor_total DECIMAL(10,2) NOT NULL DEFAULT 0,

    forma_pagamento ENUM(
        'DINHEIRO',
        'PIX',
        'CARTAO_CREDITO',
        'CARTAO_DEBITO',
        'BOLETO'
    ) NOT NULL,

    status ENUM(
        'PENDENTE',
        'PAGA',
        'CANCELADA'
    ) DEFAULT 'PENDENTE',

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_venda_cliente
        FOREIGN KEY (clientes_id)
        REFERENCES clientes(id),

    CONSTRAINT fk_venda_funcionario
        FOREIGN KEY (funcionarios_id)
        REFERENCES funcionarios(id)
);

-- =====================================================
-- TABELA: ITEM VENDAS
-- =====================================================

CREATE TABLE item_vendas (
    id INT PRIMARY KEY AUTO_INCREMENT,

    vendas_id INT NOT NULL,
    produtos_id INT NOT NULL,

    quantidade INT NOT NULL,
    valor_unitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_item_venda
        FOREIGN KEY (vendas_id)
        REFERENCES vendas(id),

    CONSTRAINT fk_item_produto
        FOREIGN KEY (produtos_id)
        REFERENCES produtos(id)
);

CREATE TABLE pedido_compra (
    id INT PRIMARY KEY AUTO_INCREMENT,
    
    fornecedor_id INT NOT NULL,
    funcionarios_id INT NOT NULL,
    
    data_pedido DATE NOT NULL,
    data_entrega DATE,
    
    valor_total DECIMAL(10,2),
    
    status VARCHAR(45),
    
    FOREIGN KEY (fornecedor_id)
        REFERENCES fornecedor(id),
        
    FOREIGN KEY (funcionarios_id)
        REFERENCES funcionarios(id)
);

-- =====================================================
-- TABELA: CONTAS A RECEBER
-- =====================================================

CREATE TABLE contas_receber (
    id INT PRIMARY KEY AUTO_INCREMENT,

    nome VARCHAR(100) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,

    data_recebimento DATE NOT NULL,

    status ENUM(
        'PENDENTE',
        'RECEBIDO',
        'ATRASADO'
    ) DEFAULT 'PENDENTE',

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP
);

-- =====================================================
-- TABELA: CONTAS A PAGAR
-- =====================================================

CREATE TABLE contas_pagar (
    id INT PRIMARY KEY AUTO_INCREMENT,

    nome VARCHAR(100) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,

    data_vencimento DATE NOT NULL,

    status ENUM(
        'PENDENTE',
        'PAGO',
        'ATRASADO'
    ) DEFAULT 'PENDENTE',

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP
);

-- =====================================================
-- TABELA: CAIXA
-- =====================================================

CREATE TABLE caixa (
    id INT PRIMARY KEY AUTO_INCREMENT,

    nome VARCHAR(100) NOT NULL,

    tipo_movimento ENUM(
        'ENTRADA',
        'SAIDA'
    ) NOT NULL,

    valor DECIMAL(10,2) NOT NULL,

    data_movimento DATETIME DEFAULT CURRENT_TIMESTAMP,

    observacao TEXT,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP
);