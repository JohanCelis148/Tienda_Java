create database tienda;

use tienda;

create table personas(
	id int primary key auto_increment,
    nombre varchar(100),
    dni int,
    edad int,
    genero varchar(50)
);


create table productos(
	id int primary key auto_increment,
    nombre varchar(100),
    precio int
);

create table Compra(
	id int primary key auto_increment,
    persona_id int,
    CONSTRAINT fk_persona_id FOREIGN KEY (persona_id) REFERENCES  personas(id),
    cantidad int,
    producto_id int,
    constraint fk_producto_id foreign key (producto_id) references productos(id),
    valorpagar int
    
);
