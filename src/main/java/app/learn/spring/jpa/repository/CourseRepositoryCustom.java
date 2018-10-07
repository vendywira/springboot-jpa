package app.learn.spring.jpa.repository;

import app.learn.spring.jpa.entity.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CourseRepositoryCustom {

  @Query("select c from Course c where c.id in " +
      "(select b.course from Batch b " +
      "where b.startBatch between :firstDate and :lastDate)")
  List<Course> getCourseBaseOnStartDateBetweenDate(
      @Param("firstDate") Date firstDate,
      @Param("lastDate") Date lastDate);
}
