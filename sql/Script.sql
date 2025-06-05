drop database if exists bd_i202412137;

create database bd_i202412137;

use bd_i202412137;

create table tb_clientes (

	id_cliente int primary key,
	nom_empresa varchar(255),
	ruc varchar(255) unique,
	correo_empresa varchar(255)
	
);

create table tb_tipoAuditoria (

	id_tipoAuditoria int primary key,
	desc_tipoAuditoria varchar(50)
	
)

create table tb_especialista(
	id_especialista int primary key,
	nom_especialista varchar(100),
	dni int,
	correo_especialista varchar(255),
	especialidad varchar(255)
	
)

create table tb_certificacion(
	id_certificacion int primary key,
	id_cliente int,
	id_tipoAuditoria int,
	id_especialista int,
	fec_emision date,
	fec_vencimiento date,
	estado enum('vigente', 'expirada', 'en_revision'),
	FOREIGN KEY (id_cliente) REFERENCES tb_clientes(id_cliente),
	FOREIGN KEY (id_tipoAuditoria) REFERENCES tb_tipoAuditoria(id_tipoAuditoria),
	FOREIGN KEY (id_especialista) REFERENCES tb_especialista(id_especialista)
)	


select * from tb_tipoAuditoria

INSERT INTO tb_clientes VALUES
(1, 'TechCorp S.A.', '20123456789', 'contacto@techcorp.com'),
(2, 'Innova Group', '20234567890', 'info@innovagroup.pe'),
(3, 'GreenFuture S.R.L.', '20345678901', 'hola@greenfuture.org'),
(4, 'SecureNet SAC', '20456789012', 'admin@securenet.com'),
(5, 'Cloudify EIRL', '20567890123', 'soporte@cloudify.pe');

INSERT INTO tb_tipoAuditoria VALUES
(1, 'ISO/IEC 27001'),
(2, 'SOC 2 Tipo II'),
(3, 'PCI DSS'),
(4, 'HIPAA'),
(5, 'ISO 9001');

select * from tb_tipoAuditoria;

update tb_tipoAuditoria
set desc_tipoAuditoria = "SOC 2 Tipo II"
where id_tipoAuditoria = 5;

INSERT INTO tb_especialista VALUES
(1, 'Laura Ramírez', 44556677, 'laura.ramirez@empresa.com', 'Seguridad de la Información'),
(2, 'Carlos Gómez', 33445566, 'carlos.gomez@empresa.com', 'Auditoría Financiera'),
(3, 'Ana Torres', 22334455, 'ana.torres@empresa.com', 'Calidad y Procesos'),
(4, 'Miguel Díaz', 11223344, 'miguel.diaz@empresa.com', 'Compliance'),
(5, 'Rosa Herrera', 55667788, 'rosa.herrera@empresa.com', 'Auditoría de TI');

INSERT INTO tb_certificacion VALUES
(1, 1, 1, 1, '2024-01-10', '2025-01-10', 'vigente'),
(2, 2, 2, 2, '2023-05-15', '2024-05-15', 'expirada'),
(3, 3, 3, 3, '2024-06-01', '2025-06-01', 'en_revision'),
(4, 4, 4, 4, '2024-03-20', '2025-03-20', 'vigente'),
(5, 5, 5, 5, '2023-12-01', '2024-12-01', 'vigente');
