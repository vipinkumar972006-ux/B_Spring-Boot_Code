package SpringBootCrudDemo.SpringBoot_CrudDemo_Project.StudentService;

import SpringBootCrudDemo.SpringBoot_CrudDemo_Project.StudentEntity.Student_Information;
import SpringBootCrudDemo.SpringBoot_CrudDemo_Project.StudentRepository.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentService
{
    private StudentRepository studentRepository;
    StudentService(StudentRepository studentRepository)
    {
        this.studentRepository=studentRepository;
    }
    public Student_Information createStudent(Student_Information student_information)
    {
        student_information.setDeleted(false);
        Student_Information student_information1 = studentRepository.save(student_information);
        return student_information1;
    }
    public Student_Information getStudent_Information(Long id)
    {
        Optional<Student_Information> studentResp=studentRepository.findByIdAndDeletedFalseOrIdAndDeletedIsNull(id, id);
        if(studentResp.isPresent())
        {
            return studentResp.get();
        }
        return null;
    }
    public List<Student_Information> getAllStudent_Information()
    {
        List<Student_Information> studentList=studentRepository.findAllByDeletedFalseOrDeletedIsNull();
        return studentList;
    }
    public Student_Information updateStudent_Information(Long Id,Student_Information studentReq)
    {
        Optional<Student_Information> existingStudent=studentRepository.findByIdAndDeletedFalseOrIdAndDeletedIsNull(Id, Id);
        if(existingStudent.isEmpty())
        {
            return null;
        }
        Student_Information  studentTosave = existingStudent.get();
        studentTosave.setName(studentReq.getName());
        studentTosave.setRollNo(studentReq.getRollNo());
        studentTosave.setSubject(studentReq.getSubject());
        studentTosave.setEmail(studentReq.getEmail());
        studentTosave.setAge(studentReq.getAge());

        studentTosave.setDeleted(false);
        return studentRepository.save(studentTosave);
    }
    public Boolean deleteStudentSoftly(Long id)
    {
        Optional<Student_Information> existingStudent = studentRepository
                .findByIdAndDeletedFalseOrIdAndDeletedIsNull(id, id);
        if(existingStudent.isEmpty())
        {
            return false;
        }
        Student_Information student = existingStudent.get();
        student.setDeleted(true);
        studentRepository.save(student);
        return true;
    }
}
