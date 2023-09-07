import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentH2Service {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentH2Service(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public int addBulkStudents(List<Student> students) {
        List<Student> savedStudents = studentRepository.saveAll(students);
        return savedStudents.size();
    }

    public Student getStudentById(int studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
    }

    public Student updateStudent(int studentId, Student updatedStudent) {
        if (!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException(studentId);
        }
        updatedStudent.setStudentId(studentId);
        return studentRepository.save(updatedStudent);
    }

    public void deleteStudent(int studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException(studentId);
        }
        studentRepository.deleteById(studentId);
    }
}
