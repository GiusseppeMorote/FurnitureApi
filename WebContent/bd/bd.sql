drop database furniture;
create database furniture;
use furniture;

create table categoria(
    idCategoria int auto_increment,
    codigo varchar(10) not null,
    nombre varchar(50) not null,
    estado bit not null,
    primary key (idCategoria)
);

insert into categoria (codigo,nombre,estado) values ('01','Mesas',1);
insert into categoria (codigo,nombre,estado) values ('02','Roperos',1);
insert into categoria (codigo,nombre,estado) values ('03','Sillas',1);
insert into categoria (codigo,nombre,estado) values ('04','Sofas',1);

create table tipo(
    idTipo int auto_increment,
    codigo varchar(10) not null,
    nombre varchar(50) not null,
    idCategoria int not null,
    estado bit not null,
    primary key (idTipo),
    
    foreign key (idCategoria) references categoria(idCategoria)
);

insert into tipo (codigo,nombre,idCategoria,estado) values ('0101','Plegable',1,1);
insert into tipo (codigo,nombre,idCategoria,estado) values ('0102','Comedor',1,1);

insert into tipo (codigo,nombre,idCategoria,estado) values ('0201','Integrados a la pared',2,1);
insert into tipo (codigo,nombre,idCategoria,estado) values ('0202','Exento',2,1);
insert into tipo (codigo,nombre,idCategoria,estado) values ('0203','Cabina',2,1);
insert into tipo (codigo,nombre,idCategoria,estado) values ('0204','Vestidor',2,1);

insert into tipo (codigo,nombre,idCategoria,estado) values ('0301','Oficina',3,1);
insert into tipo (codigo,nombre,idCategoria,estado) values ('0302','Ambiente',3,1);
insert into tipo (codigo,nombre,idCategoria,estado) values ('0303','Comedor',3,0);

insert into tipo (codigo,nombre,idCategoria,estado) values ('0401','Puff',4,1);
insert into tipo (codigo,nombre,idCategoria,estado) values ('0402','Sillon',4,1);
insert into tipo (codigo,nombre,idCategoria,estado) values ('0403','Sofa cama',4,1);



create table marca(
    idMarca int auto_increment,
    codigo varchar(10) not null,
    nombre varchar(50) not null,
    estado bit not null,
    primary key (idMarca)
);

insert into marca (codigo,nombre,estado) values ('MAR001','Sin marca',1);
insert into marca (codigo,nombre,estado) values ('MAR002','Zynamode',1);
insert into marca (codigo,nombre,estado) values ('MAR003','Artek',1);
insert into marca (codigo,nombre,estado) values ('MAR004','Tecada',1);
insert into marca (codigo,nombre,estado) values ('MAR005','Ikea',1);
insert into marca (codigo,nombre,estado) values ('MAR006','Belatrix',1);

create table material(
    idMaterial int auto_increment,
    codigo varchar(10) not null,
    nombre varchar(50) not null,
    estado bit not null,
    primary key (idMaterial)
);

insert into material (codigo,nombre,estado) values('MAT001','Hierro',1);
insert into material (codigo,nombre,estado) values('MAT002','Acero',1);
insert into material (codigo,nombre,estado) values('MAT003','Aluminio',1);
insert into material (codigo,nombre,estado) values('MAT004','Madera',1);
insert into material (codigo,nombre,estado) values('MAT005','Melamine',1);
insert into material (codigo,nombre,estado) values('MAT006','Plástico',1);
insert into material (codigo,nombre,estado) values('MAT007','Fibra sintética',1);
insert into material (codigo,nombre,estado) values('MAT008','Mdf',1);
insert into material (codigo,nombre,estado) values('MAT009','Metal',1);
insert into material (codigo,nombre,estado) values('MAT010','Madera y metal',1);

create table producto(
    idProducto int auto_increment,
    codigo varchar(10) not null,
    nombre varchar(100) not null,
    imagen varchar(100) not null,
    precio decimal(10,2) not null,
    descuento decimal(10,2) not null,
    stockMinimo int not null,
    stockActual int not null,
    garantia int not null, -- En meses
    recomendacion varchar(255) not null,
    fechaRegistro datetime not null,
    color varchar(50) not null,

    idTipo int not null,
    idMarca int not null,
    idMaterial int not null,

    alto decimal(10,2) not null,
    ancho decimal(10,2) not null,
    peso decimal(10,2) not null,

    cantidadCajas int null,
    numeroPuertas int null,
    cantidadPersonas int null,
    resistencia decimal(10,2) null,
    apoyaBrazos bit null,
    reclinable bit null,
    espesor decimal(10,2) null,

    estado bit not null,
    
    primary key (idProducto),
    foreign key (idTipo) references tipo(idTipo),
    foreign key (idMarca) references marca(idMarca),
    foreign key (idMaterial) references material(idMaterial)
);

