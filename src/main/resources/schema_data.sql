-- BANCO DE DADOS: LANCHONETE

DROP TABLE IF EXISTS item_pedido;
DROP TABLE IF EXISTS pedido;
DROP TABLE IF EXISTS produto;
DROP TABLE IF EXISTS categoria;
DROP TABLE IF EXISTS funcionario;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS endereco;


-- TABELA: CATEGORIA

CREATE TABLE categoria (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255)
);


-- TABELA: PRODUTO

CREATE TABLE produto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    categoria_id BIGINT,
    tamanho VARCHAR(10),
    disponivel BOOLEAN DEFAULT TRUE,
    visivel BOOLEAN DEFAULT TRUE,
    CONSTRAINT fk_produto_categoria FOREIGN KEY (categoria_id)
        REFERENCES categoria (id)
);


-- TABELA: ENDERECO

CREATE TABLE endereco (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    rua VARCHAR(100),
    numero VARCHAR(10),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    complemento VARCHAR(100)
);


-- TABELA: CLIENTE

CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    endereco_id BIGINT,
    CONSTRAINT fk_cliente_endereco FOREIGN KEY (endereco_id)
        REFERENCES endereco (id)
);


-- TABELA: FUNCIONARIO

CREATE TABLE funcionario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    identificador VARCHAR(10) UNIQUE NOT NULL,
    nome VARCHAR(100) NOT NULL,
    senha_hash VARCHAR(128) NOT NULL,
    cargo VARCHAR(20) NOT NULL
);

INSERT INTO funcionario (identificador, nome, senha_hash, cargo) VALUES
('L1', 'Leão', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'GERENTE');


-- TABELA: PEDIDO

CREATE TABLE pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_hora DATETIME,
    codigo_entrega VARCHAR(10),
    status VARCHAR(20),
    cliente_id BIGINT,
    total DECIMAL(10,2),
    CONSTRAINT fk_pedido_cliente FOREIGN KEY (cliente_id)
        REFERENCES cliente (id)
);


-- TABELA: ITEM_PEDIDO

CREATE TABLE item_pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pedido_id BIGINT,
    produto_id BIGINT,
    quantidade INT,
    preco_unitario DECIMAL(10,2),
    CONSTRAINT fk_item_pedido FOREIGN KEY (pedido_id)
        REFERENCES pedido (id),
    CONSTRAINT fk_item_produto FOREIGN KEY (produto_id)
        REFERENCES produto (id)
);
