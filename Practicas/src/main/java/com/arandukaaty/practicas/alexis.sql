CREATE TABLE public.usuarios (
	id serial NOT NULL,
	nombre varchar,
	usuario varchar,
	clave varchar,
	CONSTRAINT usuarios_pk PRIMARY KEY (id)
);