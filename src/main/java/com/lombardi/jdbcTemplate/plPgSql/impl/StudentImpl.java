package com.lombardi.jdbcTemplate.plPgSql.impl;

import com.lombardi.jdbcTemplate.plPgSql.dao.StudentDAOImpl;
import com.lombardi.jdbcTemplate.plPgSql.dao.model.Student;
import com.lombardi.jdbcTemplate.plPgSql.impl.intrface.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentImpl implements IStudent {

    @Autowired
    StudentDAOImpl studentDAOImpl;

    public void registerStudent(Student student) {
        studentDAOImpl.registerStudent(student);
    }

    public void registerStudentWithStoredProcedure(Student student) {
        studentDAOImpl.registerStudentWithStoredProcedure(student);
    }

    public List<Student> retrieveEngineeringStudentWithView() {
        return studentDAOImpl.retrieveEngineeringStudentWithView();
    }


}
