package Spring_Boot_Demo.Repository;

import Spring_Boot_Demo.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class StudentRepository
{
    private Map<Long, Student> studentdatabase;

    /** Creates the in-memory student store. */
    public StudentRepository()
    {
        studentdatabase=new HashMap<>();
    }
    /** Adds a new student or replaces the student with the same ID. */
    public Student save(Student studentReq)
    {
        studentdatabase.put(studentReq.getId(),studentReq);
        return studentReq;
    }
    /** Finds one student by ID, or returns null when it does not exist. */
    public Student findById(Long id)
    {
        return studentdatabase.get(id);
    }
    /** Returns all students currently stored. */
    public List<Student> findAll()
    {
        return new ArrayList<>(studentdatabase.values());
    }

    /** Replaces an existing student while preserving the requested ID. */
    public Student update(Long id, Student studentReq)
    {
        if (!studentdatabase.containsKey(id)) {
            return null;
        }
        studentReq.setId(id);
        studentdatabase.put(id, studentReq);
        return studentReq;
    }

    /** Removes a student by ID and reports whether one was removed. */
    public boolean deleteById(Long id)
    {
        return studentdatabase.remove(id) != null;
    }

    /** Finds students whose names contain the supplied text, ignoring case. */
    public List<Student> findByName(String name)
    {
        String searchText = name == null ? "" : name.toLowerCase();
        return studentdatabase.values().stream()
                .filter(student -> student.getName() != null
                        && student.getName().toLowerCase().contains(searchText))
                .collect(Collectors.toList());
    }

    /** Finds a student by email, ignoring letter case. */
    public Student findByEmail(String email)
    {
        if (email == null) {
            return null;
        }
        return studentdatabase.values().stream()
                .filter(student -> email.equalsIgnoreCase(student.getEmail()))
                .findFirst()
                .orElse(null);
    }

    /** Returns the number of students currently stored. */
    public int count()
    {
        return studentdatabase.size();
    }
}
