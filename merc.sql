-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Medico` (
  `idMedico` INT NOT NULL AUTO_INCREMENT,
  `Nome_Medico` VARCHAR(50) NOT NULL,
  `CRM` VARCHAR(15) NOT NULL,
  `CPF` INT NOT NULL,
  `DT_Nascimento` DATE NULL,
  PRIMARY KEY (`idMedico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Paciente` (
  `idPaciente` INT NOT NULL AUTO_INCREMENT,
  `Nome_Paciente` VARCHAR(50) NOT NULL,
  `CPF` VARCHAR(14) NOT NULL,
  `DT_Nasc_Paciente` DATE NULL,
  `CodConvenio` INT NULL,
  `Medico_idMedico` INT NOT NULL,
  PRIMARY KEY (`idPaciente`),
  INDEX `fk_Paciente_Medico_idx` (`Medico_idMedico` ASC) VISIBLE,
  CONSTRAINT `fk_Paciente_Medico`
    FOREIGN KEY (`Medico_idMedico`)
    REFERENCES `mydb`.`Medico` (`idMedico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Governador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Governador` (
  `idGovernador` INT NOT NULL AUTO_INCREMENT,
  `Nome_Governador` VARCHAR(50) NOT NULL,
  `Partido` VARCHAR(40) NOT NULL,
  `CPF` VARCHAR(11) NOT NULL,
  `DT_Nascimento_Gov` DATE NULL,
  PRIMARY KEY (`idGovernador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Estado` (
  `idEstado` INT NOT NULL AUTO_INCREMENT,
  `Nome_Estado` VARCHAR(50) NOT NULL,
  `UF` VARCHAR(2) NOT NULL,
  `Governador_idGovernador` INT NOT NULL,
  PRIMARY KEY (`idEstado`),
  INDEX `fk_Estado_Governador1_idx` (`Governador_idGovernador` ASC) VISIBLE,
  CONSTRAINT `fk_Estado_Governador1`
    FOREIGN KEY (`Governador_idGovernador`)
    REFERENCES `mydb`.`Governador` (`idGovernador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Autor` (
  `idAutor` INT NOT NULL AUTO_INCREMENT,
  `Nome_Autor` VARCHAR(50) NOT NULL,
  `CPF_Autor` VARCHAR(45) NOT NULL,
  `DT_Nascimento_Autor` DATE NULL,
  PRIMARY KEY (`idAutor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Livro` (
  `idLivro` INT NOT NULL AUTO_INCREMENT,
  `Nome_Livro` VARCHAR(60) NOT NULL,
  `Editora_Livro` VARCHAR(50) NOT NULL,
  `DT_Lancamento` DATE NULL,
  `Autor_idAutor` INT NOT NULL,
  PRIMARY KEY (`idLivro`, `Autor_idAutor`),
  INDEX `fk_Livro_Autor1_idx` (`Autor_idAutor` ASC) VISIBLE,
  CONSTRAINT `fk_Livro_Autor1`
    FOREIGN KEY (`Autor_idAutor`)
    REFERENCES `mydb`.`Autor` (`idAutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Empregado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Empregado` (
  `idEmpregado` INT NOT NULL AUTO_INCREMENT,
  `Nome_Empregado` VARCHAR(50) NOT NULL,
  `CPF_Empregado` CHAR(14) NOT NULL,
  `DT_Nascimento_Empregado` DATE NULL,
  `Funcao` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idEmpregado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Dependente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Dependente` (
  `idDependente` INT NOT NULL AUTO_INCREMENT,
  `Nome_dependente` VARCHAR(50) NOT NULL,
  `CPF_Dependente` CHAR(14) NOT NULL,
  `DT_Nsc_Dependente` DATE NOT NULL,
  `Empregado_idEmpregado` INT NOT NULL,
  PRIMARY KEY (`idDependente`),
  INDEX `fk_Dependente_Empregado1_idx` (`Empregado_idEmpregado` ASC) VISIBLE,
  CONSTRAINT `fk_Dependente_Empregado1`
    FOREIGN KEY (`Empregado_idEmpregado`)
    REFERENCES `mydb`.`Empregado` (`idEmpregado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Professores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Professores` (
  `idProfessores` INT NOT NULL AUTO_INCREMENT,
  `Nome_Professor` VARCHAR(50) NOT NULL,
  `CPF_Professor` CHAR(14) NOT NULL,
  `Disciplina` VARCHAR(50) NOT NULL,
  `DT_Nsc_Prof` DATE NULL,
  PRIMARY KEY (`idProfessores`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Coordenacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Coordenacao` (
  `idCoordenacao` INT NOT NULL AUTO_INCREMENT,
  `Escola` VARCHAR(60) NOT NULL,
  `Professores_idProfessores` INT NOT NULL,
  PRIMARY KEY (`idCoordenacao`),
  INDEX `fk_Coordenacao_Professores1_idx` (`Professores_idProfessores` ASC) VISIBLE,
  CONSTRAINT `fk_Coordenacao_Professores1`
    FOREIGN KEY (`Professores_idProfessores`)
    REFERENCES `mydb`.`Professores` (`idProfessores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Clinica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Clinica` (
  `idClinica` INT NOT NULL AUTO_INCREMENT,
  `Nome_Clinica` VARCHAR(50) NOT NULL,
  `End_Clinica` VARCHAR(100) NOT NULL,
  `CNPJ_Clinica` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idClinica`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MedicoPediatra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`MedicoPediatra` (
  `idMedicoPediatra` INT NOT NULL AUTO_INCREMENT,
  `Nome_Med_Pediatra` VARCHAR(50) NOT NULL,
  `CRM` VARCHAR(15) NOT NULL,
  `CPF_Medico_Ped` CHAR(14) NOT NULL,
  `DT_Nasc_Med_Ped` DATE NULL,
  `Clinica_idClinica` INT NOT NULL,
  PRIMARY KEY (`idMedicoPediatra`),
  INDEX `fk_MedicoPediatra_Clinica1_idx` (`Clinica_idClinica` ASC) VISIBLE,
  CONSTRAINT `fk_MedicoPediatra_Clinica1`
    FOREIGN KEY (`Clinica_idClinica`)
    REFERENCES `mydb`.`Clinica` (`idClinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MedicoNeuro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`MedicoNeuro` (
  `idMedicoNeuro` INT NOT NULL AUTO_INCREMENT,
  `Nome_Medico_Neuro` VARCHAR(50) NOT NULL,
  `CRM` VARCHAR(15) NOT NULL,
  `CPF` CHAR(14) NOT NULL,
  `DT_Nasc_Med_Neuro` DATE NULL,
  `Clinica_idClinica` INT NOT NULL,
  PRIMARY KEY (`idMedicoNeuro`),
  INDEX `fk_MedicoNeuro_Clinica1_idx` (`Clinica_idClinica` ASC) VISIBLE,
  CONSTRAINT `fk_MedicoNeuro_Clinica1`
    FOREIGN KEY (`Clinica_idClinica`)
    REFERENCES `mydb`.`Clinica` (`idClinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Medicoorto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Medicoorto` (
  `idMedicoorto` INT NOT NULL AUTO_INCREMENT,
  `Nome_Medico_Orto` VARCHAR(50) NOT NULL,
  `CRM` VARCHAR(15) NOT NULL,
  `CPF` CHAR(14) NOT NULL,
  `DT_Nasc_Med_Orto` DATE NULL,
  `Clinica_idClinica` INT NOT NULL,
  PRIMARY KEY (`idMedicoorto`),
  INDEX `fk_Medicoorto_Clinica1_idx` (`Clinica_idClinica` ASC) VISIBLE,
  CONSTRAINT `fk_Medicoorto_Clinica1`
    FOREIGN KEY (`Clinica_idClinica`)
    REFERENCES `mydb`.`Clinica` (`idClinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Produto` (
  `idProduto` INT NOT NULL AUTO_INCREMENT,
  `Nome_Produto` VARCHAR(60) NOT NULL,
  `Marca_Produto` VARCHAR(50) NOT NULL,
  `DT_Vencimento` DATE NOT NULL,
  `Tipo_Produto` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idProduto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `Nome_Usuario` VARCHAR(50) NOT NULL,
  `CPF_Usuario` CHAR(14) NOT NULL,
  `DT_Nasc_Usuario` DATE NULL,
  `Produto_idProduto` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_Usuario_Produto1_idx` (`Produto_idProduto` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_Produto1`
    FOREIGN KEY (`Produto_idProduto`)
    REFERENCES `mydb`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Carro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Carro` (
  `idCarro` INT NOT NULL AUTO_INCREMENT,
  `Nome_Carro` VARCHAR(45) NOT NULL,
  `Marca_Carro` VARCHAR(45) NOT NULL,
  `Cor_Carro` VARCHAR(40) NOT NULL,
  `Ano_Fabricacao` YEAR(4) NOT NULL,
  `Chassi` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCarro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `Nome_categoria` VARCHAR(45) NOT NULL,
  `Classe` VARCHAR(40) NOT NULL,
  `Carro_idCarro` INT NOT NULL,
  PRIMARY KEY (`idCategoria`),
  INDEX `fk_Categoria_Carro1_idx` (`Carro_idCarro` ASC) VISIBLE,
  CONSTRAINT `fk_Categoria_Carro1`
    FOREIGN KEY (`Carro_idCarro`)
    REFERENCES `mydb`.`Carro` (`idCarro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pessoa` (
  `idPessoa` INT NOT NULL,
  `NM_Pessoa` VARCHAR(45) NULL,
  `CPF` CHAR(11) NULL,
  `CNPJ` CHAR(14) NULL,
  `Endereco` VARCHAR(80) NULL,
  `Email` VARCHAR(45) NULL,
  `Telefone` INT NULL,
  PRIMARY KEY (`idPessoa`),
  UNIQUE INDEX `CPF_UNIQUE` (`CPF` ASC) VISIBLE,
  UNIQUE INDEX `CNPJ_UNIQUE` (`CNPJ` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Empresa` (
  `idPessoa` INT NOT NULL,
  `idEmpresa` INT NOT NULL,
  PRIMARY KEY (`idEmpresa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NOT NULL,
  `data_Nasc` DATE NOT NULL,
  `cpf_cliente` VARCHAR(14) NOT NULL,
  `celular` VARCHAR(13) NULL,
  `email` VARCHAR(45) NULL,
  `endereco` VARCHAR(100) NULL,
  `Cidade` VARCHAR(50) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tipo_funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tipo_funcionario` (
  `idtipo_funcionario` INT NOT NULL,
  `descricao` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idtipo_funcionario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`salario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`salario` (
  `idsalario` INT NOT NULL,
  `valor_anterior` DECIMAL(10,2) NOT NULL,
  `valor_atual` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`idsalario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`funcionario` (
  `idfuncionario` INT NOT NULL,
  `nome_func` VARCHAR(60) NOT NULL,
  `cpf_funcionario` VARCHAR(14) NOT NULL,
  `celular` VARCHAR(13) NOT NULL,
  `email` VARCHAR(45) NULL,
  `endereco` VARCHAR(100) NULL,
  `cidade` VARCHAR(50) NULL,
  `data_nasc` DATE NOT NULL,
  `data_admissao` DATE NOT NULL,
  `status` TINYINT(1) NOT NULL COMMENT '0 é inativo e 1 é ativo',
  `tipo_funcionario_idtipo_funcionario` INT NOT NULL,
  `salario_idsalario` INT NOT NULL,
  PRIMARY KEY (`idfuncionario`, `salario_idsalario`),
  INDEX `fk_Funcionario_tipo_funcionario1_idx` (`tipo_funcionario_idtipo_funcionario` ASC) VISIBLE,
  INDEX `fk_funcionario_salario1_idx` (`salario_idsalario` ASC) VISIBLE,
  CONSTRAINT `fk_Funcionario_tipo_funcionario1`
    FOREIGN KEY (`tipo_funcionario_idtipo_funcionario`)
    REFERENCES `mydb`.`tipo_funcionario` (`idtipo_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_salario1`
    FOREIGN KEY (`salario_idsalario`)
    REFERENCES `mydb`.`salario` (`idsalario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`categoria` (
  `idcategoria` INT NOT NULL,
  `descricao_categoria` VARCHAR(50) NULL,
  PRIMARY KEY (`idcategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`fornecedor` (
  `idfornecedor` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `cnpj` VARCHAR(20) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idfornecedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`produto` (
  `idproduto` INT NOT NULL,
  `descricao_produto` VARCHAR(50) NOT NULL,
  `preco` DECIMAL(10,2) NOT NULL,
  `validade_produto` DATE NOT NULL,
  `categoria_idcategoria` INT NOT NULL,
  `fornecedor_idfornecedor` INT NOT NULL,
  PRIMARY KEY (`idproduto`, `categoria_idcategoria`, `fornecedor_idfornecedor`),
  INDEX `fk_produto_categoria1_idx` (`categoria_idcategoria` ASC) VISIBLE,
  INDEX `fk_produto_fornecedor1_idx` (`fornecedor_idfornecedor` ASC) VISIBLE,
  CONSTRAINT `fk_produto_categoria1`
    FOREIGN KEY (`categoria_idcategoria`)
    REFERENCES `mydb`.`categoria` (`idcategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_fornecedor1`
    FOREIGN KEY (`fornecedor_idfornecedor`)
    REFERENCES `mydb`.`fornecedor` (`idfornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Compra` (
  `idCompra` INT NOT NULL,
  `numero_nota` VARCHAR(45) NOT NULL,
  `data_compra` DATE NOT NULL,
  `data_entrega` DATE NOT NULL,
  `total` DECIMAL(10,2) NOT NULL,
  `fornecedor_idfornecedor` INT NOT NULL,
  `produto_idproduto` INT NOT NULL,
  `produto_categoria_idcategoria` INT NOT NULL,
  `produto_fornecedor_idfornecedor` INT NOT NULL,
  PRIMARY KEY (`idCompra`, `fornecedor_idfornecedor`, `produto_idproduto`, `produto_categoria_idcategoria`, `produto_fornecedor_idfornecedor`),
  INDEX `fk_Compra_fornecedor1_idx` (`fornecedor_idfornecedor` ASC) VISIBLE,
  INDEX `fk_Compra_produto1_idx` (`produto_idproduto` ASC, `produto_categoria_idcategoria` ASC, `produto_fornecedor_idfornecedor` ASC) VISIBLE,
  CONSTRAINT `fk_Compra_fornecedor1`
    FOREIGN KEY (`fornecedor_idfornecedor`)
    REFERENCES `mydb`.`fornecedor` (`idfornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compra_produto1`
    FOREIGN KEY (`produto_idproduto` , `produto_categoria_idcategoria` , `produto_fornecedor_idfornecedor`)
    REFERENCES `mydb`.`produto` (`idproduto` , `categoria_idcategoria` , `fornecedor_idfornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`conta_pagar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`conta_pagar` (
  `idcontapagar` INT NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `data_venci` DATE NOT NULL,
  `data_pagamento` DATE NOT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `Compra_idCompra` INT NOT NULL,
  `Compra_fornecedor_idfornecedor` INT NOT NULL,
  `Compra_produto_idproduto` INT NOT NULL,
  `Compra_produto_categoria_idcategoria` INT NOT NULL,
  `Compra_produto_fornecedor_idfornecedor` INT NOT NULL,
  PRIMARY KEY (`idcontapagar`, `Compra_idCompra`, `Compra_fornecedor_idfornecedor`, `Compra_produto_idproduto`, `Compra_produto_categoria_idcategoria`, `Compra_produto_fornecedor_idfornecedor`),
  INDEX `fk_conta_pagar_Compra1_idx` (`Compra_idCompra` ASC, `Compra_fornecedor_idfornecedor` ASC, `Compra_produto_idproduto` ASC, `Compra_produto_categoria_idcategoria` ASC, `Compra_produto_fornecedor_idfornecedor` ASC) VISIBLE,
  CONSTRAINT `fk_conta_pagar_Compra1`
    FOREIGN KEY (`Compra_idCompra` , `Compra_fornecedor_idfornecedor` , `Compra_produto_idproduto` , `Compra_produto_categoria_idcategoria` , `Compra_produto_fornecedor_idfornecedor`)
    REFERENCES `mydb`.`Compra` (`idCompra` , `fornecedor_idfornecedor` , `produto_idproduto` , `produto_categoria_idcategoria` , `produto_fornecedor_idfornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`caixa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`caixa` (
  `idcaixa` INT NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `saldo_abertura` DECIMAL(10,2) NOT NULL,
  `saldo_fechamento` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`idcaixa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`venda` (
  `idvenda` INT NOT NULL,
  `cupom_venda` VARCHAR(45) NOT NULL,
  `data_venda` DATE NOT NULL,
  `subtotal` DECIMAL(10,2) NOT NULL,
  `desconto` DECIMAL(10,2) NOT NULL,
  `total` DECIMAL(10,2) NOT NULL,
  `caixa_idcaixa` INT NOT NULL,
  `cliente_idCliente` INT NOT NULL,
  `venda_idvenda` INT NOT NULL,
  `venda_caixa_idcaixa` INT NOT NULL,
  `venda_cliente_idCliente` INT NOT NULL,
  `funcionario_idfuncionario` INT NOT NULL,
  `funcionario_salario_idsalario` INT NOT NULL,
  PRIMARY KEY (`idvenda`, `caixa_idcaixa`, `cliente_idCliente`, `venda_idvenda`, `venda_caixa_idcaixa`, `venda_cliente_idCliente`, `funcionario_idfuncionario`, `funcionario_salario_idsalario`),
  UNIQUE INDEX `cupom_venda_UNIQUE` (`cupom_venda` ASC) VISIBLE,
  INDEX `fk_venda_caixa1_idx` (`caixa_idcaixa` ASC) VISIBLE,
  INDEX `fk_venda_cliente1_idx` (`cliente_idCliente` ASC) VISIBLE,
  INDEX `fk_venda_venda1_idx` (`venda_idvenda` ASC, `venda_caixa_idcaixa` ASC, `venda_cliente_idCliente` ASC) VISIBLE,
  INDEX `fk_venda_funcionario1_idx` (`funcionario_idfuncionario` ASC, `funcionario_salario_idsalario` ASC) VISIBLE,
  CONSTRAINT `fk_venda_caixa1`
    FOREIGN KEY (`caixa_idcaixa`)
    REFERENCES `mydb`.`caixa` (`idcaixa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_cliente1`
    FOREIGN KEY (`cliente_idCliente`)
    REFERENCES `mydb`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_venda1`
    FOREIGN KEY (`venda_idvenda` , `venda_caixa_idcaixa` , `venda_cliente_idCliente`)
    REFERENCES `mydb`.`venda` (`idvenda` , `caixa_idcaixa` , `cliente_idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_funcionario1`
    FOREIGN KEY (`funcionario_idfuncionario` , `funcionario_salario_idsalario`)
    REFERENCES `mydb`.`funcionario` (`idfuncionario` , `salario_idsalario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`conta_receber`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`conta_receber` (
  `idconta_receber` INT NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `data_vencimento` DATE NOT NULL,
  `data_recebimento` DATE NOT NULL,
  `valor_recebido` DECIMAL(10,2) NOT NULL,
  `cliente_idCliente` INT NOT NULL,
  `venda_idvenda` INT NOT NULL,
  PRIMARY KEY (`idconta_receber`, `cliente_idCliente`, `venda_idvenda`),
  INDEX `fk_conta_receber_cliente1_idx` (`cliente_idCliente` ASC) VISIBLE,
  INDEX `fk_conta_receber_venda1_idx` (`venda_idvenda` ASC) VISIBLE,
  CONSTRAINT `fk_conta_receber_cliente1`
    FOREIGN KEY (`cliente_idCliente`)
    REFERENCES `mydb`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_conta_receber_venda1`
    FOREIGN KEY (`venda_idvenda`)
    REFERENCES `mydb`.`venda` (`idvenda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`estoque` (
  `idestoque` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `produto_idproduto` INT NOT NULL,
  `produto_categoria_idcategoria` INT NOT NULL,
  `produto_fornecedor_idfornecedor` INT NOT NULL,
  PRIMARY KEY (`idestoque`, `produto_idproduto`, `produto_categoria_idcategoria`, `produto_fornecedor_idfornecedor`),
  INDEX `fk_estoque_produto1_idx` (`produto_idproduto` ASC, `produto_categoria_idcategoria` ASC, `produto_fornecedor_idfornecedor` ASC) VISIBLE,
  CONSTRAINT `fk_estoque_produto1`
    FOREIGN KEY (`produto_idproduto` , `produto_categoria_idcategoria` , `produto_fornecedor_idfornecedor`)
    REFERENCES `mydb`.`produto` (`idproduto` , `categoria_idcategoria` , `fornecedor_idfornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`itens_venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`itens_venda` (
  `iditens_venda` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `produto_idproduto` INT NOT NULL,
  `produto_categoria_idcategoria` INT NOT NULL,
  `produto_fornecedor_idfornecedor` INT NOT NULL,
  `venda_idvenda` INT NOT NULL,
  `venda_caixa_idcaixa` INT NOT NULL,
  `venda_cliente_idCliente` INT NOT NULL,
  `venda_venda_idvenda` INT NOT NULL,
  `venda_venda_caixa_idcaixa` INT NOT NULL,
  `venda_venda_cliente_idCliente` INT NOT NULL,
  `venda_funcionario_idfuncionario` INT NOT NULL,
  `venda_funcionario_salario_idsalario` INT NOT NULL,
  PRIMARY KEY (`iditens_venda`, `produto_idproduto`, `produto_categoria_idcategoria`, `produto_fornecedor_idfornecedor`, `venda_idvenda`, `venda_caixa_idcaixa`, `venda_cliente_idCliente`, `venda_venda_idvenda`, `venda_venda_caixa_idcaixa`, `venda_venda_cliente_idCliente`, `venda_funcionario_idfuncionario`, `venda_funcionario_salario_idsalario`),
  INDEX `fk_itens_venda_produto1_idx` (`produto_idproduto` ASC, `produto_categoria_idcategoria` ASC, `produto_fornecedor_idfornecedor` ASC) VISIBLE,
  INDEX `fk_itens_venda_venda1_idx` (`venda_idvenda` ASC, `venda_caixa_idcaixa` ASC, `venda_cliente_idCliente` ASC, `venda_venda_idvenda` ASC, `venda_venda_caixa_idcaixa` ASC, `venda_venda_cliente_idCliente` ASC, `venda_funcionario_idfuncionario` ASC, `venda_funcionario_salario_idsalario` ASC) VISIBLE,
  CONSTRAINT `fk_itens_venda_produto1`
    FOREIGN KEY (`produto_idproduto` , `produto_categoria_idcategoria` , `produto_fornecedor_idfornecedor`)
    REFERENCES `mydb`.`produto` (`idproduto` , `categoria_idcategoria` , `fornecedor_idfornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itens_venda_venda1`
    FOREIGN KEY (`venda_idvenda` , `venda_caixa_idcaixa` , `venda_cliente_idCliente` , `venda_venda_idvenda` , `venda_venda_caixa_idcaixa` , `venda_venda_cliente_idCliente` , `venda_funcionario_idfuncionario` , `venda_funcionario_salario_idsalario`)
    REFERENCES `mydb`.`venda` (`idvenda` , `caixa_idcaixa` , `cliente_idCliente` , `venda_idvenda` , `venda_caixa_idcaixa` , `venda_cliente_idCliente` , `funcionario_idfuncionario` , `funcionario_salario_idsalario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
