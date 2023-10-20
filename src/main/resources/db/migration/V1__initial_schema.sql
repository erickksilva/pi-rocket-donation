CREATE TABLE IF NOT EXISTS endereco (
    id_endereco INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cep VARCHAR(8) NOT NULL,
    rua VARCHAR(150) NOT NULL,
    numero INT NOT NULL,
    complemento VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS conta_bancaria (
    id_cc INTEGER NOT NULL PRIMARY KEY,
    agencia_conta VARCHAR(5) NOT NULL,
    numero_conta VARCHAR(9) NOT NULL,
    chave_pix VARCHAR(150) NOT NULL
);

CREATE TABLE IF NOT EXISTS postagem (
    id_post INTEGER NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(60) NOT NULL,
    data_post DATE NOT NULL,
    texto1 VARCHAR(1000) NOT NULL,
    texto2 VARCHAR(1000) NOT NULL,
    img_url VARCHAR(150) NULL,
    id_Org INT NOT NULL,
    PRIMARY KEY (id_post)
);

CREATE TABLE IF NOT EXISTS doador (
    email VARCHAR(100) NOT NULL PRIMARY KEY,
    nome VARCHAR(35) NOT NULL,
    sobrenome VARCHAR(70) NOT NULL,
    telefone VARCHAR(14) NOT NULL
);

CREATE TABLE IF NOT EXISTS organizacao (
    id_org INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome_org VARCHAR(100) NOT NULL,
    telefone_org VARCHAR(14) NOT NULL,
    email_org VARCHAR(100) NOT NULL,
    site_org VARCHAR(120) NULL,
    missao_org VARCHAR(200) NOT NULL,
    categoria_org VARCHAR(50) NOT NULL,
    data_cadastro DATE NOT NULL
);
