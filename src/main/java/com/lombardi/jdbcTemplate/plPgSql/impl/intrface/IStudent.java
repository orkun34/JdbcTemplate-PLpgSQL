package com.lombardi.jdbcTemplate.plPgSql.impl.intrface;

import com.lombardi.jdbcTemplate.plPgSql.dao.model.Student;

import java.util.List;

/**
 * @author orkun
 */

public interface IStudent {

    void simpleJdbcInsert(Student student);

    void registerStudent(Student student);

    void registerStudentWithStoredProcedure(Student student);

    List<Student> retrieveEngineeringStudentWithView();

    List<Student> retrieveStudentByNameWithQueryObject(String name);

    double calculateAvgAgeOfStudentsByArea(String studyArea);

    int unregisterStudent(long studentId);



}
