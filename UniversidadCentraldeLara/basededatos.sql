/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
*/
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
ALTER TABLE IF EXISTS public."Decanato"
    RENAME nombre TO nombre_decanato;

ALTER TABLE IF EXISTS public."Decanato"
    ADD COLUMN direccion_decanato character varying(100);

ALTER TABLE IF EXISTS public."Decanato"
    ADD COLUMN tlf_decanato character varying(11);
ALTER TABLE public."Seccion"
    ALTER COLUMN periodo TYPE character varying(6) COLLATE pg_catalog."default";
ALTER TABLE IF EXISTS public."Seccion"
	ADD CONSTRAINT periodo FOREIGN KEY (periodo)
	REFERENCES public."PeriodoAcademico" (codigo_periodo)
	ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
ALTER TABLE IF EXISTS public."Estudiante"
    ADD COLUMN tlf_estudiante character varying(11);

ALTER TABLE IF EXISTS public."Estudiante"
    ADD COLUMN fecha_nacimiento date;
DELETE FROM public."Estudiante"
	WHERE 1=1;
DELETE FROM public."Seccion"
	WHERE 1=1;
DELETE FROM public."Carrera"
	WHERE 1=1;
DELETE FROM public."Decanato"
	WHERE 1=1;
ALTER TABLE public."Decanato"
    ALTER COLUMN nombre_decanato TYPE character varying(80) COLLATE pg_catalog."default";
INSERT INTO public."Decanato"(
	id_decanato, nombre_decanato, direccion_decanato, tlf_decanato)
	VALUES ('de1001','Ciencias Economicas y Empresariales' , 'Calle 8 entre 19 y 20', '02512591419');
INSERT INTO public."Decanato"(
	id_decanato, nombre_decanato, direccion_decanato, tlf_decanato)
	VALUES ('de1000','Ciencias y Tecnologia' , 'Avenida las Industrias', '02512591450');
INSERT INTO public."Carrera"(
	id_carrera, nombre_carrera, decanato)
	VALUES ('ca1001', 'Ingenieria informatica', 'de1000');
INSERT INTO public."Carrera"(
	id_carrera, nombre_carrera, decanato)
	VALUES ('ca1002', 'Licenciatura Matematicas', 'de1000');
INSERT INTO public."Carrera"(
	id_carrera, nombre_carrera, decanato)
	VALUES ('ca2001', 'Licenciatura en Administracion', 'de1001');
INSERT INTO public."Asignatura"(
	id_asignatura, nombre_asignatura, carrera)
	VALUES ('as200001', 'Fundamentos de Derecho', 'ca2001');
INSERT INTO public."Asignatura"(
	id_asignatura, nombre_asignatura, carrera)
	VALUES ('as100002', 'Estructuras Discretas I', 'ca1001');
INSERT INTO public."Asignatura"(
	id_asignatura, nombre_asignatura, carrera)
	VALUES ('as100001', 'Matematica I', 'ca1001');
INSERT INTO public."Asignatura"(
	id_asignatura, nombre_asignatura, carrera)
	VALUES ('as110001', 'Matematica I', 'ca1002');
INSERT INTO public."Asignatura"(
	id_asignatura, nombre_asignatura, carrera)
	VALUES ('as110002', 'Introd. a la Comput', 'ca1002');
INSERT INTO public."Estudiante"(
	id_estudiante, cedula_estudiante, nombre_estudiante, genero_estudiante, carrera, tlf_estudiante, fecha_nacimiento)
	VALUES ('es1000000000', '27000000', 'Pedro Paez', 'M', 'ca1001', '04242424242', '1999-02-28');
INSERT INTO public."Estudiante"(
	id_estudiante, cedula_estudiante, nombre_estudiante, genero_estudiante, carrera, tlf_estudiante, fecha_nacimiento)
	VALUES ('es1000000001', '27000001', 'Maria Paez', 'F', 'ca1001', '04242424243', '1999-03-28');
INSERT INTO public."Estudiante"(
	id_estudiante, cedula_estudiante, nombre_estudiante, genero_estudiante, carrera, tlf_estudiante, fecha_nacimiento)
	VALUES ('es2000000001', '27000021', 'Josefina Diaz', 'F', 'ca2001', '04242324243', '1999-04-28');
INSERT INTO public."PeriodoAcademico"(
	codigo_periodo, fecha_inicio, fecha_final, fecha_limite_retiro)
	VALUES ('2024-1', '2024-05-20', '2024-11-20', '2024-06-10');
INSERT INTO public."Seccion"(
	id_seccion, max_estudiantes, periodo, asignatura)
	VALUES ('se1000012', 32, '2024-1', 'as100002');
INSERT INTO public."Seccion"(
	id_seccion, max_estudiantes, periodo, asignatura)
	VALUES ('se1000011', 32, '2024-1', 'as100002');
INSERT INTO public."Seccion"(
	id_seccion, max_estudiantes, periodo, asignatura)
	VALUES ('se1000002', 32, '2024-1', 'as100001');
INSERT INTO public."Seccion"(
	id_seccion, max_estudiantes, periodo, asignatura)
	VALUES ('se1000001', 32, '2024-1', 'as100001');