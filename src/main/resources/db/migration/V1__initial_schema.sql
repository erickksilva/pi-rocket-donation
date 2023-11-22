CREATE TABLE IF NOT EXISTS tab_user(
    email varchar(100) NOT NULL PRIMARY KEY,
    username varchar(100) NOT NULL,
    password varchar(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS doador (
    email VARCHAR(100) NOT NULL PRIMARY KEY,
    nome VARCHAR(35) NOT NULL,
    sobrenome VARCHAR(70) NOT NULL,
    telefone VARCHAR(14) NOT NULL,
    FOREIGN KEY (email) REFERENCES tab_user(email)
);

CREATE TABLE IF NOT EXISTS endereco (
    id_endereco INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cep VARCHAR(8) NOT NULL,
    rua VARCHAR(150) NOT NULL,
    numero INT NOT NULL,
    complemento VARCHAR(100),
    zona varchar(50) NOT NULL,
    fk_email_doador VARCHAR(100),
    FOREIGN KEY (fk_email_doador) REFERENCES doador (email)
);

CREATE TABLE IF NOT EXISTS conta_bancaria (
    id_cc INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    agencia_conta VARCHAR(5) NOT NULL,
    numero_conta VARCHAR(9) NOT NULL,
    chave_pix VARCHAR(150) NOT NULL
);

CREATE TABLE IF NOT EXISTS organizacao (
    email_org varchar(100) NOT NULL PRIMARY KEY,
    site VARCHAR(120) NULL,
    missao VARCHAR(200) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    data_cadastro DATE NOT NULL,
    fk_id_endereco INTEGER NOT NULL,
    fk_id_cc INTEGER NOT NULL,
    FOREIGN KEY (email_org) REFERENCES tab_user (email)

);

CREATE TABLE IF NOT EXISTS noticia (
    id_noticia INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(60) NOT NULL,
    data_noticia DATE NOT NULL,
    texto1 VARCHAR(1000) NOT NULL,
    texto2 VARCHAR(1000) NOT NULL,
    img_url VARCHAR(150) NULL,
    fk_email_org VARCHAR(100) NOT NULL,
    FOREIGN KEY (fk_email_org) REFERENCES organizacao(email_org)
);





