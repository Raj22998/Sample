import java.util.ArrayList;
import java.util.List;

import com.example.school.model.Student;
import com.example.school.service.StudentH2Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentH2Service studentService;

    @Autowired
    public StudentController(StudentH2Service studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student addedStudent = studentService.addStudent(student);
        return new ResponseEntity<>(addedStudent, HttpStatus.CREATED);
    }

    @PostMapping("/bulk")
    public ResponseEntity<String> addBulkStudents(@RequestBody ArrayList<Student> students) {
        int numAdded = studentService.addBulkStudents(students);
        return new ResponseEntity<>("Added " + numAdded + " students", HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable int studentId, @RequestBody Student updatedStudent) {
        return studentService.updateStudent(studentId, updatedStudent);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>("Student with ID " + studentId + " deleted", HttpStatus.NO_CONTENT);
    }
}
