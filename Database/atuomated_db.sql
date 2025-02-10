--
-- PostgreSQL database dump
--

-- Dumped from database version 16.6 (Ubuntu 16.6-1.pgdg24.04+1)
-- Dumped by pg_dump version 17.2 (Ubuntu 17.2-1.pgdg24.04+1)

-- Started on 2025-02-10 12:16:52 +0530

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
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
-- TOC entry 216 (class 1259 OID 16523)
-- Name: admin_cordinator; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.admin_cordinator (
    admin_cordinater_id integer NOT NULL,
    staff_id integer NOT NULL
);


ALTER TABLE public.admin_cordinator OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16522)
-- Name: admin_cordinator_admin_cordinater_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.admin_cordinator_admin_cordinater_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.admin_cordinator_admin_cordinater_id_seq OWNER TO postgres;

--
-- TOC entry 3611 (class 0 OID 0)
-- Dependencies: 215
-- Name: admin_cordinator_admin_cordinater_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.admin_cordinator_admin_cordinater_id_seq OWNED BY public.admin_cordinator.admin_cordinater_id;


--
-- TOC entry 218 (class 1259 OID 16530)
-- Name: ar; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ar (
    ar_id integer NOT NULL,
    staff_id integer NOT NULL
);


ALTER TABLE public.ar OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16529)
-- Name: ar_ar_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ar_ar_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.ar_ar_id_seq OWNER TO postgres;

--
-- TOC entry 3612 (class 0 OID 0)
-- Dependencies: 217
-- Name: ar_ar_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ar_ar_id_seq OWNED BY public.ar.ar_id;


--
-- TOC entry 219 (class 1259 OID 16536)
-- Name: attempt; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.attempt (
    strudent_id integer NOT NULL,
    exam_id integer NOT NULL,
    maks integer NOT NULL,
    grade integer NOT NULL
);


ALTER TABLE public.attempt OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16542)
-- Name: course; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course (
    coourse_id integer NOT NULL,
    "course name" integer NOT NULL,
    "Course code" integer NOT NULL,
    credits integer NOT NULL,
    department_id integer NOT NULL
);


ALTER TABLE public.course OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16541)
-- Name: course_coourse_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.course_coourse_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.course_coourse_id_seq OWNER TO postgres;

--
-- TOC entry 3613 (class 0 OID 0)
-- Dependencies: 220
-- Name: course_coourse_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.course_coourse_id_seq OWNED BY public.course.coourse_id;


--
-- TOC entry 223 (class 1259 OID 16549)
-- Name: course_offering; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course_offering (
    offering_id integer NOT NULL,
    semester integer NOT NULL,
    start_date integer NOT NULL,
    end_date integer NOT NULL,
    course_id integer NOT NULL,
    admin_cordinate_id integer NOT NULL,
    course_cordinater integer NOT NULL
);


ALTER TABLE public.course_offering OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16548)
-- Name: course_offering_offering_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.course_offering_offering_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.course_offering_offering_id_seq OWNER TO postgres;

--
-- TOC entry 3614 (class 0 OID 0)
-- Dependencies: 222
-- Name: course_offering_offering_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.course_offering_offering_id_seq OWNED BY public.course_offering.offering_id;


--
-- TOC entry 225 (class 1259 OID 16556)
-- Name: course_register; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course_register (
    registration_id integer NOT NULL,
    offering_id integer NOT NULL
);


ALTER TABLE public.course_register OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16555)
-- Name: course_register_registration_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.course_register_registration_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.course_register_registration_id_seq OWNER TO postgres;

--
-- TOC entry 3615 (class 0 OID 0)
-- Dependencies: 224
-- Name: course_register_registration_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.course_register_registration_id_seq OWNED BY public.course_register.registration_id;


--
-- TOC entry 227 (class 1259 OID 16563)
-- Name: department; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.department (
    department_id integer NOT NULL,
    name integer NOT NULL,
    hod integer NOT NULL
);


ALTER TABLE public.department OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 16562)
-- Name: department_department_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.department_department_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.department_department_id_seq OWNER TO postgres;

