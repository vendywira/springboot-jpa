#Springboot with JPA
this is a simple project for learn CRUD with JPA.

- add dependency maven like below :

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <!-- change postgres driver when you used another dbms-->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
    </dependency>
</dependencies>
```

- Create Application.properties on resources directory
```properties
## Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.url=jdbc:postgresql://localhost:5432/dbName
spring.datasource.username=username
spring.datasource.password=password
spring.jpa.generate-ddl=true
spring.jpa.show-sql=true

# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = validate
```

- on main class add annotation like below for enable jpa repository
```java
@SpringBootApplication
@EnableJpaRepositories
public class SpringJpaApplication {

}
```

- for simple query you can use query method. jpa can query base on method name.
```java
@Repository
public interface CourseRepository extends JpaRepository<Course, String>, CourseRepositoryCustom {

  // query will get course base on their code
  Course findByCode(String code);

  Course findByName(String name);
}
```

- you also can create custom repository where need complex query join some table etc.
```java
public interface CourseRepositoryCustom {

  @Query("select c from Course c where c.id in " +
      "(select b.course from Batch b " +
      "where b.startBatch between :firstDate and :lastDate)")
  List<Course> getCourseBaseOnStartDateBetweenDate(
      @Param("firstDate") Date firstDate,
      @Param("lastDate") Date lastDate);
}
```
Note : where `Batch` (Entity on java class) and `startBatch` (field) must be match and sensitive case with your java class.
 