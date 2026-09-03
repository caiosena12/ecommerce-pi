-- ==========================================
-- CATEGORIA - 5 REGISTROS
-- ==========================================

INSERT INTO categoria (nome, descricao)
VALUES ('Informatica', 'Produtos de informatica');

INSERT INTO categoria (nome, descricao)
VALUES ('Livros', 'Livros tecnicos e educacionais');

INSERT INTO categoria (nome, descricao)
VALUES ('Celulares', 'Smartphones e acessorios');

INSERT INTO categoria (nome, descricao)
VALUES ('Eletronicos', 'Produtos eletronicos diversos');

INSERT INTO categoria (nome, descricao)
VALUES ('Perifericos', 'Perifericos para computadores');


-- ==========================================
-- PRODUTOS - 5 REGISTROS
-- ==========================================

INSERT INTO produtos
(nome, descricao, preco, estoque, categoria_id)
VALUES
('Codigo Limpo', 'Livro do autor Robert C. Martin', 87.34, 10, 2);

INSERT INTO produtos
(nome, descricao, preco, estoque, categoria_id)
VALUES
('Notebook Lenovo', 'Notebook para estudos e trabalho', 3499.90, 8, 1);

INSERT INTO produtos
(nome, descricao, preco, estoque, categoria_id)
VALUES
('Samsung Galaxy A55', 'Smartphone Android', 1899.90, 15, 3);

INSERT INTO produtos
(nome, descricao, preco, estoque, categoria_id)
VALUES
('Fone Bluetooth', 'Fone de ouvido sem fio', 249.90, 20, 4);

INSERT INTO produtos
(nome, descricao, preco, estoque, categoria_id)
VALUES
('Teclado Mecanico', 'Teclado mecanico para computador', 399.90, 12, 5);


-- ==========================================
-- CLIENTES - 5 REGISTROS
-- ==========================================

INSERT INTO clientes
(nome, email, telefone)
VALUES
('Caio', 'caio@gmail.com', '40028922');

INSERT INTO clientes
(nome, email, telefone)
VALUES
('Arthur', 'arthur@gmail.com', '40028923');

INSERT INTO clientes
(nome, email, telefone)
VALUES
('Eric', 'eric@gmail.com', '40028924');

INSERT INTO clientes
(nome, email, telefone)
VALUES
('Flavio', 'flavio@gmail.com', '40028925');

INSERT INTO clientes
(nome, email, telefone)
VALUES
('Miguel', 'miguel@gmail.com', '40028926');


-- ==========================================
-- PEDIDO - 5 REGISTROS
-- ==========================================

INSERT INTO pedido
(data, status, valor_total, clientes_id)
VALUES
('2026-09-01 10:30:00', 'PAGO', 87.34, 1);

INSERT INTO pedido
(data, status, valor_total, clientes_id)
VALUES
('2026-09-01 11:15:00', 'PAGO', 3499.90, 2);

INSERT INTO pedido
(data, status, valor_total, clientes_id)
VALUES
('2026-09-01 14:20:00', 'PAGO', 1899.90, 3);

INSERT INTO pedido
(data, status, valor_total, clientes_id)
VALUES
('2026-09-02 09:45:00', 'PENDENTE', 249.90, 4);

INSERT INTO pedido
(data, status, valor_total, clientes_id)
VALUES
('2026-09-02 16:10:00', 'PAGO', 399.90, 5);


-- ==========================================
-- ITEM_PEDIDO - 5 REGISTROS
-- ATENCAO: seu banco possui pedidio_id
-- ==========================================

INSERT INTO item_pedido
(quantidade, valor_unitario, pedido_id, produtos_id)
VALUES
(1, 87.34, 1, 1);

INSERT INTO item_pedido
(quantidade, valor_unitario, pedido_id, produtos_id)
VALUES
(1, 3499.90, 2, 2);

INSERT INTO item_pedido
(quantidade, valor_unitario, pedido_id, produtos_id)
VALUES
(1, 1899.90, 3, 3);

INSERT INTO item_pedido
(quantidade, valor_unitario, pedido_id, produtos_id)
VALUES
(1, 249.90, 4, 4);

INSERT INTO item_pedido
(quantidade, valor_unitario, pedido_id, produtos_id)
VALUES
(1, 399.90, 5, 5);


-- ==========================================
-- PAGAMENTO - 5 REGISTROS
-- ==========================================

INSERT INTO pagamento
(valor, data, status, tipo, pedido_id)
VALUES
(87.34, '2026-09-01 10:35:00', 'APROVADO', 'PIX', 1);

INSERT INTO pagamento
(valor, data, status, tipo, pedido_id)
VALUES
(3499.90, '2026-09-01 11:20:00', 'APROVADO', 'CARTAO', 2);

INSERT INTO pagamento
(valor, data, status, tipo, pedido_id)
VALUES
(1899.90, '2026-09-01 14:25:00', 'APROVADO', 'PIX', 3);

INSERT INTO pagamento
(valor, data, status, tipo, pedido_id)
VALUES
(249.90, '2026-09-02 09:50:00', 'PENDENTE', 'BOLETO', 4);

INSERT INTO pagamento
(valor, data, status, tipo, pedido_id)
VALUES
(399.90, '2026-09-02 16:15:00', 'APROVADO', 'CARTAO', 5);