CREATE TABLE usuario (
    id BIGSERIAL NOT NULL,
    login VARCHAR(60) NOT NULL,
    password VARCHAR(255) NOT NULL
);

ALTER TABLE usuario
ADD CONSTRAINT usuario_pk
PRIMARY KEY (id);

CREATE TABLE edicao (
    id BIGSERIAL NOT NULL,
    nome VARCHAR(60) NOT NULL,
    ano INTEGER NOT NULL,
    sigla_edicao VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

ALTER TABLE edicao
ADD CONSTRAINT edicao_pk
PRIMARY KEY (id);

CREATE TABLE carta (
    id BIGSERIAL NOT NULL,
    nome VARCHAR(60) NOT NULL,
    id_edicao BIGINT NOT NULL,
    id_usuario BIGINT NOT NULL,
    idioma VARCHAR(25) NOT NULL,
    foil BOOLEAN NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    quantidade_de_cartas INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

ALTER TABLE carta
ADD CONSTRAINT carta_pk
PRIMARY KEY (id);

ALTER TABLE carta
ADD CONSTRAINT carta__edicao_fk
FOREIGN KEY(id_edicao)
REFERENCES edicao(id);

ALTER TABLE carta
ADD CONSTRAINT carta__usuario_fk
FOREIGN KEY(id_usuario)
REFERENCES usuario(id);

CREATE INDEX carta_edicao_id_idx
ON carta(id_edicao);

CREATE INDEX edicao__sigla_edicao_idx on edicao(sigla_edicao)
