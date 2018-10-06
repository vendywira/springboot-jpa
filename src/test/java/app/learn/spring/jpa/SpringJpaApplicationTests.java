package app.learn.spring.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(
		executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
		scripts = {
				"/data/course.sql",
				"/data/student.sql"
		}
)
public class SpringJpaApplicationTests {

	@Test
	public void contextLoads() {
	}

}
