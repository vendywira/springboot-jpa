package app.learn.spring.jpa.repository;

import app.learn.spring.jpa.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends JpaRepository<Batch, String> {
}
