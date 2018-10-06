package app.learn.spring.jpa.serviceImpl;

import app.learn.spring.jpa.entity.Course;
import app.learn.spring.jpa.repository.CourseRepository;
import app.learn.spring.jpa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

  @Autowired
  private CourseRepository courseRepository;

  @Override
  public List<Course> findAllCourse() {
    return courseRepository.findAll();
  }
}
