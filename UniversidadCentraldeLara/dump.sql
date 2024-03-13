--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: UniversidadCentraldeLara; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "UniversidadCentraldeLara" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Venezuela.1252';


ALTER DATABASE "UniversidadCentraldeLara" OWNER TO postgres;

\connect "UniversidadCentraldeLara"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: Asignatura; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Asignatura" (
    id_asignatura character varying(12) NOT NULL,
    nombre_asignatura character varying(32) NOT NULL,
    carrera character varying(12)
);


ALTER TABLE public."Asignatura" OWNER TO postgres;

--
-- Name: Calificacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Calificacion" (
    id_calificacion character varying(12) NOT NULL,
    nota double precision,
    promedio double precision,
    estudiante character varying(12)
);


ALTER TABLE public."Calificacion" OWNER TO postgres;

--
-- Name: Carrera; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Carrera" (
    id_carrera character varying(12) NOT NULL,
    nombre_carrera character varying(32) NOT NULL,
    decanato character varying(12)
);


ALTER TABLE public."Carrera" OWNER TO postgres;

--
-- Name: Decanato; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Decanato" (
    id_decanato character varying(12) NOT NULL,
    nombre_decanato character varying(80) NOT NULL,
    direccion_decanato character varying(100),
    tlf_decanato character varying(11)
);


ALTER TABLE public."Decanato" OWNER TO postgres;

--
-- Name: Estudiante; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Estudiante" (
    id_estudiante character varying(12) NOT NULL,
    cedula_estudiante character varying(9) NOT NULL,
    nombre_estudiante character varying(40) NOT NULL,
    genero_estudiante "char",
    carrera character varying(12),
    tlf_estudiante character varying(11),
    fecha_nacimiento date
);


ALTER TABLE public."Estudiante" OWNER TO postgres;

--
-- Name: EstudiantePorSeccion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."EstudiantePorSeccion" (
    estudiante character varying(12) NOT NULL,
    seccion character varying(12) NOT NULL,
    id_porseccion integer NOT NULL
);


ALTER TABLE public."EstudiantePorSeccion" OWNER TO postgres;

--
-- Name: EstudiantePorSeccion_id_porseccion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."EstudiantePorSeccion_id_porseccion_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."EstudiantePorSeccion_id_porseccion_seq" OWNER TO postgres;

--
-- Name: EstudiantePorSeccion_id_porseccion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."EstudiantePorSeccion_id_porseccion_seq" OWNED BY public."EstudiantePorSeccion".id_porseccion;


--
-- Name: PeriodoAcademico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."PeriodoAcademico" (
    codigo_periodo character varying(6) NOT NULL,
    fecha_inicio date,
    fecha_final date,
    fecha_limite_retiro date
);


ALTER TABLE public."PeriodoAcademico" OWNER TO postgres;

--
-- Name: Seccion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Seccion" (
    id_seccion character varying(12) NOT NULL,
    max_estudiantes smallint NOT NULL,
    periodo character varying(6),
    asignatura character varying(12)
);


ALTER TABLE public."Seccion" OWNER TO postgres;

--
-- Name: EstudiantePorSeccion id_porseccion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."EstudiantePorSeccion" ALTER COLUMN id_porseccion SET DEFAULT nextval('public."EstudiantePorSeccion_id_porseccion_seq"'::regclass);


--
-- Data for Name: Asignatura; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Asignatura" (id_asignatura, nombre_asignatura, carrera) FROM stdin;
as100001	Matematica I	ca1001
as100002	Estructuras Discretas I	ca1001
as200001	Fundamentos de Derecho	ca2001
as110001	Matematica I	ca1002
as110002	Introd. a la Comput	ca1002
\.


--
-- Data for Name: Calificacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Calificacion" (id_calificacion, nota, promedio, estudiante) FROM stdin;
\.


--
-- Data for Name: Carrera; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Carrera" (id_carrera, nombre_carrera, decanato) FROM stdin;
ca1001	Ingenieria informatica	de1000
ca1002	Licenciatura Matematicas	de1000
ca2001	Licenciatura en Administracion	de1001
\.


--
-- Data for Name: Decanato; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Decanato" (id_decanato, nombre_decanato, direccion_decanato, tlf_decanato) FROM stdin;
de1000	Ciencias y Tecnologia	Avenida las Industrias	02512591450
de1001	Ciencias Economicas y Empresariales	Calle 8 entre 19 y 20	02512591419
\.


