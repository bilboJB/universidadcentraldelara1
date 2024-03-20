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

CREATE DATABASE "UniversidadCentraldeLara" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc;


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
    nombre_asignatura character varying(32) NOT NULL,
    carrera integer NOT NULL,
    id_asignatura integer NOT NULL
);


ALTER TABLE public."Asignatura" OWNER TO postgres;

--
-- Name: Asignatura_carrera_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Asignatura_carrera_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Asignatura_carrera_seq" OWNER TO postgres;

--
-- Name: Asignatura_carrera_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Asignatura_carrera_seq" OWNED BY public."Asignatura".carrera;


--
-- Name: Asignatura_id_asignatura_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Asignatura_id_asignatura_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Asignatura_id_asignatura_seq" OWNER TO postgres;

--
-- Name: Asignatura_id_asignatura_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Asignatura_id_asignatura_seq" OWNED BY public."Asignatura".id_asignatura;


--
-- Name: Calificacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Calificacion" (
    promedio double precision,
    id_calificacion integer NOT NULL,
    nota double precision[],
    estudiante integer NOT NULL,
    seccion integer NOT NULL
);


ALTER TABLE public."Calificacion" OWNER TO postgres;

--
-- Name: Calificacion_estudiante_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Calificacion_estudiante_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Calificacion_estudiante_seq" OWNER TO postgres;

--
-- Name: Calificacion_estudiante_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Calificacion_estudiante_seq" OWNED BY public."Calificacion".estudiante;


--
-- Name: Calificacion_id_calificacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Calificacion_id_calificacion_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Calificacion_id_calificacion_seq" OWNER TO postgres;

--
-- Name: Calificacion_id_calificacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Calificacion_id_calificacion_seq" OWNED BY public."Calificacion".id_calificacion;


--
-- Name: Calificacion_seccion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Calificacion_seccion_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Calificacion_seccion_seq" OWNER TO postgres;

--
-- Name: Calificacion_seccion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Calificacion_seccion_seq" OWNED BY public."Calificacion".seccion;


--
-- Name: Carrera; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Carrera" (
    nombre_carrera character varying(32) NOT NULL,
    decanato integer NOT NULL,
    id_carrera integer NOT NULL
);


ALTER TABLE public."Carrera" OWNER TO postgres;

--
-- Name: Carrera_decanato_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Carrera_decanato_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Carrera_decanato_seq" OWNER TO postgres;

--
-- Name: Carrera_decanato_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Carrera_decanato_seq" OWNED BY public."Carrera".decanato;


--
-- Name: Carrera_id_carrera_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Carrera_id_carrera_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Carrera_id_carrera_seq" OWNER TO postgres;

--
-- Name: Carrera_id_carrera_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Carrera_id_carrera_seq" OWNED BY public."Carrera".id_carrera;


--
-- Name: Decanato; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Decanato" (
    nombre_decanato character varying(80) NOT NULL,
    direccion_decanato character varying(100),
    tlf_decanato character varying(11),
    id_decanato integer NOT NULL
);


ALTER TABLE public."Decanato" OWNER TO postgres;

--
-- Name: Decanato_id_decanato_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Decanato_id_decanato_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Decanato_id_decanato_seq" OWNER TO postgres;

--
-- Name: Decanato_id_decanato_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Decanato_id_decanato_seq" OWNED BY public."Decanato".id_decanato;


--
-- Name: Estudiante; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Estudiante" (
    cedula_estudiante character varying(9) NOT NULL,
    nombre_estudiante character varying(40) NOT NULL,
    genero_estudiante "char",
    tlf_estudiante character varying(11),
    fecha_nacimiento date,
    carrera integer NOT NULL,
    id_estudiante integer NOT NULL
);


ALTER TABLE public."Estudiante" OWNER TO postgres;

--
-- Name: EstudiantePorSeccion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."EstudiantePorSeccion" (
    id_porseccion integer NOT NULL,
    seccion integer NOT NULL,
    estudiante integer NOT NULL
);


ALTER TABLE public."EstudiantePorSeccion" OWNER TO postgres;

--
-- Name: EstudiantePorSeccion_estudiante_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."EstudiantePorSeccion_estudiante_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."EstudiantePorSeccion_estudiante_seq" OWNER TO postgres;

