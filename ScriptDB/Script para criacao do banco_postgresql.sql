--SCRIPT PARA CRIACAO DO BANCO DE DADOS EDABES

--SCRIPT PARA CRIACAO DA TABELA USUARIO = OK
CREATE TABLE USUARIO (
	ID_USUARIO NUMERIC PRIMARY KEY,
	NOME VARCHAR(30) NOT NULL,
	SOBRENOME VARCHAR(30) NOT NULL,
	EMAIL VARCHAR(50) NOT NULL UNIQUE,
	ANO_NASCIMENTO NUMERIC(4),
	CIDADE VARCHAR(30),
	PAIS VARCHAR(30),
	GENERO VARCHAR(30),
	SENHA VARCHAR(50) NOT NULL
);

--SCRIPT PARA CRIACAO DE SEQUENCE DA TABELA USUARIO
CREATE SEQUENCE USUARIO_SEQ
	START WITH     1
	INCREMENT BY   1
	NO CYCLE;
 
 --SCRIPT PARA CRIACAO DA TABELA TIPO_MAPA
CREATE TABLE TIPO_MAPA (
	ID_TIPO NUMERIC PRIMARY KEY,
    NOME_TIPO VARCHAR(10) NOT NULL UNIQUE
);

--SCRIPT PARA CRIACAO DA SEQUENCE DA TABELA TIPO_MAPA
CREATE SEQUENCE TIPO_MAPA_SEQ
	START WITH     1
	INCREMENT BY   1
	NO CYCLE;

--SCRIPT PARA CRIACAO DA TABELA MAPA
CREATE TABLE MAPA (
	ID_MAPA NUMERIC PRIMARY KEY,
	NOME_MAPA VARCHAR(100) NOT NULL UNIQUE,
	DESCRICAO VARCHAR(90) NOT NULL,
	OBJETIVO VARCHAR(80) NOT NULL,
	TIPO_MAPA NUMERIC NOT NULL,
	CRIADOR NUMERIC NOT NULL,
	NOME_CRIADOR VARCHAR(30) NOT NULL,
	DT_CRIACAO DATE NOT NULL,
	DT_ALTERACAO DATE,
	UNIDADE_MEDIDA VARCHAR(30) NOT NULL
);

--SCRIPT PARA CRIACAO DAS FKS DA TABELA MAPA
ALTER TABLE MAPA ADD CONSTRAINT MAPA_TIPO_MAPA_FK
    FOREIGN KEY (TIPO_MAPA)
    REFERENCES TIPO_MAPA(ID_TIPO);
    
ALTER TABLE MAPA ADD CONSTRAINT MAPA_USUARIO_FK
    FOREIGN KEY (CRIADOR)
    REFERENCES USUARIO(ID_USUARIO);
	
--SCRIPT PARA CRIACAO DA SEQUENCE DA TABELA MAPA	
CREATE SEQUENCE MAPA_SEQ
	START WITH     1
	INCREMENT BY   1
	MINVALUE 1
	MAXVALUE 99999
	NO CYCLE;
	
--SCRIPT PARA CRIACAO DA TABLEA MAPA_NIVEL
CREATE TABLE  MAPA_NIVEL (
	ID_MAPA_NIVEL NUMERIC PRIMARY KEY,
	ID_MAPA NUMERIC NOT NULL,
	ANDAR NUMERIC(4) NOT NULL
);	
	
--SCRIPT PARA CRICAO DA FK DA TABELA MAPA_NIVEL
ALTER TABLE MAPA_NIVEL ADD CONSTRAINT MAPA_NIVEL_MAPA_FK
    FOREIGN KEY (ID_MAPA)
    REFERENCES MAPA(ID_MAPA);	
	
--CRIACAO DA SEQUENCE DA TABELA MAPA_NIVEL	
CREATE SEQUENCE MAPA_NIVEL_SEQ
	START WITH     1
	INCREMENT BY   1
	NO CYCLE;
 
 --SCRIPT PARA CRIACAO DA TABELA CATEGORIA
CREATE TABLE CATEGORIA (
	ID_CATEGORIA NUMERIC NOT NULL PRIMARY KEY,
	TITULO VARCHAR (30)
);