select * from producto;

insert into producto(codigo,nombre,imagen,precio,descuento,stockMinimo,stockActual,garantia,recomendacion,fechaRegistro,color,
idTipo,idMarca,idMaterial,alto,ancho,peso,
cantidadCajas,numeroPuertas,cantidadPersonas,resistencia,apoyaBrazos,reclinable,espesor,estado) values
('0101001','Mesa plegable','https://s3.amazonaws.com/furniture1/imagenes/0101001.jpg',359.00,0.00,15,25,18,'Recomendado para exteriores',now(),'Marron',
1,1,1,50.50,112.00,32.5,
0,0,4,0,0,0,4,1);

insert into producto(codigo,nombre,imagen,precio,descuento,stockMinimo,stockActual,garantia,recomendacion,fechaRegistro,color,
idTipo,idMarca,idMaterial,alto,ancho,peso,
cantidadCajas,numeroPuertas,cantidadPersonas,resistencia,apoyaBrazos,reclinable,espesor,estado) values
('0102001','Mesa comedor','https://s3.amazonaws.com/furniture1/imagenes/0102001.jpg',210.00,0.00,40,75,18,'Elegante para entornos de con ambiente clásico',now(),'Gris sauca',
2,4,4,49.15,85.00,24.60,
0,0,4,0,0,0,3.5,1);

insert into producto(codigo,nombre,imagen,precio,descuento,stockMinimo,stockActual,garantia,recomendacion,fechaRegistro,color,
idTipo,idMarca,idMaterial,alto,ancho,peso,
cantidadCajas,numeroPuertas,cantidadPersonas,resistencia,apoyaBrazos,reclinable,espesor,estado) values
('0201001','Ropero integrado a la pared','https://s3.amazonaws.com/furniture1/imagenes/0201001.jpg',750,0.00,9,12,24,'Moderno para cuartos con luz natural, combina perfectamente con el color de la naturaleza',now(),'Negro',
3,5,5,125.00,78.50,49.30,
6,3,0,0,0,0,0,1);

select a.idTipo, a.codigo, a.nombre, a.idCategoria, b.codigo, b.nombre, b.estado, a.estado
from tipo a inner join categoria b 
on a.idCategoria = b.idCategoria;


select 
a.idProducto, a.codigo, a.nombre,
a.imagen, a.precio, a.descuento, a.stockMinimo,
a.stockActual, a.garantia, a.recomendacion,
a.fechaRegistro, a.color, a.idTipo, b.codigo, b.nombre, b.estado,
a.idMarca, c.codigo, c.nombre, c.estado,
a.idMaterial, d.codigo, d.nombre, d.estado, a.alto, a.ancho, a.peso,
a.cantidadCajas, a.numeroPuertas, a.cantidadPersonas,
a.resistencia, a.apoyaBrazos, a.reclinable, a.espesor,
a.estado
from producto a inner join tipo b
on a.idTipo=b.idTipo inner join marca c 
on a.idMarca=c.idMarca inner join material d
on a.idMaterial=d.idMaterial ;

create table venta(
    idVenta int auto_increment,
    codigoVenta varchar(10) not null,
    idUsuario int not null,
    fechaVenta datetime not null,
    estadoVenta bit not null,
    primary key (idVenta)
); 

create table detalle_venta(
    idDetalleVenta int auto_increment,
    idVenta int not null,
    idProducto int not null,
    cantidad int not null,
    precioUnitario decimal not null,
    descuento decimal not null,
    primary key(idDetalleVenta, idVenta)
);

create table usuario(
    idUsuario int auto_increment,
    codigoUsuario varchar(10) not null,
    emailUsuario varchar(70) not null,
    claveUsuario varchar(40) not null,
    fechaRegistroUsuario datetime not null,
    tipoUsuario char(1) not null,
    nombreUsuario varchar(70) not null,
    apellidoUsuario varchar(100) not null,
    dniUsuario char(8) not null,
    fechaNacimientoUsuario datetime not null,
    telefonoUsuario varchar(16) not null,
    direccionUsuario varchar(100) not null,
    imagenUsuario varchar(20) not null,
    estadoUsuario bit not null,
    primary key (idUsuario)
    
);