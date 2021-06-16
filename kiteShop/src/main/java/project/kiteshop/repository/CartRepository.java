package project.kiteshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.kiteshop.models.entities.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
}
