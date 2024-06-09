create database dbgeneral;
use dbgeneral;

create table tperson(
idPerson char(36) not null,
firstName varchar(70) not null,
surName varchar(40) not null,
dni char(8) not null,
gender boolean not null,/*true => Masculino, false => Femenino*/
birthDate date not null,
createdAT datetime not null,
updateAt datetime not null,
primary key(idPerson)
)engine=innodb;

create table tcomment(
idComment char(36) not null,
idPerson char(36) not null,
description varchar(1000) not null,