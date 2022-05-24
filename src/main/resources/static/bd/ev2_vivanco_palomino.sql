drop database if exists ev2_vivanco_palomino;
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
    titulo char(100) not null,
    serie char(12) not null,
    editorial char(35) not null,
    idioma varchar(45) not null,
    fecpublicacion date not null,
    cod_autor int not null,
    cod_genero int not null,
    estado int not null,
    foreign key(cod_autor) references Autor(codigo),
    foreign key(cod_genero) references Genero(codigo)
)engine= InnoDB;

insert into Autor values
(null,'Ana','Abello Verano'),
(null,'Juan Carlos','Abril'),
(null,'Jesus','Aguilar Marina');

insert into Genero values
(null, 'Romance'),
(null, 'Comedia');

insert into Libro values
('LIB001','Lo insólito en la narrativa de Juan Jacinto Muñoz Rengel','123456789','literato','español','2002-10-23', 1, 1, 1),
('LIB002','La hora de escribir','234567890','literato','español','2019-07-05', 2, 2, 1),
('LIB003','El habitante de su palabra','134562789','narrativa','español','2018-07-05', 2, 1, 1),
('LIB004','Versos perdidos en un desván','134562789','narrativa','español','2020-03-07', 3, 1, 1);