package app.learn.spring.jpa.service;

import app.learn.spring.jpa.entity.Course;

import java.util.Date;
import java.util.List;

public interface CourseService {

  List<Course> findAllCourse();

  Course findByCode(String code);

  Course findByName(String name);

  List<Course> findCourseByStartBatchBetweenDate(Date firstDate, Date lastDate);
}
