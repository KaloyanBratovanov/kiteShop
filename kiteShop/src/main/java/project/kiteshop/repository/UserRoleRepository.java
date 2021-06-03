package project.kiteshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.kiteshop.models.entities.UserRoleEntity;
import project.kiteshop.models.entities.enums.UserRole;

import java.util.Optional;


@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Long> {

    Optional<UserRoleEntity> findByRole(UserRole role);
}