--
-- TOC entry 3616 (class 0 OID 0)
-- Dependencies: 226
-- Name: department_department_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.department_department_id_seq OWNED BY public.department.department_id;


--
-- TOC entry 229 (class 1259 OID 16570)
-- Name: exam; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.exam (
    exam_id integer NOT NULL,
    "Start_Data&Time" integer NOT NULL,
    duration integer NOT NULL,
    passing_criteria integer NOT NULL,
    type integer NOT NULL,
    total_maks integer NOT NULL,
    offering_id integer NOT NULL
);


ALTER TABLE public.exam OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 16569)
-- Name: exam_exam_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.exam_exam_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.exam_exam_id_seq OWNER TO postgres;

--
-- TOC entry 3617 (class 0 OID 0)
-- Dependencies: 228
-- Name: exam_exam_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.exam_exam_id_seq OWNED BY public.exam.exam_id;


--
-- TOC entry 231 (class 1259 OID 16577)
-- Name: lecture; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.lecture (
    lecture_id integer NOT NULL,
    satff_id integer NOT NULL
);


ALTER TABLE public.lecture OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 16576)
-- Name: lecture_lecture_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.lecture_lecture_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.lecture_lecture_id_seq OWNER TO postgres;

--
-- TOC entry 3618 (class 0 OID 0)
-- Dependencies: 230
-- Name: lecture_lecture_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.lecture_lecture_id_seq OWNED BY public.lecture.lecture_id;


--
-- TOC entry 232 (class 1259 OID 16583)
-- Name: prerequirest; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.prerequirest (
    course_id integer NOT NULL,
    req_course_id integer NOT NULL
);


ALTER TABLE public.prerequirest OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 16589)
-- Name: question; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.question (
    q_id integer NOT NULL,
    "Question" integer NOT NULL,
    maks integer NOT NULL,
    answer integer NOT NULL,
    exam_id integer NOT NULL
);


ALTER TABLE public.question OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 16588)
-- Name: question_q_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.question_q_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.question_q_id_seq OWNER TO postgres;

--
-- TOC entry 3619 (class 0 OID 0)
-- Dependencies: 233
-- Name: question_q_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.question_q_id_seq OWNED BY public.question.q_id;


--
-- TOC entry 236 (class 1259 OID 16596)
-- Name: resitration; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.resitration (
    registration_id integer NOT NULL,
    registration_date integer NOT NULL,
    semester integer NOT NULL,
    time_stamp integer NOT NULL,
    status integer NOT NULL,
    ar_id integer NOT NULL,
    student_id integer NOT NULL
);


ALTER TABLE public.resitration OWNER TO postgres;

--
-- TOC entry 235 (class 1259 OID 16595)
-- Name: resitration_registration_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.resitration_registration_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.resitration_registration_id_seq OWNER TO postgres;

--
-- TOC entry 3620 (class 0 OID 0)
-- Dependencies: 235
-- Name: resitration_registration_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.resitration_registration_id_seq OWNED BY public.resitration.registration_id;


--
-- TOC entry 238 (class 1259 OID 16603)
-- Name: staff; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.staff (
    staff_id integer NOT NULL,
    email integer NOT NULL,
    nic integer NOT NULL,
    fullname integer NOT NULL,
    phone_number character varying(55) NOT NULL,
    password integer NOT NULL,
    department_id integer NOT NULL
);


ALTER TABLE public.staff OWNER TO postgres;

--
-- TOC entry 237 (class 1259 OID 16602)
-- Name: staff_staff_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.staff_staff_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.staff_staff_id_seq OWNER TO postgres;

--
-- TOC entry 3621 (class 0 OID 0)
-- Dependencies: 237
-- Name: staff_staff_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.staff_staff_id_seq OWNED BY public.staff.staff_id;


--
-- TOC entry 240 (class 1259 OID 16610)
-- Name: stored question; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."stored question" (
    q_id integer NOT NULL,
    "Question" integer NOT NULL,
    answer integer NOT NULL,
    maks integer NOT NULL,
    type integer NOT NULL,
    lecture_id integer NOT NULL
);


