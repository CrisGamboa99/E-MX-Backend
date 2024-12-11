-- -----------------------------------------------------
-- Insertar categorias
-- -----------------------------------------------------
INSERT INTO `raices`.`Categorias` (`id_categorias`, `nombre_categoria`) 
VALUES
(1, 'Miel'),
(2, 'Bolsas'),
(3, 'Café'),
(4, 'Joyeria'),
(5, 'Otros');
-- -----------------------------------------------------
-- Insertar clientes
-- -----------------------------------------------------

INSERT INTO `raices`.`Clientes` (`nombre`,  `apellido`,  `correo`, `contraseña` ,`telefono`, `direccion`, `ciudad`,`estado`,`codigo_postal`,`tipo_usuario` ) 
VALUES 
('Amaranta','Cruz', 'amy55@icloud.com','contra123', '7892787655', 'Reforma', 'cdmx','Ciudad de Mexico','060530', 'cliente'),
('Xamitl','Hernandez', 'xamkirito@yahoo.com', 'bleachshippuden','5610987654','AVe lopez 34', 'Tlanepantla', 'Estado Mexico','879358','cliente'),
('Abigail','Villeda', 'abigailfloresvilleda@gmail.com', '1234596qFa','7773842707','San Mateo Xalpa', 'Xochimilco', 'Ciudad de México','982498','cliente'),
('Cristian','Gamboa', 'cris.gamboa.99@gmail.com', '12345678','5545993789','San Pedro Barrientos', 'Tlanepantla de Baz', 'Estado Mexico','987526','cliente'),
('Cristal','Ramirez', 'cristal.loreto.rn@gmail.com', '12345678','7122349014','Plazas de Aragon', 'Nezahualcoyotl', 'Estado Mexico','156445','Cliente');
-- -----------------------------------------------------
-- Insertar artesano
-- -----------------------------------------------------
INSERT INTO `raices`.`Artesano` (`nombre`, `apellido`, `empresa`, `correo`, `password`, `direccion`, `telefono`, `codigo_postal`,`estado`,`tipo_usuario`) 
VALUES
('Magaly', 'Ramos', 'Melipona', 'xaxiry.magaly@gmail.com', 'Xamagora97',' Los Heroes Tecámac, 6ta seccion', '5570685289','06030','edo mexico','artesano'),
('Alex', 'Sibaja', 'Empresa Alex', 'sivi118468@gmail.com', '123804958','Qro Queretaro' ,'5570685289','9879','Queretaro','artesano'),
('Jazmin','Bartolo','Artesa', 'artesa@gmail.com', 'aguabendita', 'Pachuca Hidalgo','7721185678', '42000','hidalgo','artesano'),
('Xamitl', 'Hernandez','Xami inc', ' ollin.h@yahoo.com','bleachshippuden1','av Malinalco 12',' 5678905432',' 54740','edo mexico','artesano'),
('Fabio', 'Sakimoto','Oayama', ' ofabio.sr@yahoo.com','pass123','av los reyes 33',' 9739832742','9999','oaxaca','artesano');
-- -----------------------------------------------------
-- Insertar producto 
-- -----------------------------------------------------

INSERT INTO `raices`.`Producto` (`id_producto`, `Imagen_url`, `nombre`, `precio`, `stock`, `Categorias_idCategorias`, `status`, `descripcion`,`Artesano_idArtesano`) 
VALUES
(1,'https://raw.githubusercontent.com/Xamagora/Catalogo/refs/heads/main/Catalogo%20de%20la%20pagina/Bolsas/bolsa.webp','Bolsa Henequen',1500, 2, 2,"Destacado","Originaria de Yucatán", 1),
(2,'https://raw.githubusercontent.com/Xamagora/Catalogo/refs/heads/main/Catalogo%20de%20la%20pagina/Bolsas/bolsa1.webp','Bolsa Mostaza',550, 50, 2,"Destacado","Originaria de Yucatán", 1),
(3,'https://raw.githubusercontent.com/Xamagora/Catalogo/refs/heads/main/Catalogo%20de%20la%20pagina/Caf%C3%A9/cafecien.webp','Café Orgánico',850, 4, 3,"Destacado","Originario de Chiapas",2 ),
(4,'https://raw.githubusercontent.com/Xamagora/Catalogo/refs/heads/main/Catalogo%20de%20la%20pagina/Joyer%C3%ADa/plata.webp','Jaguar de Plata',1650, 8, 4,"Promociones","Originaria de Taxco", 3),
(5,'https://raw.githubusercontent.com/Xamagora/Catalogo/refs/heads/main/Catalogo%20de%20la%20pagina/Miel/miel1.webp','Miel de Manglar',1150, 5, 1,"Destacado","Originaria de Campeche", 4),
(6,'https://raw.githubusercontent.com/Xamagora/Catalogo/refs/heads/main/Catalogo%20de%20la%20pagina/Caf%C3%A9/cafecin.webp','Café de Altura', 999, 6, 3,"Nuevo","Originario de Oaxaca", 3),
(7,'https://raw.githubusercontent.com/Xamagora/Catalogo/refs/heads/main/Catalogo%20de%20la%20pagina/Miel/miel.webp','Paquete de Miel', 1700, 5, 1,"Nuevo","Originaria de Yucatán", 1),
(8,'https://raw.githubusercontent.com/Xamagora/Catalogo/refs/heads/main/Catalogo%20de%20la%20pagina/Joyer%C3%ADa/sol.webp','Sol de Bronce', 2100, 9, 4,"Destacado","Originario de Guerrero", 4);
-- -----------------------------------------------------
-- Insertar pedido
-- -----------------------------------------------------
  
  INSERT INTO `raices`.`Pedido`(`total` ,`descripcion` ,`estado_pedido` ,`fecha` ,`Clientes_idClientes` )
  VALUES
  ('567.98','bolsa henequen','Enviado','2024-12-10','3'),
  ('980.32','Brazalete Copper','Enviado','2024-10-10','1'),
  ('2313.78','Pulsera plata','Enviado','2024-09-10','2'),
  ('828.22','Cafe oaxaca','Enviado','2024-12-08','4'),
   ('888.22','Pulsera Oro','Enviado','2024-08-08','4');

  