--
-- Name: EstudiantePorSeccion_estudiante_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."EstudiantePorSeccion_estudiante_seq" OWNED BY public."EstudiantePorSeccion".estudiante;


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
-- Name: EstudiantePorSeccion_seccion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."EstudiantePorSeccion_seccion_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."EstudiantePorSeccion_seccion_seq" OWNER TO postgres;

--
-- Name: EstudiantePorSeccion_seccion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."EstudiantePorSeccion_seccion_seq" OWNED BY public."EstudiantePorSeccion".seccion;


--
-- Name: Estudiante_carrera_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Estudiante_carrera_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Estudiante_carrera_seq" OWNER TO postgres;

--
-- Name: Estudiante_carrera_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Estudiante_carrera_seq" OWNED BY public."Estudiante".carrera;


--
-- Name: Estudiante_id_estudiante_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Estudiante_id_estudiante_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Estudiante_id_estudiante_seq" OWNER TO postgres;

--
-- Name: Estudiante_id_estudiante_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Estudiante_id_estudiante_seq" OWNED BY public."Estudiante".id_estudiante;


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
-- Name: Profesor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Profesor" (
    id_profesor integer NOT NULL,
    cedula_profesor character varying(8) NOT NULL,
    nombre_profesor character varying(60) NOT NULL,
    tlf_profesor character varying(11),
    genero_profesor "char"
);


ALTER TABLE public."Profesor" OWNER TO postgres;

--
-- Name: Profesor_id_profesor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Profesor_id_profesor_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Profesor_id_profesor_seq" OWNER TO postgres;

--
-- Name: Profesor_id_profesor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Profesor_id_profesor_seq" OWNED BY public."Profesor".id_profesor;


--
-- Name: Seccion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Seccion" (
    max_estudiantes smallint NOT NULL,
    periodo character varying(6),
    profesor integer NOT NULL,
    asignatura integer NOT NULL,
    numero_seccion smallint,
    id_seccion integer NOT NULL
);


ALTER TABLE public."Seccion" OWNER TO postgres;

--
-- Name: Seccion_asignatura_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Seccion_asignatura_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Seccion_asignatura_seq" OWNER TO postgres;

--
-- Name: Seccion_asignatura_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Seccion_asignatura_seq" OWNED BY public."Seccion".asignatura;


--
-- Name: Seccion_id_seccion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Seccion_id_seccion_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Seccion_id_seccion_seq" OWNER TO postgres;

--
-- Name: Seccion_id_seccion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Seccion_id_seccion_seq" OWNED BY public."Seccion".id_seccion;


--
-- Name: Seccion_profesor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Seccion_profesor_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Seccion_profesor_seq" OWNER TO postgres;

--
-- Name: Seccion_profesor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Seccion_profesor_seq" OWNED BY public."Seccion".profesor;


--
-- Name: Asignatura carrera; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Asignatura" ALTER COLUMN carrera SET DEFAULT nextval('public."Asignatura_carrera_seq"'::regclass);


--
-- Name: Asignatura id_asignatura; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Asignatura" ALTER COLUMN id_asignatura SET DEFAULT nextval('public."Asignatura_id_asignatura_seq"'::regclass);


--
-- Name: Calificacion id_calificacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Calificacion" ALTER COLUMN id_calificacion SET DEFAULT nextval('public."Calificacion_id_calificacion_seq"'::regclass);


--
-- Name: Calificacion estudiante; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Calificacion" ALTER COLUMN estudiante SET DEFAULT nextval('public."Calificacion_estudiante_seq"'::regclass);


--
-- Name: Calificacion seccion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Calificacion" ALTER COLUMN seccion SET DEFAULT nextval('public."Calificacion_seccion_seq"'::regclass);


--
-- Name: Carrera decanato; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Carrera" ALTER COLUMN decanato SET DEFAULT nextval('public."Carrera_decanato_seq"'::regclass);


--
-- Name: Carrera id_carrera; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Carrera" ALTER COLUMN id_carrera SET DEFAULT nextval('public."Carrera_id_carrera_seq"'::regclass);


