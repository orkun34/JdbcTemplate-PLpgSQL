package com.lombardi.jdbcTemplate.plPgSql.dao.model.intrface;

import com.lombardi.jdbcTemplate.plPgSql.dao.model.Student;

import java.util.List;

public interface StudentDAO {

    void registerStudent(Student student);

    void registerStudentWithStoredProcedure(Student student);

    List<Student> retrieveEngineeringStudentWithView();

    int unregisterStudent(long studentId);
}
