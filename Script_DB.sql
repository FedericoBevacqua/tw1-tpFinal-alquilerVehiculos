/*Selects*/

SELECT * FROM db.auto;

SELECT * FROM db.reserva;

SELECT * FROM db.entrega;

SELECT * FROM db.devolucion;

SELECT * FROM db.usuario;

/*Inserts*/

/*Tabla: Auto*/
INSERT INTO `db`.`auto` (`id`, `marca`, `nombre`, `precio`) 
VALUES ('1', 'Ford', 'Fiesta', '1800'),
('2', 'Chevrolet', 'Camaro', '2800'),
('3', 'Mitsubishi', 'Eclipse', '2500'),
('4', 'Toyota', 'Celica', '1200');