package com.lombardi.jdbcTemplate.plPgSql.dao.model.intrface;

import com.lombardi.jdbcTemplate.plPgSql.dao.model.Exam;

public interface ExamDAO {

    void registerExam(Exam exam);

    int unregisterExam(long examId);

    int updateExamRecord(Exam exam);

}
