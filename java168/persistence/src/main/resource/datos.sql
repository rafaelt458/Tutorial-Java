CREATE TABLE Personas (
    id INT IDENTITY(1,1) PRIMARY KEY,
    nombres NVARCHAR(100) NOT NULL,
    apellidos NVARCHAR(100) NOT NULL,
    fecha_nac DATE NOT NULL,
    experiencia INT NOT NULL
);

INSERT INTO Personas (nombres, apellidos, fecha_nac, experiencia)
VALUES 
('Carlos', 'Ramírez López', '1985-03-12', 10),
('María', 'González Pérez', '1990-07-25', 7),
('Lucía', 'Martínez Díaz', '2001-11-03', 2),
('Javier', 'Santos Rubio', '1978-01-19', 20),
('Ana', 'Torres Hidalgo', '1995-05-30', 5);
