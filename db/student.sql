-- Drop table

-- DROP TABLE public.student;

CREATE TABLE public.student (
	s_id serial NOT NULL,
	s_name varchar NULL,
	s_area varchar NULL,
	s_age int4 NULL,
	CONSTRAINT student_pk PRIMARY KEY (s_id)
);

-- Permissions

ALTER TABLE public.student OWNER TO postgres;
GRANT ALL ON TABLE public.student TO postgres;
ALTER TABLE public.student ADD CONSTRAINT student_pk PRIMARY KEY (s_id)