CREATE DATABASE IF NOT EXISTS empleados_db;
USE empleados_db;

CREATE TABLE empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE,
    cargo_id INT,
    FOREIGN KEY (cargo_id) REFERENCES cargos(id)
);

CREATE TABLE cargos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255)
);

CREATE TABLE salarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    empleado_id INT,
    monto DECIMAL(10,2) NOT NULL,
    fecha_pago DATE NOT NULL,
    FOREIGN KEY (empleado_id) REFERENCES empleados(id)
);