CREATE SEQUENCE CATEGORIA_SEQ
	START WITH     1
	INCREMENT BY   1
	NO CYCLE;
 
 --SCRIPT PARA CRIACAO DA TABELA SUBCATEGORIA
CREATE TABLE SUBCATEGORIA (
	ID_SUBCATEGORIA NUMERIC PRIMARY KEY,
	ID_CATEGORIA NUMERIC NOT NULL,
	TITULO VARCHAR(30) NOT NULL
);

--SCRIPT PARA CRIACAO DA FKS DA TABELA SUBCATEGORIA
ALTER TABLE SUBCATEGORIA ADD CONSTRAINT SUBCATEGORIA_CATEGORIA_FK
    FOREIGN KEY (ID_CATEGORIA)
    REFERENCES CATEGORIA(ID_CATEGORIA);
	
--SCRIPT PARA CRIACAO DA SEQUENCE DA TABELA SUBCATEGORIA
CREATE SEQUENCE SUBCATEGORIA_SEQ
	START WITH     1
	INCREMENT BY   1
	NO CYCLE;
	
--SCRIPT PARA CRIACAO DA TABELA OBJETO
CREATE TABLE OBJETO (
	ID_OBJETO NUMERIC PRIMARY KEY,
	ALTURA NUMERIC(4) NOT NULL,
	LARGURA NUMERIC(4) NOT NULL,
	DESCRICAO VARCHAR(90) NOT NULL,
	IMAGEM_MENU VARCHAR(90) NOT NULL,
	IMAGEM_MAPA VARCHAR(90) NOT NULL,
	NOME VARCHAR(30) NOT NULL,
	SUBCATEGORIA NUMERIC NOT NULL
);	

--SCRIPT PARA CRIACAO DA FK DA TABELA OBJETO
ALTER TABLE OBJETO ADD CONSTRAINT OBJETO_SUBCATEGORIA_FK
    FOREIGN KEY (SUBCATEGORIA)
	REFERENCES SUBCATEGORIA(ID_SUBCATEGORIA);

--SCRIPT PARA CRIACAO DA SEQUENCE DA TABELA OBJETO
CREATE SEQUENCE OBJETO_SEQ
	START WITH     1
	INCREMENT BY   1
	NO CYCLE;

--SCRIPT DE CRIACAO DA TABELA MAPA_OBJETO
CREATE TABLE MAPA_OBJETO(
	ID_MAPA_OBJETO NUMERIC PRIMARY KEY,
	ID_MAPA NUMERIC NOT NULL,
	ID_OBJETO NUMERIC NOT NULL,
	PROFUNDIDADE NUMERIC(4) NOT NULL,
	AUDIO_DESCRICAO VARCHAR(90) NULL,
	COORDENADA_X NUMERIC NOT NULL,
	COORDENADA_Y NUMERIC NOT NULL,
	LARGURA NUMERIC NOT NULL,
	ALTURA NUMERIC NOT NULL
);

--SCRIPT DE CRIACAO DAS FKS DA TABELA MAPA_OBJETO
ALTER TABLE MAPA_OBJETO ADD CONSTRAINT MAPA_OBJETO_MAPA_FK
    FOREIGN KEY (ID_MAPA)
    REFERENCES MAPA(ID_MAPA);
    
ALTER TABLE MAPA_OBJETO ADD CONSTRAINT MAPA_OBJETO_OBJETO_FK
    FOREIGN KEY (ID_OBJETO)
    REFERENCES OBJETO(ID_OBJETO);
	
--SCRIPT DE CRIACAO DA SEQUENCE DA TABELA MAPA_OBJETO
CREATE SEQUENCE MAPA_OBJETO_SEQ
	START WITH     1
	INCREMENT BY   1
	NO CYCLE;

--SCRIPT PARA CRIACAO DA TABELA MAPA_IMPORTADO
CREATE TABLE MAPA_IMPORTADO (
	ID_MAPA NUMERIC PRIMARY KEY,
	NOME_MAPA VARCHAR(30) NOT NULL UNIQUE,
	DESCRICAO VARCHAR(90) NOT NULL,
	OBJETIVO VARCHAR(80) NOT NULL,
	TIPO_MAPA NUMERIC NOT NULL,
	CRIADOR NUMERIC NOT NULL,
	NOME_CRIADOR VARCHAR(30) NOT NULL,
	DT_CRIACAO DATE NOT NULL,
	DT_ALTERACAO DATE,
	UNIDADE_MEDIDA VARCHAR(30) NOT NULL,
	IMPORTADO_BY NUMERIC NOT NULL
);

