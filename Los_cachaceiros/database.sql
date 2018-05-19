CREATE DATABASE IF NOT EXISTS `Los_Cachaceiros` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `Los_Cachaceiros`;
CREATE TABLE IF NOT EXISTS bebida(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    ano INTEGER(4) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    pais VARCHAR(50) NOT NULL,
    descricao TEXT,
    preco FLOAT NOT NULL,
    img VARCHAR(100) DEFAULT NULL
);
INSERT INTO bebida VALUES (default, "51", 1900, "cachaça", "Brasil", "Uma cachaça", 10.00, null);

