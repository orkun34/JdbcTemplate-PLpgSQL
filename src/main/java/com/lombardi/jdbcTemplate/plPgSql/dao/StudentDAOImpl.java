package com.lombardi.jdbcTemplate.plPgSql.dao;

import com.lombardi.jdbcTemplate.plPgSql.dao.mapper.StudentMapper;
import com.lombardi.jdbcTemplate.plPgSql.dao.model.Student;
import com.lombardi.jdbcTemplate.plPgSql.dao.model.intrface.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void registerStudentWithStoredProcedure(Student student) {
        jdbcTemplate.update("call add_student(?,?)", student.getName(), student.getStudyArea());
    }

    public void registerStudent(Student student) {
        jdbcTemplate.update("insert into student(s_id,s_name,s_age,s_area) values (nextval('student_s_id_seq'),?,?,?)"
                , student.getName()
                , student.getAge()
                , student.getStudyArea());
    }

    public List<Student> retrieveEngineeringStudentWithView() {
        return jdbcTemplate.query("select * from list_engineer", new StudentMapper());
    }




}
