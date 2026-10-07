
package School.management.system.School.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teacherNo;
    private String fullName;
    private String gender;
    private String phone;
    private String subject;
    private String email;

    public Teacher() {
    }

    public Teacher(String teacherNo, String fullName, String gender,
                   String phone, String subject, String email) {
        this.teacherNo = teacherNo;
        this.fullName = fullName;
        this.gender = gender;
        this.phone = phone;
        this.subject = subject;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getTeacherNo() {
        return teacherNo;
    }
    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = email;
    }
}

