package Spring_Boot_Demo.Service;

import Spring_Boot_Demo.Entity.Student;
import Spring_Boot_Demo.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService
{
    private StudentRepository studentRepository;

    /** Creates the service with its student repository dependency. */
    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository=studentRepository;
    }
    /** Creates a student in the repository. */
    public Student createStudent(Student studentReq)
    {
       return studentRepository.save(studentReq);
    }
    /** Returns the student with the given ID, or null when absent. */
    public Student getStudent(Long id)
    {
        return studentRepository.findById(id);
    }
    /** Returns every student. */
    public List<Student> getAllStudent()
    {
        return studentRepository.findAll();
    }

    /** Updates an existing student, or returns null when the ID is unknown. */
    public Student updateStudent(Long id, Student studentReq)
    {
        return studentRepository.update(id, studentReq);
    }

    /** Deletes a student and returns whether it existed. */
    public boolean deleteStudent(Long id)
    {
        return studentRepository.deleteById(id);
    }

    /** Searches student names using a case-insensitive partial match. */
    public List<Student> searchStudentsByName(String name)
    {
        return studentRepository.findByName(name);
    }

    /** Finds a student by email, ignoring letter case. */
    public Student getStudentByEmail(String email)
    {
        return studentRepository.findByEmail(email);
    }

    /** Returns the total number of students. */
    public int countStudents()
    {
        return studentRepository.count();
    }
}
