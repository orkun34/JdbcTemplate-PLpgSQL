-- DROP SCHEMA public;

--CREATE SCHEMA public AUTHORIZATION postgres;

--COMMENT ON SCHEMA public IS 'standard public schema'

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

CREATE OR REPLACE PROCEDURE public.add_student(s_name character varying, s_area character varying, s_age integer)
 LANGUAGE plpgsql
AS $procedure$
	-- Enter function body here
begin
	insert into STUDENT values (nextval('student_s_id_seq'),s_name,s_area,s_age);
end
 $procedure$
;

CREATE OR REPLACE VIEW public.list_engineer
AS SELECT student.s_id,
    student.s_name,
    student.s_area,
    student.s_age
   FROM student
  WHERE student.s_area::text ~~ '%Engineer%'::text;

-- Permissions

ALTER TABLE public.list_engineer OWNER TO postgres;
GRANT ALL ON TABLE public.list_engineer TO postgres;

CREATE OR REPLACE FUNCTION public.avg_age_by_area(pi_s_area character varying)
 RETURNS bigint
 LANGUAGE plpgsql
AS $function$
	-- Enter function body here
	declare
		s_avg_age int8;
	-- Enter function body here
	begin
		select avg(s_age) into s_avg_age from student where s_area like '%'||pi_s_area||'%';
		return s_avg_age;
	end;
	$function$
;

INSERT INTO STUDENT VALUES (nextval('student_s_id_seq'),'Jack','Software Engineer',23);
commit;