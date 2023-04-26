--usuario(cedula, contrasenia, email, nombre_completo, direccion, num-telefono)
insert into usuario values (1006336782, "12345","santiago@email.com", "Santiago","calle 19", "3165308532");
insert into usuario values (1005345234, "12345", "manuela@gmail.com", "Manuela","Calarca sur","3176409823");
insert into usuario values (1004345233, "12345", "chavarria@gmail.com", "Juan Felipe","Armenia sur","3209873249");
insert into usuario values (1003345232, "12345", "juan@gmail.com", "Juan Jose","Quimbaya calle 29","300987298");
insert into usuario values (1002345231, "12345", "jose@gmail.com", "Jose jose","Filandia carrera 11","982098328");
--moderador(cedula, contrasenia, email, nombre_completo)
insert into moderador values(1003234544, "root1", "camilo@email.com", "Camilo Evaluna");
insert into moderador values(1004234546, "root2", "carlos@email.com", "Carlos Valderrama");
insert into moderador values(1005234547, "root3", "manuel@email.com", "Manuel Turizo");
insert into moderador values(1006234548, "root4", "pablo@email.com", "Pablo Londra");
insert into moderador values(1007234549, "root5", "paulina@email.com", "Paulina Gomez");
--producto(codigo, descripcion, fecha_creacion, fecha_limite, nombre, precio, unidades, estado_codigo, codigo_producto, vendedor_cedula, codigo_moderador)
insert into producto values (1, "Audifonos en buen estado", '2023-03-03','2023-04-04',"Audifonos samsung", 15000, 2, 1,1,1006336782, 1003234544);
insert into producto values (2, "Mouse en buen estado", '2023-01-02','2023-04-03',"Mouse logitech", 120000, 2, 1,2,1006336782, 1006234548);
insert into producto values (3, "Libro en mal estado", '2023-03-29','2023-05-04',"Libro", 45000, 2,1, 1,1003345232,3, 1003234544);
insert into producto values (4, "Celular Galaxy J2 Prime 2015 seminuevo", '2023-03-17','2023-05-10',"Galaxy J2 Prime", 150000, 2, 1,4,1003345232, 1006234548);
insert into producto values (5, "Olla en buen estado", '2023-02-20','2023-04-30',"Olla imusa", 40000, 2,1, 1,1003345232, 1007234549);
--comentario(codigo, fecha_creacion, mensaje, codigo_producto, codigo_usuario)
insert into comentario values (1,'2023-04-25', "Muy bonito",2, 1006336782);
insert into comentario values (2,'2023-04-24', "Me interesa",1, 1006336782);
insert into comentario values (3,'2023-04-23', "Muy caro",1, 1006336782);
insert into comentario values (4,'2023-04-22', "Excelente",4, 1003345232);
insert into comentario values (5,'2023-04-21', "Feo",5, 1003345232);
--compra(id, codigo_usuario, fecha_compra, id_metodo_pago, valor_total)
insert into comentario values (1,1006336782, '2023-03-30',2, 15000);
insert into comentario values (1,1006336782, '2023-03-30',1, 30000);
insert into comentario values (1,1005345234, '2023-03-30',3, 40000);
insert into comentario values (1,1003345232, '2023-03-30',2, 20000);
insert into comentario values (1,1002345231, '2023-03-30',1, 100000);