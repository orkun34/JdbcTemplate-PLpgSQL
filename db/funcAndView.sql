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
