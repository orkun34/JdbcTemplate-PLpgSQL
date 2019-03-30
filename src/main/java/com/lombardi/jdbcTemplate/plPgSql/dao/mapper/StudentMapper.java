package com.lombardi.jdbcTemplate.plPgSql.dao.mapper;

import com.lombardi.jdbcTemplate.plPgSql.dao.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student(resultSet.getString("s_name")
                                    , resultSet.getInt("s_age")
                                    , resultSet.getString("s_area"));
        student.setStudentId(resultSet.getLong("s_id"));

        return student;
    }
}
