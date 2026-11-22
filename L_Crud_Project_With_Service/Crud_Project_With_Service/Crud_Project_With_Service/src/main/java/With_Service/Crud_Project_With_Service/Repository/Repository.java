package With_Service.Crud_Project_With_Service.Repository;

import With_Service.Crud_Project_With_Service.Entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Entity,Long>
{

}
