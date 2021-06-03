package project.kiteshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.kiteshop.models.entities.BrandEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {

    Optional<BrandEntity> findByName(String name);

    @Query("SELECT b.name FROM BrandEntity as b")
    List<String> findAllBrandNames();
}