ALTER TABLE public."stored question" OWNER TO postgres;

--
-- TOC entry 239 (class 1259 OID 16609)
-- Name: stored question_q_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."stored question_q_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."stored question_q_id_seq" OWNER TO postgres;

--
-- TOC entry 3622 (class 0 OID 0)
-- Dependencies: 239
-- Name: stored question_q_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."stored question_q_id_seq" OWNED BY public."stored question".q_id;


--
-- TOC entry 242 (class 1259 OID 16617)
-- Name: student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student (
    student_id integer NOT NULL,
    email character varying(255) NOT NULL,
    "Full Name" character varying(255) NOT NULL,
    nic integer NOT NULL,
    nationality integer NOT NULL,
    photo_link integer NOT NULL,
    address integer NOT NULL,
    gender integer NOT NULL,
    phone_no character varying(55) NOT NULL,
    departmnet_id integer NOT NULL,
    lecture_id integer NOT NULL
);


ALTER TABLE public.student OWNER TO postgres;

--
-- TOC entry 241 (class 1259 OID 16616)
-- Name: student_student_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.student_student_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.student_student_id_seq OWNER TO postgres;

--
-- TOC entry 3623 (class 0 OID 0)
-- Dependencies: 241
-- Name: student_student_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.student_student_id_seq OWNED BY public.student.student_id;


--
-- TOC entry 243 (class 1259 OID 16625)
-- Name: teach; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.teach (
    lecture_id integer NOT NULL,
    offering_id integer NOT NULL
);


ALTER TABLE public.teach OWNER TO postgres;

--
-- TOC entry 3355 (class 2604 OID 16526)
-- Name: admin_cordinator admin_cordinater_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin_cordinator ALTER COLUMN admin_cordinater_id SET DEFAULT nextval('public.admin_cordinator_admin_cordinater_id_seq'::regclass);


--
-- TOC entry 3356 (class 2604 OID 16533)
-- Name: ar ar_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ar ALTER COLUMN ar_id SET DEFAULT nextval('public.ar_ar_id_seq'::regclass);


--
-- TOC entry 3357 (class 2604 OID 16545)
-- Name: course coourse_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course ALTER COLUMN coourse_id SET DEFAULT nextval('public.course_coourse_id_seq'::regclass);


--
-- TOC entry 3358 (class 2604 OID 16552)
-- Name: course_offering offering_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_offering ALTER COLUMN offering_id SET DEFAULT nextval('public.course_offering_offering_id_seq'::regclass);


--
-- TOC entry 3359 (class 2604 OID 16559)
-- Name: course_register registration_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_register ALTER COLUMN registration_id SET DEFAULT nextval('public.course_register_registration_id_seq'::regclass);


--
-- TOC entry 3360 (class 2604 OID 16566)
-- Name: department department_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.department ALTER COLUMN department_id SET DEFAULT nextval('public.department_department_id_seq'::regclass);


--
-- TOC entry 3361 (class 2604 OID 16573)
-- Name: exam exam_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exam ALTER COLUMN exam_id SET DEFAULT nextval('public.exam_exam_id_seq'::regclass);


--
-- TOC entry 3362 (class 2604 OID 16580)
-- Name: lecture lecture_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lecture ALTER COLUMN lecture_id SET DEFAULT nextval('public.lecture_lecture_id_seq'::regclass);


--
-- TOC entry 3363 (class 2604 OID 16592)
-- Name: question q_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question ALTER COLUMN q_id SET DEFAULT nextval('public.question_q_id_seq'::regclass);


--
-- TOC entry 3364 (class 2604 OID 16599)
-- Name: resitration registration_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resitration ALTER COLUMN registration_id SET DEFAULT nextval('public.resitration_registration_id_seq'::regclass);


--
-- TOC entry 3365 (class 2604 OID 16606)
-- Name: staff staff_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.staff ALTER COLUMN staff_id SET DEFAULT nextval('public.staff_staff_id_seq'::regclass);