--
-- Data for Name: Estudiante; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Estudiante" (id_estudiante, cedula_estudiante, nombre_estudiante, genero_estudiante, carrera, tlf_estudiante, fecha_nacimiento) FROM stdin;
es1000000000	27000000	Pedro Paez	M	ca1001	04242424242	1999-02-28
es1000000001	27000001	Maria Paez	F	ca1001	04242424243	1999-03-28
es2000000001	27000021	Josefina Diaz	F	ca2001	04242324243	1999-04-28
\.


--
-- Data for Name: EstudiantePorSeccion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."EstudiantePorSeccion" (estudiante, seccion, id_porseccion) FROM stdin;
es1000000000	se1000001	2
es1000000000	se1000011	3
\.


--
-- Data for Name: PeriodoAcademico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."PeriodoAcademico" (codigo_periodo, fecha_inicio, fecha_final, fecha_limite_retiro) FROM stdin;
2024-1	2024-05-20	2024-11-20	2024-06-10
\.


--
-- Data for Name: Seccion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Seccion" (id_seccion, max_estudiantes, periodo, asignatura) FROM stdin;
se1000001	32	2024-1	as100001
se1000002	32	2024-1	as100001
se1000011	32	2024-1	as100002
se1000012	32	2024-1	as100002
\.


--
-- Name: EstudiantePorSeccion_id_porseccion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."EstudiantePorSeccion_id_porseccion_seq"', 3, true);


--
-- Name: Asignatura Asignatura_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Asignatura"
    ADD CONSTRAINT "Asignatura_pkey" PRIMARY KEY (id_asignatura);


--
-- Name: Calificacion Calificacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Calificacion"
    ADD CONSTRAINT "Calificacion_pkey" PRIMARY KEY (id_calificacion);


--
-- Name: Carrera Carrera_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Carrera"
    ADD CONSTRAINT "Carrera_pkey" PRIMARY KEY (id_carrera);


--
-- Name: Decanato Decanato_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Decanato"
    ADD CONSTRAINT "Decanato_pkey" PRIMARY KEY (id_decanato);


--
-- Name: EstudiantePorSeccion EstudiantePorSeccion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."EstudiantePorSeccion"
    ADD CONSTRAINT "EstudiantePorSeccion_pkey" PRIMARY KEY (id_porseccion);


--
-- Name: Estudiante Estudiante_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Estudiante"
    ADD CONSTRAINT "Estudiante_pkey" PRIMARY KEY (id_estudiante);


--
-- Name: PeriodoAcademico PeriodoAcademico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."PeriodoAcademico"
    ADD CONSTRAINT "PeriodoAcademico_pkey" PRIMARY KEY (codigo_periodo);


--
-- Name: Seccion Seccion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Seccion"
    ADD CONSTRAINT "Seccion_pkey" PRIMARY KEY (id_seccion);


--
-- Name: Seccion asignatura; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Seccion"
    ADD CONSTRAINT asignatura FOREIGN KEY (asignatura) REFERENCES public."Asignatura"(id_asignatura);


--
-- Name: Asignatura carrera; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Asignatura"
    ADD CONSTRAINT carrera FOREIGN KEY (carrera) REFERENCES public."Carrera"(id_carrera) NOT VALID;


--
-- Name: Estudiante carrera; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Estudiante"
    ADD CONSTRAINT carrera FOREIGN KEY (carrera) REFERENCES public."Carrera"(id_carrera) NOT VALID;


--
-- Name: Carrera decanato; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Carrera"
    ADD CONSTRAINT decanato FOREIGN KEY (decanato) REFERENCES public."Decanato"(id_decanato);


--
-- Name: Calificacion estudiante; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Calificacion"
    ADD CONSTRAINT estudiante FOREIGN KEY (estudiante) REFERENCES public."Estudiante"(id_estudiante);


--
-- Name: EstudiantePorSeccion estudiante; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."EstudiantePorSeccion"
    ADD CONSTRAINT estudiante FOREIGN KEY (estudiante) REFERENCES public."Estudiante"(id_estudiante);


--
-- Name: Seccion periodo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Seccion"
    ADD CONSTRAINT periodo FOREIGN KEY (periodo) REFERENCES public."PeriodoAcademico"(codigo_periodo) NOT VALID;


--
-- Name: EstudiantePorSeccion seccion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."EstudiantePorSeccion"
    ADD CONSTRAINT seccion FOREIGN KEY (seccion) REFERENCES public."Seccion"(id_seccion);


--
-- PostgreSQL database dump complete
--

