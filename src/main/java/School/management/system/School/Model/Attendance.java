package School.management.system.School.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String admissionNo;
    private String studentName;
    private String className;
    private String date;
    private String status;

    public Attendance() {
    }

    public Attendance(String admissionNo, String studentName,
                      String className, String date, String status) {
        this.admissionNo = admissionNo;
        this.studentName = studentName;
        this.className = className;
        this.date = date;
        this.status = status;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}