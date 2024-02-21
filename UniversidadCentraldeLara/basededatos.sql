CREATE DATABASE UniversidadCentraldeLara
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = 'libc'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
CREATE TABLE public."Decanato"
(
    id_decanato character varying(12) NOT NULL,
    nombre character varying(30) NOT NULL,
    PRIMARY KEY (id_decanato)
);

ALTER TABLE IF EXISTS public."Decanato"
    OWNER to postgres;
CREATE TABLE public."Carrera"
(
    id_carrera character varying(12) NOT NULL,
    nombre_carrera character varying(32) NOT NULL,
    decanato character varying(12),
    PRIMARY KEY (id_carrera),
    CONSTRAINT decanato FOREIGN KEY (decanato)
        REFERENCES public."Decanato" (id_decanato) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public."Carrera"
    OWNER to postgres;
CREATE TABLE public."Asignatura"
(
    id_asignatura character varying(12) NOT NULL,
    nombre_asignatura character varying(32) NOT NULL,
    carrera character varying(12),
    PRIMARY KEY (id_asignatura),
    CONSTRAINT carrera FOREIGN KEY (carrera)
        REFERENCES public."Carrera" (id_carrera) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public."Asignatura"
    OWNER to postgres;
CREATE TABLE public."Seccion"
(
    id_seccion character varying(12) NOT NULL,
    max_estudiantes smallint NOT NULL,
    periodo character varying(30),
    asignatura character varying(12),
    PRIMARY KEY (id_seccion),
    CONSTRAINT asignatura FOREIGN KEY (asignatura)
        REFERENCES public."Asignatura" (id_asignatura) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public."Seccion"
    OWNER to postgres;
CREATE TABLE public."Estudiante"
(
    id_estudiante character varying(12) NOT NULL,
    cedula_estudiante character varying(9) NOT NULL,
    nombre_estudiante character varying(40) NOT NULL,
    genero_estudiante "char",
    PRIMARY KEY (id_estudiante)
);

ALTER TABLE IF EXISTS public."Estudiante"
    OWNER to postgres;
CREATE TABLE public."Calificacion"
(
    id_calificacion character varying(12) NOT NULL,
    nota double precision,
    promedio double precision,
    estudiante character varying(12),
    PRIMARY KEY (id_calificacion),
    CONSTRAINT estudiante FOREIGN KEY (estudiante)
        REFERENCES public."Estudiante" (id_estudiante) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public."Calificacion"
    OWNER to postgres;
CREATE TABLE public."EstudiantePorSeccion"
(
	id_porseccion character varying(12) NOT NULL,
	estudiante character varying(12) NOT NULL,
	seccion character varying(12) NOT NULL,
	PRIMARY KEY(id_porseccion),
	CONSTRAINT estudiante FOREIGN KEY (estudiante)
		REFERENCES public."Estudiante" (id_estudiante) MATCH SIMPLE
		ON UPDATE NO ACTION
		NOT VALID,
	CONSTRAINT seccion FOREIGN KEY (seccion)
		REFERENCES public."Seccion" (id_seccion) MATCH SIMPLE
		ON UPDATE NO ACTION
		NOT VALID
);
ALTER TABLE IF EXISTS public."EstudiantePorSeccion"
    OWNER to postgres;
ALTER TABLE IF EXISTS public."Estudiante"
    ADD COLUMN carrera character varying(12);
ALTER TABLE IF EXISTS public."Estudiante"
    ADD CONSTRAINT carrera FOREIGN KEY (carrera)
    REFERENCES public."Carrera" (id_carrera) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
INSERT INTO public."Decanato"(
	id_decanato, nombre)
	VALUES ('DCYT', 'Ciencias y tecnologia');
INSERT INTO public."Carrera"(
	id_carrera, nombre_carrera, decanato)
	VALUES ('caINFO', 'Ingenieria informatica', 'DCYT');
INSERT INTO public."Carrera"(
	id_carrera, nombre_carrera, decanato)
	VALUES ('caMATE', 'Licenciatura en Matematicas', 'DCYT');
INSERT INTO public."Estudiante"(
	id_estudiante, cedula_estudiante, nombre_estudiante, genero_estudiante, carrera)
	VALUES ('ed1', '28000000', 'Juan Perez', 'M', 'caINFO');