--
-- TOC entry 3366 (class 2604 OID 16613)
-- Name: stored question q_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."stored question" ALTER COLUMN q_id SET DEFAULT nextval('public."stored question_q_id_seq"'::regclass);


--
-- TOC entry 3367 (class 2604 OID 16620)
-- Name: student student_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student ALTER COLUMN student_id SET DEFAULT nextval('public.student_student_id_seq'::regclass);


--
-- TOC entry 3578 (class 0 OID 16523)
-- Dependencies: 216
-- Data for Name: admin_cordinator; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.admin_cordinator (admin_cordinater_id, staff_id) FROM stdin;
\.


--
-- TOC entry 3580 (class 0 OID 16530)
-- Dependencies: 218
-- Data for Name: ar; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ar (ar_id, staff_id) FROM stdin;
\.


--
-- TOC entry 3581 (class 0 OID 16536)
-- Dependencies: 219
-- Data for Name: attempt; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.attempt (strudent_id, exam_id, maks, grade) FROM stdin;
\.


--
-- TOC entry 3583 (class 0 OID 16542)
-- Dependencies: 221
-- Data for Name: course; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course (coourse_id, "course name", "Course code", credits, department_id) FROM stdin;
\.


--
-- TOC entry 3585 (class 0 OID 16549)
-- Dependencies: 223
-- Data for Name: course_offering; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_offering (offering_id, semester, start_date, end_date, course_id, admin_cordinate_id, course_cordinater) FROM stdin;
\.


--
-- TOC entry 3587 (class 0 OID 16556)
-- Dependencies: 225
-- Data for Name: course_register; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_register (registration_id, offering_id) FROM stdin;
\.


--
-- TOC entry 3589 (class 0 OID 16563)
-- Dependencies: 227
-- Data for Name: department; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.department (department_id, name, hod) FROM stdin;
\.


--
-- TOC entry 3591 (class 0 OID 16570)
-- Dependencies: 229
-- Data for Name: exam; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.exam (exam_id, "Start_Data&Time", duration, passing_criteria, type, total_maks, offering_id) FROM stdin;
\.


--
-- TOC entry 3593 (class 0 OID 16577)
-- Dependencies: 231
-- Data for Name: lecture; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.lecture (lecture_id, satff_id) FROM stdin;
\.


--
-- TOC entry 3594 (class 0 OID 16583)
-- Dependencies: 232
-- Data for Name: prerequirest; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.prerequirest (course_id, req_course_id) FROM stdin;
\.


--
-- TOC entry 3596 (class 0 OID 16589)
-- Dependencies: 234
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.question (q_id, "Question", maks, answer, exam_id) FROM stdin;
\.


--
-- TOC entry 3598 (class 0 OID 16596)
-- Dependencies: 236
-- Data for Name: resitration; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.resitration (registration_id, registration_date, semester, time_stamp, status, ar_id, student_id) FROM stdin;
\.


--
-- TOC entry 3600 (class 0 OID 16603)
-- Dependencies: 238
-- Data for Name: staff; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.staff (staff_id, email, nic, fullname, phone_number, password, department_id) FROM stdin;
\.


--
-- TOC entry 3602 (class 0 OID 16610)
-- Dependencies: 240
-- Data for Name: stored question; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."stored question" (q_id, "Question", answer, maks, type, lecture_id) FROM stdin;
\.


--
-- TOC entry 3604 (class 0 OID 16617)
-- Dependencies: 242
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.student (student_id, email, "Full Name", nic, nationality, photo_link, address, gender, phone_no, departmnet_id, lecture_id) FROM stdin;
\.


--
-- TOC entry 3605 (class 0 OID 16625)
-- Dependencies: 243
-- Data for Name: teach; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.teach (lecture_id, offering_id) FROM stdin;
\.


--
-- TOC entry 3624 (class 0 OID 0)
-- Dependencies: 215
-- Name: admin_cordinator_admin_cordinater_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.admin_cordinator_admin_cordinater_id_seq', 1, false);


