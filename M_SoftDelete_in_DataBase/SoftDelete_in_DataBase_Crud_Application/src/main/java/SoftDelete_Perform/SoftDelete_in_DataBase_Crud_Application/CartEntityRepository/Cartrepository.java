package SoftDelete_Perform.SoftDelete_in_DataBase_Crud_Application.CartEntityRepository;

import SoftDelete_Perform.SoftDelete_in_DataBase_Crud_Application.CartEntity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cartrepository extends JpaRepository<CartEntity,Long>
{

}
