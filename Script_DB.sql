create database db;

/*Selects*/

SELECT * FROM db.auto;

SELECT * FROM db.reserva;

SELECT * FROM db.entrega;

SELECT * FROM dautob.devolucion;

SELECT * FROM db.usuario;

/*Inserts*/

/*Tabla: Usuarios*/
INSERT INTO `db`.`usuario` (`id`, `email`, `password`, `rol`) 
VALUES ('1', 'admin@admin', '123456', 'admin'),
('2', 'admin@admin.com', '123456', 'admin');

/*Tabla: Auto*/
INSERT INTO `db`.`auto` (`id`, `kilometrajeActual`, `marca`, `nombre`, `precio`, `puntajePromedio`) 
VALUES ('1', '0', 'Ford', 'Fiesta', '1800','0'),
('2', '0', 'Chevrolet', 'Camaro', '2800','0'),
('3', '0', 'Mitsubishi', 'Eclipse', '2500','0'),
('4', '0', 'Toyota', 'Celica', '1200','0');