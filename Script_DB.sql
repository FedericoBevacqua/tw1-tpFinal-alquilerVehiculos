/*Selects*/

SELECT * FROM db.auto;

SELECT * FROM db.reserva;

SELECT * FROM db.entrega;

SELECT * FROM db.devolucion;

SELECT * FROM db.usuario;

/*Inserts*/

/*Tabla: Usuarios*/
INSERT INTO `db`.`usuario` (`id`, `email`, `password`, `rol`) 
VALUES ('1', 'admin@admin', '123456', 'admin'),
('2', 'admin@admin.com', '123456', 'admin');

/*Tabla: Auto*/
INSERT INTO `db`.`auto` (`id`, `marca`, `nombre`, `precio`) 
VALUES ('1', 'Ford', 'Fiesta', '1800'),
('2', 'Chevrolet', 'Camaro', '2800'),
('3', 'Mitsubishi', 'Eclipse', '2500'),
('4', 'Toyota', 'Celica', '1200');