--
-- Name: Decanato id_decanato; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Decanato" ALTER COLUMN id_decanato SET DEFAULT nextval('public."Decanato_id_decanato_seq"'::regclass);


--
-- Name: Estudiante carrera; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Estudiante" ALTER COLUMN carrera SET DEFAULT nextval('public."Estudiante_carrera_seq"'::regclass);


--
-- Name: Estudiante id_estudiante; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Estudiante" ALTER COLUMN id_estudiante SET DEFAULT nextval('public."Estudiante_id_estudiante_seq"'::regclass);


--
-- Name: EstudiantePorSeccion id_porseccion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."EstudiantePorSeccion" ALTER COLUMN id_porseccion SET DEFAULT nextval('public."EstudiantePorSeccion_id_porseccion_seq"'::regclass);


--
-- Name: EstudiantePorSeccion seccion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."EstudiantePorSeccion" ALTER COLUMN seccion SET DEFAULT nextval('public."EstudiantePorSeccion_seccion_seq"'::regclass);


--
-- Name: EstudiantePorSeccion estudiante; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."EstudiantePorSeccion" ALTER COLUMN estudiante SET DEFAULT nextval('public."EstudiantePorSeccion_estudiante_seq"'::regclass);


--
-- Name: Profesor id_profesor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Profesor" ALTER COLUMN id_profesor SET DEFAULT nextval('public."Profesor_id_profesor_seq"'::regclass);


--
-- Name: Seccion profesor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Seccion" ALTER COLUMN profesor SET DEFAULT nextval('public."Seccion_profesor_seq"'::regclass);


--
-- Name: Seccion asignatura; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Seccion" ALTER COLUMN asignatura SET DEFAULT nextval('public."Seccion_asignatura_seq"'::regclass);


--
-- Name: Seccion id_seccion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Seccion" ALTER COLUMN id_seccion SET DEFAULT nextval('public."Seccion_id_seccion_seq"'::regclass);


--
-- Data for Name: Asignatura; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Asignatura" (nombre_asignatura, carrera, id_asignatura) FROM stdin;
Matematica I	1	1
Estructuras Discretas I	1	2
Matematica I	2	3
Introd. a la Comput	2	4
Fundamentos de Derecho	3	5
\.


--
-- Data for Name: Calificacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Calificacion" (promedio, id_calificacion, nota, estudiante, seccion) FROM stdin;
12.666666666666666	2	{12,14,12}	1	1
\.


--
-- Data for Name: Carrera; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Carrera" (nombre_carrera, decanato, id_carrera) FROM stdin;
Ingenieria informatica	1	1
Licenciatura Matematicas	1	2
Licenciatura en Administracion	2	3
\.


--
-- Data for Name: Decanato; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Decanato" (nombre_decanato, direccion_decanato, tlf_decanato, id_decanato) FROM stdin;
Ciencias y Tecnologia	Avenida las Industrias	02512591450	1
Ciencias Economicas y Empresariales	Calle 8 entre 19 y 20	02512591419	2
Ingenieria Civil	Carrera 5	02512562101	3
\.


--
-- Data for Name: Estudiante; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Estudiante" (cedula_estudiante, nombre_estudiante, genero_estudiante, tlf_estudiante, fecha_nacimiento, carrera, id_estudiante) FROM stdin;
27000000	Pedro Paez	M	04242424242	1999-02-28	1	1
27000021	Josefina Diaz	F	04242324243	1999-04-28	3	2
27000001	Maria Paez	F	04242424243	1999-03-28	1	3
\.


--
-- Data for Name: EstudiantePorSeccion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."EstudiantePorSeccion" (id_porseccion, seccion, estudiante) FROM stdin;
6	1	1
7	2	1
\.


--
-- Data for Name: PeriodoAcademico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."PeriodoAcademico" (codigo_periodo, fecha_inicio, fecha_final, fecha_limite_retiro) FROM stdin;
2024-1	2024-05-20	2024-11-20	2024-06-10
\.


--
-- Data for Name: Profesor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Profesor" (id_profesor, cedula_profesor, nombre_profesor, tlf_profesor, genero_profesor) FROM stdin;
1	17000000	Carlos Santana	04141414141	M
2	17000001	Gonzalo Galindez	04141414142	M
3	17000002	Fabiola Fabregas	04161414142	F
4	17000102	Julieta Fabregas	04161414143	F
\.


