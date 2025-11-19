CREATE TABLE documentos (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(200),
    contenido TEXT,
    archivo BYTEA
);