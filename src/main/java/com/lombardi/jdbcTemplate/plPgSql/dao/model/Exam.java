package com.lombardi.jdbcTemplate.plPgSql.dao.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Exam {

    private long examId;
    private String examName;
    private int examLimit;
}
