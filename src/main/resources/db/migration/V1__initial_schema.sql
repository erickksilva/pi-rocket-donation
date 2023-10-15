CREATE TABLE IF NOT EXISTS endereco (
cep varchar(8) NOT NULL,
rua varchar(150) NOT NULL,
numero INT NOT NULL,
complemento varchar(100),
primary key(cep)
);

CREATE TABLE IF NOT EXISTS postagem (
id_post BIGSERIAL NOT NULL AUTO_INCREMENT,
titulo VARCHAR(60) NOT NULL,
data_post DATE NOT NULL,
descricao1 VARCHAR(1000) NOT NULL,
descricao2 VARCHAR(1000) NOT NULL,
img_url VARCHAR(200) NULL,
id_Org INT NOT NULL,
PRIMARY KEY (id_post),
FOREIGN KEY (id_org)REFERENCES organizacao (id_org)
);


CREATE TABLE IF NOT EXISTS organizacao (
  id_org BIGSERIAL NOT NULL AUTO_INCREMENT,
  nome_org VARCHAR(100) NOT NULL,
  telefone_org VARCHAR(14) NOT NULL,
  email_org VARCHAR(100) NOT NULL,
  site_org VARCHAR(120) NULL,
  missao_org VARCHAR(200) NOT NULL,
  categoria_org varchar(50) NOT NULL,
  dataCad DATE NOT NULL,
  endereco_cep VARCHAR(8) NOT NULL,
  id_conta INT,
  id_post INT,
  PRIMARY KEY (id_org),
  FOREIGN KEY (endereco_cep) REFERENCES endereco(cep),
  FOREIGN key (id_post) REFERENCES postagem(id_post),
  FOREIGN KEY (id_conta) references conta_bancaria(id_cb)
);

CREATE TABLE IF NOT EXISTS doador(
email varchar NOT NULL PRIMARY KEY,
nome varchar(35) NOT NULL,
sobrenome varchar(70) NOT NULL,
telefone varchar(14) NOT NULL
);

