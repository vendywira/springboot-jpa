package app.learn.spring.jpa.repository;

import app.learn.spring.jpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String>, CourseRepositoryCustom {

  Course findByCode(String code);

  Course findByName(String name);
}
