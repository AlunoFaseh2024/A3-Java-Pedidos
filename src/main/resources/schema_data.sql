-- ===============================================
-- BANCO DE DADOS: LANCHONETE
-- ===============================================

DROP TABLE IF EXISTS item_pedido;
DROP TABLE IF EXISTS pedido;
DROP TABLE IF EXISTS produto;
DROP TABLE IF EXISTS categoria;
DROP TABLE IF EXISTS funcionario;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS endereco;

-- ===============================================
-- TABELA: CATEGORIA
-- ===============================================
CREATE TABLE categoria (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255)
);

INSERT INTO categoria (nome, descricao) VALUES
('Hambúrgueres', 'Lanches artesanais e combos'),
('Pizzas', 'Diversos sabores e tamanhos'),
('Açaí', 'Copos e tigelas personalizadas'),
('Bebidas', 'Refrigerantes e sucos'),
('Doces', 'Sobremesas e milk-shakes');

-- ===============================================
-- TABELA: PRODUTO
-- ===============================================
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

INSERT INTO produto (nome, descricao, preco, categoria_id, tamanho) VALUES
('X-Bacon', 'Hambúrguer artesanal com bacon e cheddar', 22.90, 1, 'M'),
('Pizza Calabresa', 'Pizza de calabresa tradicional 8 pedaços', 39.90, 2, 'Grande'),
('Açaí 500ml', 'Açaí com banana, leite condensado e granola', 18.00, 3, '500ml'),
('Refrigerante Lata', 'Refrigerante 350ml de diversos sabores', 6.00, 4, '350ml'),
('Milkshake Chocolate', 'Delicioso milkshake com calda e chantilly', 14.50, 5, '400ml');

-- ===============================================
-- TABELA: ENDERECO
-- ===============================================
CREATE TABLE endereco (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    rua VARCHAR(100),
    numero VARCHAR(10),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    complemento VARCHAR(100)
);

INSERT INTO endereco (rua, numero, bairro, cidade, complemento) VALUES
('Rua das Flores', '123', 'Centro', 'São Paulo', 'Apto 2A'),
('Av. Brasil', '500', 'Jardim América', 'São Paulo', NULL);

-- ===============================================
-- TABELA: CLIENTE
-- ===============================================
CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    endereco_id BIGINT,
    CONSTRAINT fk_cliente_endereco FOREIGN KEY (endereco_id)
        REFERENCES endereco (id)
);

INSERT INTO cliente (nome, telefone, endereco_id) VALUES
('João da Silva', '11987654321', 1),
('Maria Oliveira', '11976543210', 2);

-- ===============================================
-- TABELA: FUNCIONARIO
-- ===============================================
CREATE TABLE funcionario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    identificador VARCHAR(10) UNIQUE NOT NULL,
    nome VARCHAR(100) NOT NULL,
    senha_hash VARCHAR(128) NOT NULL,
    cargo VARCHAR(20) NOT NULL
);

-- Senhas: "1234" em SHA256 (usando HashUtils)
INSERT INTO funcionario (identificador, nome, senha_hash, cargo) VALUES
('A101', 'Carlos Gerente', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'GERENTE'),
('B202', 'Ana Atendente', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'ATENDENTE'),
('C303', 'Lucas Entregador', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'ENTREGADOR');

-- ===============================================
-- TABELA: PEDIDO
-- ===============================================
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

INSERT INTO pedido (data_hora, codigo_entrega, status, cliente_id, total) VALUES
(NOW(), '123456', 'ABERTO', 1, 40.90),
(NOW(), '654321', 'CONCLUIDO', 2, 45.50);

-- ===============================================
-- TABELA: ITEM_PEDIDO
-- ===============================================
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

INSERT INTO item_pedido (pedido_id, produto_id, quantidade, preco_unitario) VALUES
(1, 1, 1, 22.90),
(1, 4, 3, 6.00),
(2, 2, 1, 39.90),
(2, 5, 1, 14.50);