--SCRIPT PARA CRIACAO DAS FKS DA TABELA MAPA_EXPORTADO
ALTER TABLE MAPA_IMPORTADO ADD CONSTRAINT MAPA_IMPORTADO_TIPO_MAPA_FK
    FOREIGN KEY (TIPO_MAPA)
    REFERENCES TIPO_MAPA(ID_TIPO);
    
ALTER TABLE MAPA_IMPORTADO ADD CONSTRAINT MAPA_IMPORTADO_USUARIO_FK
    FOREIGN KEY (CRIADOR)
    REFERENCES USUARIO(ID_USUARIO);

--SCRIPT PARA CRIACAO DA SEQUENCE DA TABELA MAPA_IMPORTADO
CREATE SEQUENCE MAPA_IMPORTADO_SEQ
	START WITH     1
	INCREMENT BY   1
	NO CYCLE;	
	
--SCRIPT DE CRIACAO DA TABELA MAPA_OBJETO_IMPORTADO
CREATE TABLE MAPA_OBJETO_IMPORTADO (
	ID_MAPA_OBJETO NUMERIC PRIMARY KEY,
	ID_MAPA NUMERIC NOT NULL,
	ID_OBJETO NUMERIC NOT NULL,
	PROFUNDIDADE NUMERIC(4) NOT NULL,
	AUDIO_DESCRICAO VARCHAR(90) NULL,
	COORDENADA_X NUMERIC NOT NULL,
	COORDENADA_Y NUMERIC NOT NULL,
	LARGURA NUMERIC NOT NULL,
	ALTURA NUMERIC NOT NULL
);

--SCRIPT DE CRIACAO DAS FKS DA TABELA MAPA_OBJETO_IMPORTADO
ALTER TABLE MAPA_OBJETO_IMPORTADO ADD CONSTRAINT MAPA_OBJETO_MAPA_IMPOR_FK
    FOREIGN KEY (ID_MAPA)
    REFERENCES MAPA_IMPORTADO(ID_MAPA);
    
ALTER TABLE MAPA_OBJETO_IMPORTADO ADD CONSTRAINT MAPA_OBJETO_IMPORT_OBJETO_FK
    FOREIGN KEY (ID_OBJETO)
    REFERENCES OBJETO(ID_OBJETO);
	   
--SCRIPT PARA CRIACAO DA SEQUENCE DA TABELA MAPA_OBJETO_EXPORTADO
CREATE SEQUENCE MAPA_OBJETO_IMPORTADO_SEQ
	START WITH     1
	INCREMENT BY   1
	MINVALUE 1
	MAXVALUE 99999
	NO CYCLE;
	
--SCRIPT PARA CRIACAO DA TABELA MAPA_EXPORTADO
CREATE TABLE MAPA_EXPORTADO (
	ID_MAPA NUMERIC PRIMARY KEY,
	NOME_MAPA VARCHAR(30) NOT NULL UNIQUE,
	DESCRICAO VARCHAR(90) NOT NULL,
	OBJETIVO VARCHAR(80) NOT NULL,
	TIPO_MAPA NUMERIC NOT NULL,
	CRIADOR NUMERIC NOT NULL,
	NOME_CRIADOR VARCHAR(30) NOT NULL,
	DT_CRIACAO DATE NOT NULL,
	DT_ALTERACAO DATE,
	UNIDADE_MEDIDA VARCHAR(30) NOT NULL
);

--SCRIPT PARA CRIACAO DAS FKS DA TABELA MAPA_EXPORTADO
ALTER TABLE MAPA_EXPORTADO ADD CONSTRAINT MAPA_EXPORTADO_TIPO_MAPA_FK
    FOREIGN KEY (TIPO_MAPA)
    REFERENCES TIPO_MAPA(ID_TIPO);
    
ALTER TABLE MAPA_EXPORTADO ADD CONSTRAINT MAPA_EXPORTADO_USUARIO_FK
    FOREIGN KEY (CRIADOR)
    REFERENCES USUARIO(ID_USUARIO);
    