--
-- Data for Name: Seccion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Seccion" (max_estudiantes, periodo, profesor, asignatura, numero_seccion, id_seccion) FROM stdin;
32	2024-1	1	1	1	1
32	2024-1	3	2	1	2
32	2024-1	2	1	2	3
32	2024-1	4	2	2	4
\.


--
-- Name: Asignatura_carrera_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Asignatura_carrera_seq"', 5, true);


--
-- Name: Asignatura_id_asignatura_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Asignatura_id_asignatura_seq"', 5, true);


--
-- Name: Calificacion_estudiante_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Calificacion_estudiante_seq"', 1, false);


--
-- Name: Calificacion_id_calificacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Calificacion_id_calificacion_seq"', 2, true);


--
-- Name: Calificacion_seccion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Calificacion_seccion_seq"', 1, false);


--
-- Name: Carrera_decanato_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Carrera_decanato_seq"', 3, true);


--
-- Name: Carrera_id_carrera_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Carrera_id_carrera_seq"', 3, true);


--
-- Name: Decanato_id_decanato_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Decanato_id_decanato_seq"', 4, true);


--
-- Name: EstudiantePorSeccion_estudiante_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."EstudiantePorSeccion_estudiante_seq"', 4, true);


--
-- Name: EstudiantePorSeccion_id_porseccion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."EstudiantePorSeccion_id_porseccion_seq"', 7, true);


--
-- Name: EstudiantePorSeccion_seccion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."EstudiantePorSeccion_seccion_seq"', 4, true);


--
-- Name: Estudiante_carrera_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Estudiante_carrera_seq"', 3, true);


--
-- Name: Estudiante_id_estudiante_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Estudiante_id_estudiante_seq"', 3, true);


--
-- Name: Profesor_id_profesor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Profesor_id_profesor_seq"', 4, true);


--
-- Name: Seccion_asignatura_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Seccion_asignatura_seq"', 4, true);


--
-- Name: Seccion_id_seccion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Seccion_id_seccion_seq"', 4, true);


--
-- Name: Seccion_profesor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Seccion_profesor_seq"', 4, true);


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
-- Name: Profesor Profesor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Profesor"
    ADD CONSTRAINT "Profesor_pkey" PRIMARY KEY (id_profesor);


--
-- Name: Seccion Seccion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Seccion"
    ADD CONSTRAINT "Seccion_pkey" PRIMARY KEY (id_seccion);


--
-- Name: Seccion asignatura; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Seccion"
    ADD CONSTRAINT asignatura FOREIGN KEY (asignatura) REFERENCES public."Asignatura"(id_asignatura) NOT VALID;


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
    ADD CONSTRAINT decanato FOREIGN KEY (decanato) REFERENCES public."Decanato"(id_decanato) NOT VALID;


--
-- Name: EstudiantePorSeccion estudiante; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."EstudiantePorSeccion"
    ADD CONSTRAINT estudiante FOREIGN KEY (estudiante) REFERENCES public."Estudiante"(id_estudiante) NOT VALID;


--
-- Name: Calificacion estudiante; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Calificacion"
    ADD CONSTRAINT estudiante FOREIGN KEY (estudiante) REFERENCES public."Estudiante"(id_estudiante) NOT VALID;


--
-- Name: Seccion periodo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Seccion"
    ADD CONSTRAINT periodo FOREIGN KEY (periodo) REFERENCES public."PeriodoAcademico"(codigo_periodo) NOT VALID;


--
-- Name: Seccion profesor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Seccion"
    ADD CONSTRAINT profesor FOREIGN KEY (profesor) REFERENCES public."Profesor"(id_profesor) NOT VALID;


--
-- Name: EstudiantePorSeccion seccion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."EstudiantePorSeccion"
    ADD CONSTRAINT seccion FOREIGN KEY (seccion) REFERENCES public."Seccion"(id_seccion) NOT VALID;


--
-- Name: Calificacion seccion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Calificacion"
    ADD CONSTRAINT seccion FOREIGN KEY (seccion) REFERENCES public."Seccion"(id_seccion) NOT VALID;


--
-- PostgreSQL database dump complete
--

