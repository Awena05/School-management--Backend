package School.management.system.School.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String zanzibarId;

    @Column(nullable = false, unique = true)
    private String employeeNumber;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = true)
    private String password;

    @Column(nullable = true)
    private String role;

    public User() {
    }

    public User(
            String zanzibarId,
            String employeeNumber,
            String fullName,
            String password,
            String role) {

        this.zanzibarId = zanzibarId;
        this.employeeNumber = employeeNumber;
        this.fullName = fullName;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZanzibarId() {
        return zanzibarId;
    }

    public void setZanzibarId(String zanzibarId) {
        this.zanzibarId = zanzibarId;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}