package app.learn.spring.jpa;

import app.learn.spring.jpa.entity.Course;
import app.learn.spring.jpa.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
@RestController
@Slf4j
public class SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}


	@Autowired
	private CourseService courseService;

	@GetMapping("/")
	public List<Course> getCourseName() {
		log.info(courseService.findAllCourse().toString());
		return courseService.findAllCourse();
	}
}
