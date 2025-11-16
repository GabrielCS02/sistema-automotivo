-- ============================
-- INSERÇÃO DE MARCAS
-- ============================

INSERT INTO marcas (id, nome) VALUES (1, 'Honda');
INSERT INTO marcas (id, nome) VALUES (2, 'Toyota');
INSERT INTO marcas (id, nome) VALUES (3, 'Ford');

-- ============================
-- INSERÇÃO DE MODELOS
-- ============================

INSERT INTO modelos (id, nome, ano_lancamento, marca_id) VALUES (1, 'Civic', 2020, 1);
INSERT INTO modelos (id, nome, ano_lancamento, marca_id) VALUES (2, 'Corolla', 2021, 2);
INSERT INTO modelos (id, nome, ano_lancamento, marca_id) VALUES (3, 'Fiesta', 2019, 3);

-- ============================
-- INSERÇÃO DE VEÍCULOS
-- ============================

INSERT INTO veiculos (id, cor, ano_fabricacao, quilometragem, preco, status, modelo_id)
VALUES (1, 'Preto', 2021, 25000, 95000, 'Disponível', 1);

INSERT INTO veiculos (id, cor, ano_fabricacao, quilometragem, preco, status, modelo_id)
VALUES (2, 'Branco', 2022, 12000, 105000, 'Disponível', 2);

INSERT INTO veiculos (id, cor, ano_fabricacao, quilometragem, preco, status, modelo_id)
VALUES (3, 'Prata', 2019, 45000, 60000, 'Vendido', 3);
