create database ev2_vivanco_palomino;

use ev2_vivanco_palomino;

create table Autor(
	codigo int primary key auto_increment,
    nombre char(35) not null,
    apellidos char(50) not null
)engine= InnoDB;

create table Genero(
	codigo int primary key auto_increment,
    nombre char(35) not null
)engine= InnoDB;

create table Libro(
	codigo char(6) primary key,
    titulo char(35) not null,
    serie char(12) not null,
    editorial char(35) not null,
    idioma varchar(45) not null,
    fecpublicacion datetime not null,
    cod_autor int not null,
    cod_genero int not null,
    estado int not null
)engine= InnoDB;