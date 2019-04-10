package com.lombardi.jdbcTemplate.plPgSql.dao.model.intrface;

public interface RegistrationDAO {

    void registerAccount(long examId,long studentId);

    int unregisterAccount(long registrationId);
}