--
-- TOC entry 3625 (class 0 OID 0)
-- Dependencies: 217
-- Name: ar_ar_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ar_ar_id_seq', 1, false);


--
-- TOC entry 3626 (class 0 OID 0)
-- Dependencies: 220
-- Name: course_coourse_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.course_coourse_id_seq', 1, false);


--
-- TOC entry 3627 (class 0 OID 0)
-- Dependencies: 222
-- Name: course_offering_offering_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.course_offering_offering_id_seq', 1, false);


--
-- TOC entry 3628 (class 0 OID 0)
-- Dependencies: 224
-- Name: course_register_registration_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.course_register_registration_id_seq', 1, false);


--
-- TOC entry 3629 (class 0 OID 0)
-- Dependencies: 226
-- Name: department_department_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.department_department_id_seq', 1, false);


--
-- TOC entry 3630 (class 0 OID 0)
-- Dependencies: 228
-- Name: exam_exam_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.exam_exam_id_seq', 1, false);


--
-- TOC entry 3631 (class 0 OID 0)
-- Dependencies: 230
-- Name: lecture_lecture_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.lecture_lecture_id_seq', 1, false);


--
-- TOC entry 3632 (class 0 OID 0)
-- Dependencies: 233
-- Name: question_q_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.question_q_id_seq', 1, false);


--
-- TOC entry 3633 (class 0 OID 0)
-- Dependencies: 235
-- Name: resitration_registration_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.resitration_registration_id_seq', 1, false);


--
-- TOC entry 3634 (class 0 OID 0)
-- Dependencies: 237
-- Name: staff_staff_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.staff_staff_id_seq', 1, false);


--
-- TOC entry 3635 (class 0 OID 0)
-- Dependencies: 239
-- Name: stored question_q_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."stored question_q_id_seq"', 1, false);


--
-- TOC entry 3636 (class 0 OID 0)
-- Dependencies: 241
-- Name: student_student_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.student_student_id_seq', 1, false);


--
-- TOC entry 3369 (class 2606 OID 16528)
-- Name: admin_cordinator admin_cordinator_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin_cordinator
    ADD CONSTRAINT admin_cordinator_pkey PRIMARY KEY (admin_cordinater_id);


--
-- TOC entry 3371 (class 2606 OID 16535)
-- Name: ar ar_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ar
    ADD CONSTRAINT ar_pkey PRIMARY KEY (ar_id);


--
-- TOC entry 3374 (class 2606 OID 16540)
-- Name: attempt attempt_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.attempt
    ADD CONSTRAINT attempt_pkey PRIMARY KEY (strudent_id, exam_id);


--
-- TOC entry 3380 (class 2606 OID 16554)
-- Name: course_offering course_offering_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_offering
    ADD CONSTRAINT course_offering_pkey PRIMARY KEY (offering_id);


--
-- TOC entry 3377 (class 2606 OID 16547)
-- Name: course course_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_pkey PRIMARY KEY (coourse_id);


--
-- TOC entry 3383 (class 2606 OID 16561)
-- Name: course_register course_register_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_register
    ADD CONSTRAINT course_register_pkey PRIMARY KEY (registration_id);


--
-- TOC entry 3386 (class 2606 OID 16568)
-- Name: department department_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_pkey PRIMARY KEY (department_id);


--
-- TOC entry 3389 (class 2606 OID 16575)
-- Name: exam exam_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exam
    ADD CONSTRAINT exam_pkey PRIMARY KEY (exam_id);


--
-- TOC entry 3392 (class 2606 OID 16582)
-- Name: lecture lecture_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lecture
    ADD CONSTRAINT lecture_pkey PRIMARY KEY (lecture_id);


--
-- TOC entry 3395 (class 2606 OID 16587)
-- Name: prerequirest prerequirest_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prerequirest
    ADD CONSTRAINT prerequirest_pkey PRIMARY KEY (course_id, req_course_id);


--
-- TOC entry 3398 (class 2606 OID 16594)
-- Name: question question_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT question_pkey PRIMARY KEY (q_id);


