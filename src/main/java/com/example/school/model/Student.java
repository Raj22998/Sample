package com.example.school.model;

@Entity
@Table(name = Student.STUDENT)
public class Student {
    static final String STUDENT = "student";

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "standard")
    private int standard;

    // Constructors
    public Student() {
    }

    public Student(String studentName, String gender, int standard) {
        this.studentName = studentName;
        this.gender = gender;
        this.standard = standard;
    }

    // Getter and Setter methods
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", standard=" + standard +
                '}';
    }
}
