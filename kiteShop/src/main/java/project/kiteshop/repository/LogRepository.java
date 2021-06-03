package project.kiteshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.kiteshop.models.entities.LogEntity;

@Repository
public interface LogRepository extends JpaRepository<LogEntity, Long> {
}