--
-- TOC entry 3401 (class 2606 OID 16601)
-- Name: resitration resitration_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resitration
    ADD CONSTRAINT resitration_pkey PRIMARY KEY (registration_id);


--
-- TOC entry 3404 (class 2606 OID 16608)
-- Name: staff staff_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.staff
    ADD CONSTRAINT staff_pkey PRIMARY KEY (staff_id);


--
-- TOC entry 3407 (class 2606 OID 16615)
-- Name: stored question stored question_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."stored question"
    ADD CONSTRAINT "stored question_pkey" PRIMARY KEY (q_id);


--
-- TOC entry 3410 (class 2606 OID 16624)
-- Name: student student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (student_id);


--
-- TOC entry 3412 (class 2606 OID 16629)
-- Name: teach teach_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teach
    ADD CONSTRAINT teach_pkey PRIMARY KEY (lecture_id, offering_id);


--
-- TOC entry 3384 (class 1259 OID 16739)
-- Name: idx_course_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_course_id ON public.course_register USING btree (offering_id);


--
-- TOC entry 3378 (class 1259 OID 16737)
-- Name: idx_department_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_department_id ON public.course USING btree (department_id);


--
-- TOC entry 3402 (class 1259 OID 16745)
-- Name: idx_department_staff; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_department_staff ON public.staff USING btree (department_id);


--
-- TOC entry 3375 (class 1259 OID 16736)
-- Name: idx_exam_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_exam_id ON public.attempt USING btree (exam_id);


--
-- TOC entry 3396 (class 1259 OID 16743)
-- Name: idx_exam_id_question; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_exam_id_question ON public.question USING btree (exam_id);


--
-- TOC entry 3387 (class 1259 OID 16740)
-- Name: idx_hod; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_hod ON public.department USING btree (hod);


--
-- TOC entry 3405 (class 1259 OID 16746)
-- Name: idx_lecture_id_question; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_lecture_id_question ON public."stored question" USING btree (lecture_id);


--
-- TOC entry 3408 (class 1259 OID 16747)
-- Name: idx_lecture_id_student; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_lecture_id_student ON public.student USING btree (lecture_id);


--
-- TOC entry 3381 (class 1259 OID 16738)
-- Name: idx_offering_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_offering_id ON public.course_offering USING btree (offering_id);


--
-- TOC entry 3393 (class 1259 OID 16742)
-- Name: idx_prereq_course; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_prereq_course ON public.prerequirest USING btree (req_course_id);


--
-- TOC entry 3390 (class 1259 OID 16741)
-- Name: idx_staff; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_staff ON public.lecture USING btree (satff_id);


--
-- TOC entry 3372 (class 1259 OID 16735)
-- Name: idx_staff_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_staff_id ON public.ar USING btree (staff_id);


--
-- TOC entry 3399 (class 1259 OID 16744)
-- Name: idx_student_id_registration; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_student_id_registration ON public.resitration USING btree (student_id);


--
-- TOC entry 3413 (class 2606 OID 16630)
-- Name: ar ar_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ar
    ADD CONSTRAINT ar_ibfk_1 FOREIGN KEY (staff_id) REFERENCES public.staff(staff_id);


--
-- TOC entry 3414 (class 2606 OID 16635)
-- Name: attempt attempt_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.attempt
    ADD CONSTRAINT attempt_ibfk_1 FOREIGN KEY (strudent_id) REFERENCES public.student(student_id);


--
-- TOC entry 3415 (class 2606 OID 16640)
-- Name: attempt attempt_ibfk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.attempt
    ADD CONSTRAINT attempt_ibfk_2 FOREIGN KEY (exam_id) REFERENCES public.exam(exam_id);


--
-- TOC entry 3417 (class 2606 OID 16650)
-- Name: course_offering cordinater_side; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_offering
    ADD CONSTRAINT cordinater_side FOREIGN KEY (admin_cordinate_id) REFERENCES public.admin_cordinator(admin_cordinater_id);


