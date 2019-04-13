FROM java:8
EXPOSE 8282
ADD ./target/JdbcTemplate-PLpgSQL-1.0-SNAPSHOT.jar JdbcTemplate-PLpgSQL-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.profiles.active=container","-jar","JdbcTemplate-PLpgSQL-1.0-SNAPSHOT.jar"]
CMD java -jar ./target/JdbcTemplate-PLpgSQL-1.0-SNAPSHOT.jar