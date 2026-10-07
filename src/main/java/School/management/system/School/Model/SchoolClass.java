package School.management.system.School.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "classes")
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String className;
    private String section;
    private String teacherName;

    public SchoolClass() {
    }

    public SchoolClass(String className, String section, String teacherName) {
        this.className = className;
        this.section = section;
        this.teacherName = teacherName;
    }

    public Long getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}