--
-- TOC entry 3416 (class 2606 OID 16645)
-- Name: course course_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_ibfk_1 FOREIGN KEY (department_id) REFERENCES public.department(department_id);


--
-- TOC entry 3418 (class 2606 OID 16655)
-- Name: course_offering course_offering_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_offering
    ADD CONSTRAINT course_offering_ibfk_1 FOREIGN KEY (course_cordinater) REFERENCES public.lecture(lecture_id);


--
-- TOC entry 3419 (class 2606 OID 16660)
-- Name: course_offering course_side; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_offering
    ADD CONSTRAINT course_side FOREIGN KEY (course_id) REFERENCES public.course(coourse_id);


--
-- TOC entry 3422 (class 2606 OID 16675)
-- Name: department department_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_ibfk_1 FOREIGN KEY (hod) REFERENCES public.staff(staff_id);


--
-- TOC entry 3423 (class 2606 OID 16680)
-- Name: exam exam_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exam
    ADD CONSTRAINT exam_ibfk_1 FOREIGN KEY (offering_id) REFERENCES public.course_offering(offering_id);


--
-- TOC entry 3424 (class 2606 OID 16685)
-- Name: lecture lecture_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lecture
    ADD CONSTRAINT lecture_ibfk_1 FOREIGN KEY (satff_id) REFERENCES public.staff(staff_id);


--
-- TOC entry 3420 (class 2606 OID 16665)
-- Name: course_register offering_side; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_register
    ADD CONSTRAINT offering_side FOREIGN KEY (offering_id) REFERENCES public.course_offering(offering_id);


--
-- TOC entry 3425 (class 2606 OID 16690)
-- Name: prerequirest prerequirest_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prerequirest
    ADD CONSTRAINT prerequirest_ibfk_1 FOREIGN KEY (req_course_id) REFERENCES public.course(coourse_id);


--
-- TOC entry 3426 (class 2606 OID 16695)
-- Name: question question_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT question_ibfk_1 FOREIGN KEY (exam_id) REFERENCES public.exam(exam_id);


--
-- TOC entry 3421 (class 2606 OID 16670)
-- Name: course_register register_side; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_register
    ADD CONSTRAINT register_side FOREIGN KEY (registration_id) REFERENCES public.resitration(registration_id);


--
-- TOC entry 3427 (class 2606 OID 16700)
-- Name: resitration resitration_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resitration
    ADD CONSTRAINT resitration_ibfk_1 FOREIGN KEY (ar_id) REFERENCES public.ar(ar_id);


--
-- TOC entry 3428 (class 2606 OID 16705)
-- Name: resitration resitration_ibfk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resitration
    ADD CONSTRAINT resitration_ibfk_2 FOREIGN KEY (student_id) REFERENCES public.student(student_id);


--
-- TOC entry 3429 (class 2606 OID 16710)
-- Name: staff staff_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.staff
    ADD CONSTRAINT staff_ibfk_1 FOREIGN KEY (department_id) REFERENCES public.department(department_id);


--
-- TOC entry 3430 (class 2606 OID 16715)
-- Name: stored question stored_question_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."stored question"
    ADD CONSTRAINT stored_question_ibfk_1 FOREIGN KEY (lecture_id) REFERENCES public.lecture(lecture_id);


--
-- TOC entry 3431 (class 2606 OID 16720)
-- Name: student student_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_ibfk_1 FOREIGN KEY (departmnet_id) REFERENCES public.department(department_id);


--
-- TOC entry 3432 (class 2606 OID 16725)
-- Name: student student_ibfk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_ibfk_2 FOREIGN KEY (lecture_id) REFERENCES public.lecture(lecture_id);


--
-- TOC entry 3433 (class 2606 OID 16730)
-- Name: teach teach_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teach
    ADD CONSTRAINT teach_ibfk_1 FOREIGN KEY (offering_id) REFERENCES public.course_offering(offering_id);


-- Completed on 2025-02-10 12:16:52 +0530

--
-- PostgreSQL database dump complete
--

