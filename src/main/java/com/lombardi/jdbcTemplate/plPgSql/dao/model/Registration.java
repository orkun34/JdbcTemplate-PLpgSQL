package com.lombardi.jdbcTemplate.plPgSql.dao.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Registration {

    private long registerId;
    private long registeredStudentId;
    private long registeredExamId;

}
