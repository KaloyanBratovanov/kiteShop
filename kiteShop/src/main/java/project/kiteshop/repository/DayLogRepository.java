package project.kiteshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.kiteshop.models.entities.DayLogEntity;

import java.util.List;

@Repository
public interface DayLogRepository extends JpaRepository<DayLogEntity, Long> {

    @Query("SELECT d.number FROM DayLogEntity as d order by d.localDate desc ")
    List<Integer> findFirstSeven();


}
