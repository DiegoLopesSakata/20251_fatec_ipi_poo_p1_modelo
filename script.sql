CREATE DATABASE "db_p2";

CREATE TABLE tb_personagem(
    codigo SERIAL PRIMARY KEY,
    nome VARCHAR(200),
    prob_construir FLOAT,
    prob_coletar_madeira FLOAT,
    prob_minerar FLOAT,
    vitorias INT,
    derrotas INT
);

INSERT INTO tb_personagem(nome, prob_construir, prob_coletar_madeira, prob_minerar, vitorias, derrotas) 
VALUES
('Gilsu Junior', '0.4', '0.3', '0.3', '0', '0'),
('Jimin', '0.2', '0.2', '0.6', '0', '0');

SELECT * FROM tb_personagem;