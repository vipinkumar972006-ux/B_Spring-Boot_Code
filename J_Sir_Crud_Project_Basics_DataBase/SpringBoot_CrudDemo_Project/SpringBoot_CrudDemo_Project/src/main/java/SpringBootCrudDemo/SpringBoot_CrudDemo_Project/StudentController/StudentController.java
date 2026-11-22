package SpringBootCrudDemo.SpringBoot_CrudDemo_Project.StudentController;

import SpringBootCrudDemo.SpringBoot_CrudDemo_Project.StudentEntity.Student_Information;
import SpringBootCrudDemo.SpringBoot_CrudDemo_Project.StudentService.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private final StudentService studentService;

    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student/create")
    public ResponseEntity<Student_Information> createStudent(@RequestBody Student_Information student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(student));
    }

    @GetMapping("/student/get/{id}")
    public ResponseEntity<Student_Information> getStudent(@PathVariable Long id) {
        Student_Information student = studentService.getStudent_Information(id);
        return student == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(student);
    }

    @GetMapping("/student/get")
    public ResponseEntity<List<Student_Information>> getAllStudents() {
        List<Student_Information> students = studentService.getAllStudent_Information();
        return students.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(students);
    }

    @PutMapping("/student/update/{id}")
    public ResponseEntity<Student_Information> updateStudent(@PathVariable Long id,
                                                               @RequestBody Student_Information studentReq) {
        Student_Information student = studentService.updateStudent_Information(id, studentReq);
        return student == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(student);
    }

    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        if (!studentService.deleteStudentSoftly(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record deleted");
    }
    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<String> deleteStudentSoftly(@PathVariable Long id)
    {
        Boolean isDeleted=studentService.deleteStudentSoftly(id);
        if(!isDeleted)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record deleted");
    }
}
