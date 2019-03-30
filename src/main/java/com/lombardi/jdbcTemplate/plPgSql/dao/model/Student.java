package com.lombardi.jdbcTemplate.plPgSql.dao.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student {

    private long studentId;
    private String name;
    private int age;
    private String studyArea;

    public Student(String name, int age, String studyArea) {
        this.name = name;
        this.age = age;
        this.studyArea = studyArea;
    }
}
