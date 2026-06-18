CREATE DATABASE IF NOT EXISTS supermercado;
USE supermercado;

-- =====================================================
-- Tabela: categoria
-- Armazena as categorias dos produtos (ex: Bebidas, Limpeza)
-- =====================================================
CREATE TABLE categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

-- =====================================================
-- Tabela: tipo_funcionario
-- Armazena os tipos/cargos de funcionário (ex: Caixa, Gerente)
-- =====================================================
CREATE TABLE tipo_funcionario (
    id_tipo_funcionario INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL
);

-- =====================================================
-- Tabela: cliente
-- =====================================================
CREATE TABLE cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    telefone VARCHAR(15),
    endereco VARCHAR(150)
);

-- =====================================================
-- Tabela: fornecedor
-- =====================================================
CREATE TABLE fornecedor (
    id_fornecedor INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cnpj VARCHAR(18) NOT NULL UNIQUE,
    telefone VARCHAR(15)
);

-- =====================================================
-- Tabela: funcionario
-- Relaciona-se com tipo_funcionario
-- =====================================================
CREATE TABLE funcionario (
    id_funcionario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    telefone VARCHAR(15),
    id_tipo_funcionario INT NOT NULL,
    FOREIGN KEY (id_tipo_funcionario) REFERENCES tipo_funcionario(id_tipo_funcionario)
);

-- =====================================================
-- Tabela: produto
-- Relaciona-se com categoria
-- =====================================================
CREATE TABLE produto (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    quantidade INT NOT NULL DEFAULT 0,
    id_categoria INT NOT NULL,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);

-- =====================================================
-- Tabela: estoque
-- Controle de estoque relacionado ao produto
-- =====================================================
CREATE TABLE estoque (
    id_estoque INT AUTO_INCREMENT PRIMARY KEY,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL DEFAULT 0,
    data_atualizacao DATE,
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto)
);

-- =====================================================
-- Tabela: pedido_compra
-- Pedido de compra feito a um fornecedor
-- =====================================================
CREATE TABLE pedido_compra (
    id_pedido_compra INT AUTO_INCREMENT PRIMARY KEY,
    id_fornecedor INT NOT NULL,
    data_pedido DATE NOT NULL,
    valor_total DECIMAL(10,2) NOT NULL DEFAULT 0,
    FOREIGN KEY (id_fornecedor) REFERENCES fornecedor(id_fornecedor)
);

-- =====================================================
-- Tabela: item_pedido
-- Itens de um pedido de compra
-- =====================================================
CREATE TABLE item_pedido (
    id_item_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido_compra INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_pedido_compra) REFERENCES pedido_compra(id_pedido_compra),
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto)
);

-- =====================================================
-- Tabela: venda
-- Relaciona-se com cliente
-- =====================================================
CREATE TABLE venda (
    id_venda INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    data_venda DATE NOT NULL,
    valor_total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

-- =====================================================
-- Tabela: item_venda
-- Itens de uma venda
-- =====================================================
CREATE TABLE item_venda (
    id_item_venda INT AUTO_INCREMENT PRIMARY KEY,
    id_venda INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_venda) REFERENCES venda(id_venda),
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto)
);

-- =====================================================
-- Tabela: contas_pagar
-- Relaciona-se com fornecedor
-- =====================================================
CREATE TABLE contas_pagar (
    id_conta_pagar INT AUTO_INCREMENT PRIMARY KEY,
    id_fornecedor INT NOT NULL,
    data_vencimento DATE NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    situacao VARCHAR(20) NOT NULL DEFAULT 'Pendente',
    FOREIGN KEY (id_fornecedor) REFERENCES fornecedor(id_fornecedor)
);

-- =====================================================
-- Tabela: contas_receber
-- Relaciona-se com venda
-- =====================================================
CREATE TABLE contas_receber (
    id_conta_receber INT AUTO_INCREMENT PRIMARY KEY,
    id_venda INT NOT NULL,
    data_vencimento DATE NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    situacao VARCHAR(20) NOT NULL DEFAULT 'Pendente',
    FOREIGN KEY (id_venda) REFERENCES venda(id_venda)
);

-- =====================================================
-- Tabela: contrato_trab
-- Contrato de trabalho do funcionário
-- =====================================================
CREATE TABLE contrato_trab (
    id_contrato INT AUTO_INCREMENT PRIMARY KEY,
    id_funcionario INT NOT NULL,
    data_admissao DATE NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    cargo VARCHAR(50),
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario)
);

-- =====================================================
-- Tabela: caixa
-- Registro de movimentações de caixa (entradas e saídas)
-- =====================================================
CREATE TABLE caixa (
    id_caixa INT AUTO_INCREMENT PRIMARY KEY,
    data_movimento DATE NOT NULL,
    tipo_movimentacao VARCHAR(20) NOT NULL,
    descricao VARCHAR(150),
    valor DECIMAL(10,2) NOT NULL
);