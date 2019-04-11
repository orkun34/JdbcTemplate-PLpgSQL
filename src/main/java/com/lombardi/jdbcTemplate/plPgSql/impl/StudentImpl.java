package com.lombardi.jdbcTemplate.plPgSql.impl;

import com.lombardi.jdbcTemplate.plPgSql.dao.StudentDAOImpl;
import com.lombardi.jdbcTemplate.plPgSql.dao.model.Student;
import com.lombardi.jdbcTemplate.plPgSql.impl.intrface.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author orkun
 */

@Component
public class StudentImpl implements IStudent {

    @Autowired
    StudentDAOImpl studentDAOImpl;

    @Transactional
    public void simpleJdbcInsert(Student student){
        studentDAOImpl.simpleJdbcInsert(student);
    }

    @Transactional
    public void registerStudent(Student student) {
        studentDAOImpl.registerStudent(student);
    }

    @Transactional
    public void registerStudentWithStoredProcedure(Student student) {
        studentDAOImpl.registerStudentWithStoredProcedure(student);
    }

    public List<Student> retrieveEngineeringStudentWithView() {
        return studentDAOImpl.retrieveEngineeringStudentWithView();
    }

    public List<Student> retrieveStudentByNameWithQueryObject(String name) {
        return studentDAOImpl.retrieveStudentByNameWithQueryObject(name);
    }

    public double calculateAvgAgeOfStudentsByArea(String studyArea) {
        return studentDAOImpl.calculateAvgAgeOfStudentsByArea(studyArea);
    }

    @Transactional
    public int unregisterStudent(long studentId) {
        return studentDAOImpl.unregisterStudent(studentId);
    }


}
