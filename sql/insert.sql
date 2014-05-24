--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.4
-- Started on 2014-05-24 12:00:50

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 7 (class 2615 OID 24577)
-- Name: test; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA test;


ALTER SCHEMA test OWNER TO postgres;

SET search_path = test, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 176 (class 1259 OID 24616)
-- Name: comment; Type: TABLE; Schema: test; Owner: postgres; Tablespace: 
--

CREATE TABLE comment (
    "commentId" integer NOT NULL,
    "userId" integer,
    "messageId" integer,
    content text,
    "insertTime" timestamp with time zone,
    "updateTime" timestamp with time zone
);


ALTER TABLE test.comment OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 24614)
-- Name: comment_commentId_seq; Type: SEQUENCE; Schema: test; Owner: postgres
--

CREATE SEQUENCE "comment_commentId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE test."comment_commentId_seq" OWNER TO postgres;

--
-- TOC entry 1968 (class 0 OID 0)
-- Dependencies: 175
-- Name: comment_commentId_seq; Type: SEQUENCE OWNED BY; Schema: test; Owner: postgres
--

ALTER SEQUENCE "comment_commentId_seq" OWNED BY comment."commentId";


--
-- TOC entry 174 (class 1259 OID 24600)
-- Name: message; Type: TABLE; Schema: test; Owner: postgres; Tablespace: 
--

CREATE TABLE message (
    "messageId" integer NOT NULL,
    "userId" integer,
    content text,
    "insertTime" timestamp with time zone,
    "updateTime" timestamp with time zone
);


ALTER TABLE test.message OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 24598)
-- Name: message_messageId_seq; Type: SEQUENCE; Schema: test; Owner: postgres
--

CREATE SEQUENCE "message_messageId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE test."message_messageId_seq" OWNER TO postgres;

--
-- TOC entry 1969 (class 0 OID 0)
-- Dependencies: 173
-- Name: message_messageId_seq; Type: SEQUENCE OWNED BY; Schema: test; Owner: postgres
--

ALTER SEQUENCE "message_messageId_seq" OWNED BY message."messageId";


--
-- TOC entry 172 (class 1259 OID 24580)
-- Name: user; Type: TABLE; Schema: test; Owner: postgres; Tablespace: 
--

CREATE TABLE "user" (
    "userId" integer NOT NULL,
    password character varying(20),
    account character varying(20),
    name character varying,
    age integer,
    gender "char",
    hometown character varying,
    "insertTime" timestamp with time zone,
    "updateTime" timestamp with time zone
);


ALTER TABLE test."user" OWNER TO postgres;

--
-- TOC entry 1970 (class 0 OID 0)
-- Dependencies: 172
-- Name: COLUMN "user"."userId"; Type: COMMENT; Schema: test; Owner: postgres
--

COMMENT ON COLUMN "user"."userId" IS 'ユーザＩＤ';


--
-- TOC entry 171 (class 1259 OID 24578)
-- Name: user_userId_seq; Type: SEQUENCE; Schema: test; Owner: postgres
--

CREATE SEQUENCE "user_userId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE test."user_userId_seq" OWNER TO postgres;

--
-- TOC entry 1971 (class 0 OID 0)
-- Dependencies: 171
-- Name: user_userId_seq; Type: SEQUENCE OWNED BY; Schema: test; Owner: postgres
--

ALTER SEQUENCE "user_userId_seq" OWNED BY "user"."userId";


--
-- TOC entry 1841 (class 2604 OID 24619)
-- Name: commentId; Type: DEFAULT; Schema: test; Owner: postgres
--

ALTER TABLE ONLY comment ALTER COLUMN "commentId" SET DEFAULT nextval('"comment_commentId_seq"'::regclass);


--
-- TOC entry 1840 (class 2604 OID 24603)
-- Name: messageId; Type: DEFAULT; Schema: test; Owner: postgres
--

ALTER TABLE ONLY message ALTER COLUMN "messageId" SET DEFAULT nextval('"message_messageId_seq"'::regclass);


--
-- TOC entry 1839 (class 2604 OID 24583)
-- Name: userId; Type: DEFAULT; Schema: test; Owner: postgres
--

ALTER TABLE ONLY "user" ALTER COLUMN "userId" SET DEFAULT nextval('"user_userId_seq"'::regclass);


--
-- TOC entry 1963 (class 0 OID 24616)
-- Dependencies: 176
-- Data for Name: comment; Type: TABLE DATA; Schema: test; Owner: postgres
--



--
-- TOC entry 1972 (class 0 OID 0)
-- Dependencies: 175
-- Name: comment_commentId_seq; Type: SEQUENCE SET; Schema: test; Owner: postgres
--

SELECT pg_catalog.setval('"comment_commentId_seq"', 1, false);


--
-- TOC entry 1961 (class 0 OID 24600)
-- Dependencies: 174
-- Data for Name: message; Type: TABLE DATA; Schema: test; Owner: postgres
--



--
-- TOC entry 1973 (class 0 OID 0)
-- Dependencies: 173
-- Name: message_messageId_seq; Type: SEQUENCE SET; Schema: test; Owner: postgres
--

SELECT pg_catalog.setval('"message_messageId_seq"', 1, false);


--
-- TOC entry 1959 (class 0 OID 24580)
-- Dependencies: 172
-- Data for Name: user; Type: TABLE DATA; Schema: test; Owner: postgres
--



--
-- TOC entry 1974 (class 0 OID 0)
-- Dependencies: 171
-- Name: user_userId_seq; Type: SEQUENCE SET; Schema: test; Owner: postgres
--

SELECT pg_catalog.setval('"user_userId_seq"', 1, false);


--
-- TOC entry 1843 (class 2606 OID 24588)
-- Name: 主キー; Type: CONSTRAINT; Schema: test; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT "主キー" PRIMARY KEY ("userId");


--
-- TOC entry 1847 (class 2606 OID 24624)
-- Name: 主キー(comment); Type: CONSTRAINT; Schema: test; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY comment
    ADD CONSTRAINT "主キー(comment)" PRIMARY KEY ("commentId");


--
-- TOC entry 1845 (class 2606 OID 24608)
-- Name: 主キー(message); Type: CONSTRAINT; Schema: test; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY message
    ADD CONSTRAINT "主キー(message)" PRIMARY KEY ("messageId");


--
-- TOC entry 1850 (class 2606 OID 24630)
-- Name: 外部キー(comment->message); Type: FK CONSTRAINT; Schema: test; Owner: postgres
--

ALTER TABLE ONLY comment
    ADD CONSTRAINT "外部キー(comment->message)" FOREIGN KEY ("messageId") REFERENCES message("messageId");


--
-- TOC entry 1849 (class 2606 OID 24625)
-- Name: 外部キー(comment->user); Type: FK CONSTRAINT; Schema: test; Owner: postgres
--

ALTER TABLE ONLY comment
    ADD CONSTRAINT "外部キー(comment->user)" FOREIGN KEY ("userId") REFERENCES "user"("userId");


--
-- TOC entry 1848 (class 2606 OID 24609)
-- Name: 外部キー(user); Type: FK CONSTRAINT; Schema: test; Owner: postgres
--

ALTER TABLE ONLY message
    ADD CONSTRAINT "外部キー(user)" FOREIGN KEY ("userId") REFERENCES "user"("userId");


-- Completed on 2014-05-24 12:00:50

--
-- PostgreSQL database dump complete
--

