package SpringBootCrudDemo.SpringBoot_CrudDemo_Project.StudentRepository;

import SpringBootCrudDemo.SpringBoot_CrudDemo_Project.StudentEntity.Student_Information;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


//@Repository
public interface StudentRepository extends JpaRepository<Student_Information,Long>
{
    Optional<Student_Information> findByIdAndDeletedFalseOrIdAndDeletedIsNull(Long id, Long nullDeletedId);
    List<Student_Information> findAllByDeletedFalseOrDeletedIsNull();
}