--SCRIPT PARA CRIACAO DA SEQUENCE DA TABELA MAPA_EXPORTADO
CREATE SEQUENCE MAPA_EXPORTADO_SEQ
	START WITH     1
	INCREMENT BY   1
	MINVALUE 1
	MAXVALUE 99999
	NO CYCLE;	

--SCRIPT DE CRIACAO DA TABELA MAPA_OBJETO_EXPORTADO
CREATE TABLE MAPA_OBJETO_EXPORTADO(
	ID_MAPA_OBJETO NUMERIC PRIMARY KEY,
	ID_MAPA NUMERIC NOT NULL,
	ID_OBJETO NUMERIC NOT NULL,
	PROFUNDIDADE NUMERIC(4) NOT NULL,
	AUDIO_DESCRICAO VARCHAR(90) NULL,
	COORDENADA_X NUMERIC NOT NULL,
	COORDENADA_Y NUMERIC NOT NULL,
	LARGURA NUMERIC NOT NULL,
	ALTURA NUMERIC NOT NULL
);

--SCRIPT DE CRIACAO DAS FKS DA TABELA MAPA_OBJETO_EXPORTADO
ALTER TABLE MAPA_OBJETO_EXPORTADO ADD CONSTRAINT MAPA_OBJETO_EXPORTADO_ME_FK
    FOREIGN KEY (ID_MAPA)
    REFERENCES MAPA_EXPORTADO(ID_MAPA);

--SCRIPT DE CRIACAO DAS FKS DA TABELA MAPA_OBJETO
/*ALTER TABLE MAPA_OBJETO ADD CONSTRAINT MAPA_OBJETO_MAPA_EXPORTADO_FK
    FOREIGN KEY (ID_MAPA)
    REFERENCES MAPA_EXPORTADO(ID_MAPA);
   
ALTER TABLE MAPA_OBJETO ADD CONSTRAINT MAPA_OBJETO_OBJETO_FK
    FOREIGN KEY (ID_OBJETO)
    REFERENCES OBJETO(ID_OBJETO);
*/	   
--SCRIPT PARA CRIACAO DA SEQUENCE DA TABELA MAPA_OBJETO_EXPORTADO
CREATE SEQUENCE MAPA_OBJETO_EXPORTADO_SEQ
	START WITH     1
	INCREMENT BY   1
	MINVALUE 1
	MAXVALUE 99999
	NO CYCLE;

------------------------------------------------------------------------------------------------------------------------------------------------

/*

ALTERAÇÕES FEITAS PARA O MÓDULO DE NAVEGAÇÃO

*/

--SCRIPT DE CRIACAO DA TABELA UPLOAD_AUDIOS
CREATE TABLE UPLOAD_ARQUIVO_AUDIOS(
	ID_ARQUIVO_AUDIO NUMERIC PRIMARY KEY,
	ARQUIVO VARCHAR(200) NOT NULL,
	DESCRICAO VARCHAR(200) NULL
);

CREATE SEQUENCE UPLOAD_ARQUIVO_AUDIOS_SEQ
	START WITH     1
	INCREMENT BY   1
	NO CYCLE;	


--Nova coluna ID_ARQUIVO_AUDIO. Irá armazenar id para a tabela UPLOAD_ARQUIVO_AUDIOS
ALTER TABLE MAPA_OBJETO
 add COLUMN ID_ARQUIVO_AUDIO NUMERIC null;

--Nova coluna ID_ARQUIVO_AUDIO. Irá armazenar id para a tabela UPLOAD_ARQUIVO_AUDIOS
ALTER TABLE MAPA_OBJETO_EXPORTADO
add COLUMN ID_ARQUIVO_AUDIO NUMERIC null;

--Nova coluna ID_ARQUIVO_AUDIO. Irá armazenar id para a tabela UPLOAD_ARQUIVO_AUDIOS
ALTER TABLE MAPA_OBJETO_IMPORTADO
add COLUMN ID_ARQUIVO_AUDIO NUMERIC null;


--Criando a referência da colunca ID_ARQUIVO_AUDIO com a tabela UPLOAD_ARQUIVO_AUDIOS
ALTER TABLE MAPA_OBJETO ADD CONSTRAINT MAPA_OBJETO_ARQUIVO_AUDIO
    FOREIGN KEY (ID_ARQUIVO_AUDIO)
    REFERENCES UPLOAD_ARQUIVO_AUDIOS(ID_ARQUIVO_AUDIO);

