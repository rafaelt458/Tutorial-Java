CREATE TABLE archivos_lob (
    id SERIAL PRIMARY KEY,
    nombre varchar(200),
    archivo_oid OID
);

SELECT * 
	FROM pg_largeobject_metadata;
