package com.lombardi.jdbcTemplate.plPgSql.main;


import com.lombardi.jdbcTemplate.plPgSql.config.DbConnection;
import com.lombardi.jdbcTemplate.plPgSql.dao.model.Student;
import com.lombardi.jdbcTemplate.plPgSql.impl.StudentImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

/**
 * @author orkun
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.lombardi.jdbcTemplate.plPgSql"})
public class App {

    public static void main(String[] args) {
        //SpringApplication.run(App.class, args);

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DbConnection.class);
        StudentImpl studentImpl = applicationContext.getBean(StudentImpl.class);

        /*Student student = new Student("Jack",23,"Civil Engineering");
        studentImpl.registerStudent(student);*/
        List<Student> studentList = studentImpl.retrieveEngineeringStudentWithView();
        for (Student s:studentList){
            System.out.println("Student Name: "+s.getName()+" Student Area: "+s.getStudyArea());
        }



    }
}
