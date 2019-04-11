package com.lombardi.jdbcTemplate.plPgSql.dao.model.intrface;

import com.lombardi.jdbcTemplate.plPgSql.dao.model.Student;

import java.util.List;

public interface StudentDAO {

    void simpleJdbcInsert(Student student);

    void registerStudent(Student student);

    void registerStudentWithStoredProcedure(Student student);

    List<Student> retrieveEngineeringStudentWithView();

    List<Student> retrieveStudentByNameWithQueryObject(String name);

    double calculateAvgAgeOfStudentsByArea(String studyArea);

    int unregisterStudent(long studentId);
}
