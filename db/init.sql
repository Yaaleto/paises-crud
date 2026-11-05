SET NAMES utf8mb4;

CREATE DATABASE IF NOT EXISTS paisesdb
  CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE paisesdb;

CREATE TABLE IF NOT EXISTS paises (
                                      id          BIGINT       NOT NULL AUTO_INCREMENT,
                                      nombre      VARCHAR(100) NOT NULL,
    codigo_iso  VARCHAR(3)   NOT NULL,
    capital     VARCHAR(100) NOT NULL,
    continente  VARCHAR(50)  NOT NULL,
    poblacion   BIGINT       NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY uk_paises_codigo_iso (codigo_iso)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO paises (nombre, codigo_iso, capital, continente, poblacion) VALUES
                                                                            ('Guatemala',  'GT', 'Ciudad de Guatemala', 'América',  17600000),
                                                                            ('México',     'MX', 'Ciudad de México',    'América', 128000000),
                                                                            ('Brasil',     'BR', 'Brasilia',            'América', 212000000),
                                                                            ('España',     'ES', 'Madrid',              'Europa',   48000000),
                                                                            ('Francia',    'FR', 'París',               'Europa',   68000000),
                                                                            ('Japón',      'JP', 'Tokio',               'Asia',    124000000),
                                                                            ('Egipto',     'EG', 'El Cairo',            'África',  112000000),
                                                                            ('Australia',  'AU', 'Canberra',            'Oceanía',  26000000);