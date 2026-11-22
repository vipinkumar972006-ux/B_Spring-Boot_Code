package Spring_Boot_Demo.Controller;

import Spring_Boot_Demo.Entity.Student;
import Spring_Boot_Demo.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("")
public class StudentController
{
    private final StudentService studentService;

    /** Creates the controller with its student service dependency. */
    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }

    /** Creates a student and returns the saved record. */
    @PostMapping("/student/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student)
    {
        Student studentReq=studentService.createStudent(student);
        return ResponseEntity.ok(studentReq);
    }

    /** Returns a student by ID, or HTTP 404 when it does not exist. */
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id)
    {
        Student student = studentService.getStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    /** Returns all students. */
    @GetMapping("/getAll")
    public List<Student> getAll()
    {
       return studentService.getAllStudent();
    }

    /** Updates a student by ID, or returns HTTP 404 when it does not exist. */
    @PutMapping("/student/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student)
    {
        Student updatedStudent = studentService.updateStudent(id, student);
        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedStudent);
    }

    /** Deletes a student by ID, returning HTTP 204 or HTTP 404. */
    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id)
    {
        if (!studentService.deleteStudent(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    /** Searches students by a case-insensitive partial name. */
    @GetMapping("/student/search")
    public List<Student> searchStudentsByName(@RequestParam String name)
    {
        return studentService.searchStudentsByName(name);
    }

    /** Returns a student by email, or HTTP 404 when it does not exist. */
    @GetMapping("/student/email")
    public ResponseEntity<Student> getStudentByEmail(@RequestParam String email)
    {
        Student student = studentService.getStudentByEmail(email);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    /** Returns the total number of students. */
    @GetMapping("/student/count")
    public int countStudents()
    {
        return studentService.countStudents();
    }
}
