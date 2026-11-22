package Crud_Project.Himself_Create_Crud_Project.Repository;

import Crud_Project.Himself_Create_Crud_Project.Entity.Employee_Information;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Repository extends JpaRepository<Employee_Information,Long>
{

}