--Criando a referência da colunca ID_ARQUIVO_AUDIO com a tabela UPLOAD_ARQUIVO_AUDIOS
ALTER TABLE MAPA_OBJETO_EXPORTADO ADD CONSTRAINT MAPA_OBJETO_EXPORTADO_ARQUIVO_AUDIO
    FOREIGN KEY (ID_ARQUIVO_AUDIO)
    REFERENCES UPLOAD_ARQUIVO_AUDIOS(ID_ARQUIVO_AUDIO);

--Criando a referência da colunca ID_ARQUIVO_AUDIO com a tabela UPLOAD_ARQUIVO_AUDIOS
ALTER TABLE MAPA_OBJETO_IMPORTADO ADD CONSTRAINT MAPA_OBJETO_IMPORTADO_ARQUIVO_AUDIO
    FOREIGN KEY (ID_ARQUIVO_AUDIO)
    REFERENCES UPLOAD_ARQUIVO_AUDIOS(ID_ARQUIVO_AUDIO);

--Adicionado a colunca ANDAR, que não estava presente anteriormente
ALTER TABLE MAPA_EXPORTADO ADD COLUMN andar character varying(255);

--Aumentando o tamanho do coluna NOME_MAPA da tabela MAPA
ALTER TABLE MAPA ALTER COLUMN NOME_MAPA TYPE VARCHAR(100);

--Aumentando o tamanho do coluna NOME_MAPA da tabela MAPA
ALTER TABLE MAPA_EXPORTADO ALTER COLUMN NOME_MAPA TYPE VARCHAR(100);

--A coluna NOME_MAPA deve ser única
ALTER TABLE MAPA ADD UNIQUE (nome_mapa);

--Adicionando a coluna NIVEL na tabela OBJETO. Se nivel = 0, o objeto é do tipo piso. Se o nivel = 1, quer dizer que é um objeto bloqueante e  
--caso o nive = -1, o objeto leva algum tipo de perigo ao jogador.
--Caso a tabela OBJETO já tenha sido preenchida.
TRUNCATE MAPA_OBJETO_EXPORTADO, MAPA_OBJETO_IMPORTADO, MAPA_OBJETO, OBJETO

ALTER TABLE OBJETO ADD COLUMN nivel NUMERIC(2) NOT NULL;

--Caso tenha criado o banco anteriormente, rodar essas queries
ALTER TABLE public.upload_arquivo_audios ALTER COLUMN arquivo TYPE VARCHAR(200);
ALTER TABLE public.upload_arquivo_audios ALTER COLUMN descricao TYPE VARCHAR(200);

--SCRIPT DE CRIACAO DA TABELA HISTORICO_NAVEGACAO
CREATE TABLE HISTORICO_NAVEGACAO(
	ID_HISTORICO_NAVEGACAO NUMERIC PRIMARY KEY,
	LOG VARCHAR(10000) NULL,
	DATA_NAVEGACAO DATE NOT NULL,
	TEMPO_NAVEGACAO VARCHAR(50) NOT NULL,
	ID_USUARIO NUMERIC NOT NULL,
	ID_MAPA NUMERIC NOT NULL
);
--SCRIPT DE CRIACAO DA FK COM USUARIO
ALTER TABLE HISTORICO_NAVEGACAO ADD CONSTRAINT HISTORICO_NAVEGACAO_USUARIO_FK
    FOREIGN KEY (ID_USUARIO)
    REFERENCES USUARIO(ID_USUARIO);
--SCRIPT DE CRIACAO DA FK COM MAPA
ALTER TABLE HISTORICO_NAVEGACAO ADD CONSTRAINT HISTORICO_NAVEGACAO_MAPA_FK
    FOREIGN KEY (ID_MAPA)
    REFERENCES MAPA(ID_MAPA);
--SCRIPT DE CRIACAO DA SEQ HISTORICO_NAVEGACAO_SEQ
CREATE SEQUENCE HISTORICO_NAVEGACAO_SEQ
	START WITH     1
	INCREMENT BY   1
	NO CYCLE;	