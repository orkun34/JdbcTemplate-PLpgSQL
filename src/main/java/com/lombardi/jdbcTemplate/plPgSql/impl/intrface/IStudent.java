package com.lombardi.jdbcTemplate.plPgSql.impl.intrface;

import com.lombardi.jdbcTemplate.plPgSql.dao.model.Student;

import java.util.List;

public interface IStudent {

    void registerStudent(Student student);

    void registerStudentWithStoredProcedure(Student student);

    List<Student> retrieveEngineeringStudentWithView();



}
