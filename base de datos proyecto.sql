use proyectoprogramacionfinal;




create table usuario(
email varchar(200) primary key,
nombre varchar (40),
contraseña varchar (40)
);




create table persona(
dni varchar(8) primary key,
nombre varchar(40),
edad numeric(3),
apellido varchar(40),
nacionalidad varchar(40)

);


create table circuito(
numeroCircuito numeric(8) primary key,
nombre varchar(40),
lugar varchar (40),
rectas numeric (8),
curvas numeric(8),
dificultad varchar(40),
longitud numeric (8)
);
select * from circuito;
drop table circuito;

create table equipo(
nombre varchar(40) primary key,
manager varchar (40),
nombrePiloto1 varchar (40),
nombrePiloto2 varchar (40),
nombreCoche1 varchar (40),
nombreCoche2 varchar (40)
);
select * from equipo;
drop table equipo;

create table carrera(
numeroCarrera numeric(2) primary key,
numeroCircuito numeric (2),
nombreEquipo varchar (40)

);



create table coche(
nombre varchar(40) primary key,
nombreEquipo varchar (40),
color varchar (40),
caballos numeric(4),
neumaticos varchar(40),
nombrePiloto varchar(40),
maniobrabilidad numeric(4)

);
drop table coche;


create table piloto(
dni varchar(8) ,
nombre varchar(40),
edad numeric(3),
apellido varchar(40),
nacionalidad varchar(40),
id numeric(8) primary key,
nombreEquipo varchar (40),
nombreCoche varchar (40),
resistencia numeric (3),
esperiencia numeric (3),
puntos numeric(3)
);
drop table piloto;

create table mundial(
nombre varchar (40) primary key,
numeroCarrera numeric(2),
constraint foreign key (numeroCarrera) references  carrera (numeroCarrera)

);


