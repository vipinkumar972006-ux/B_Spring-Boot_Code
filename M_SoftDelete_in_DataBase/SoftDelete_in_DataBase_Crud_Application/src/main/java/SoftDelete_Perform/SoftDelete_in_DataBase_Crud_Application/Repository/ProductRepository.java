package SoftDelete_Perform.SoftDelete_in_DataBase_Crud_Application.Repository;

import SoftDelete_Perform.SoftDelete_in_DataBase_Crud_Application.Entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Entity, Long>
{
    Optional<Entity> findByIdAndIsDeletedFalse(Long id);
    List<Entity> findByIsDeletedFalse();

    boolean existsByIdAndIsDeletedFalse(Long id);

    List<Entity> findByProductnameContainingIgnoreCaseAndIsDeletedFalse(String name);
}
