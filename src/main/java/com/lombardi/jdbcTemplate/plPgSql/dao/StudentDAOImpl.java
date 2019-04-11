package com.lombardi.jdbcTemplate.plPgSql.dao;

import com.lombardi.jdbcTemplate.plPgSql.dao.mapper.StudentMapper;
import com.lombardi.jdbcTemplate.plPgSql.dao.model.Student;
import com.lombardi.jdbcTemplate.plPgSql.dao.model.intrface.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author orkun
 */

@Component
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    private SimpleJdbcInsert simpleJdbcInsert;


    @PostConstruct
    private void postConstruct() {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("student").usingGeneratedKeyColumns("s_id");
    }

    /**
     * SimpleJdbcInsert usage
     *
     * @param student
     */
    public void simpleJdbcInsert(Student student) {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("s_name", student.getName());
        parameters.put("s_area", student.getStudyArea());
        parameters.put("s_age", student.getAge());

        simpleJdbcInsert.execute(parameters);
    }


    /**
     * SQL StoredProcedure call
     *
     * @param student
     */
    public void registerStudentWithStoredProcedure(Student student) {
        jdbcTemplate.update("call add_student(?,?,?)", student.getName(), student.getStudyArea(), student.getAge());
    }

    /**
     * PL/SQL generic insert
     *
     * @param student
     */
    public void registerStudent(Student student) {
        jdbcTemplate.update("insert into student(s_id,s_name,s_age,s_area) values (nextval('student_s_id_seq'),?,?,?)"
                , student.getName()
                , student.getAge()
                , student.getStudyArea());
    }

    /**
     * Gathering engineer students by View
     *
     * @return
     */
    public List<Student> retrieveEngineeringStudentWithView() {
        return jdbcTemplate.query("select * from list_engineer", new StudentMapper());
    }

    /**
     * Can be done with BeanPropertyMapper but POJO model is not same with DB model
     * @param name
     * @return
     */
    public List<Student> retrieveStudentByNameWithQueryObject(String name) {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from student where s_name like ?", name);

        List<Student> studentList = new ArrayList<>();
        for (Map<String,Object> maps : rows){
            Student student = new Student();
            student.setAge(Integer.valueOf(String.valueOf(maps.get("s_age"))));
            student.setName(String.valueOf(maps.get("s_name")));
            student.setStudyArea(String.valueOf(maps.get("s_area")));
            studentList.add(student);
        }
        return studentList;
    }

    /**
     * Function call with in/out parameter
     * @param studyArea
     * @return
     */
    public double calculateAvgAgeOfStudentsByArea(String studyArea) {
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withFunctionName("avg_age_by_area");

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("pi_s_area",studyArea);
        return call.executeFunction(Float.class,sqlParameterSource);
    }

    /**
     * PL/SQL generic deletion
     *
     * @param studentId
     * @return
     */
    public int unregisterStudent(long studentId) {
        return jdbcTemplate.update("delete from student where S_ID = ? ", new Object[]{studentId});
    }

}
