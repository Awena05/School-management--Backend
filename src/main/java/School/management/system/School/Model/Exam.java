package School.management.system.School.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String admissionNo;
    private String studentName;
    private String className;
    private String subject;
    private double marks;
    private String grade;
    private String examType;

    public Exam() {
    }

    public Exam(String admissionNo, String studentName, String className,
                String subject, double marks, String grade, String examType) {
        this.admissionNo = admissionNo;
        this.studentName = studentName;
        this.className = className;
        this.subject = subject;
        this.marks = marks;
        this.grade = grade;
        this.examType = examType;
    }

    public Long getId() {
        return id;
    }

    public String getAdmissionNo() {
        return admissionNo;
    }

    public void setAdmissionNo(String admissionNo) {
        this.admissionNo = admissionNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }
}