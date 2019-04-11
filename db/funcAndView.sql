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

