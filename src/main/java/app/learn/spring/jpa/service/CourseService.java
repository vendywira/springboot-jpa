package app.learn.spring.jpa.service;

import app.learn.spring.jpa.entity.Course;
import java.util.List;

public interface CourseService {

  List<Course> findAllCourse();
}
