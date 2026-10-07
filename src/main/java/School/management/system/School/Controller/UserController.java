package School.management.system.School.Controller;

import School.management.system.School.Model.User;
import School.management.system.School.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<?> createUser(
            @RequestBody UserRequest request) {

        if (request.getZanzibarId() == null ||
                request.getZanzibarId().trim().isEmpty()) {

            return ResponseEntity.badRequest()
                    .body("Zanzibar ID is required");
        }

        String zanzibarId =
                request.getZanzibarId().trim();

        if (!zanzibarId.matches("\\d{9}")) {

            return ResponseEntity.badRequest()
                    .body("Zanzibar ID must contain exactly 9 digits");
        }

        if (request.getEmployeeNumber() == null ||
                request.getEmployeeNumber().trim().isEmpty()) {

            return ResponseEntity.badRequest()
                    .body("Employee Number is required");
        }

        String employeeNumber =
                request.getEmployeeNumber().trim();

        if (!employeeNumber.matches("\\d{5}")) {

            return ResponseEntity.badRequest()
                    .body("Employee Number must contain exactly 5 digits");
        }

        if (request.getFullName() == null ||
                request.getFullName().trim().isEmpty()) {

            return ResponseEntity.badRequest()
                    .body("Full Name is required");
        }

        if (request.getPassword() == null ||
                request.getPassword().trim().isEmpty()) {

            return ResponseEntity.badRequest()
                    .body("Password is required");
        }

        if (request.getConfirmPassword() == null ||
                request.getConfirmPassword().trim().isEmpty()) {

            return ResponseEntity.badRequest()
                    .body("Confirm Password is required");
        }

        if (!request.getPassword()
                .equals(request.getConfirmPassword())) {

            return ResponseEntity.badRequest()
                    .body("Passwords do not match");
        }

        if (userRepository.existsByZanzibarId(zanzibarId)) {

            return ResponseEntity.badRequest()
                    .body("Zanzibar ID already exists");
        }

        if (userRepository.existsByEmployeeNumber(employeeNumber)) {

            return ResponseEntity.badRequest()
                    .body("Employee Number already exists");
        }

        User user = new User();

        user.setZanzibarId(zanzibarId);
        user.setEmployeeNumber(employeeNumber);
        user.setFullName(request.getFullName().trim());

        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );

        if (request.getRole() == null ||
                request.getRole().trim().isEmpty()) {

            user.setRole("STAFF");

        } else {

            user.setRole(request.getRole().trim());
        }

        User savedUser =
                userRepository.save(user);

        Map<String, Object> response =
                new HashMap<>();

        response.put("success", true);
        response.put(
                "message",
                "User registered successfully"
        );
        response.put(
                "id",
                savedUser.getId()
        );
        response.put(
                "zanzibarId",
                savedUser.getZanzibarId()
        );
        response.put(
                "employeeNumber",
                savedUser.getEmployeeNumber()
        );
        response.put(
                "fullName",
                savedUser.getFullName()
        );
        response.put(
                "role",
                savedUser.getRole()
        );

        return ResponseEntity.ok(response);
    }

    public static class UserRequest {

        private String zanzibarId;
        private String employeeNumber;
        private String fullName;
        private String password;
        private String confirmPassword;
        private String role;

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

        public String getConfirmPassword() {
            return confirmPassword;
        }

        public void setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}
