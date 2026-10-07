package School.management.system.School.Controller;
import School.management.system.School.Model.User;
import School.management.system.School.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request) {

        if (request.getZanzibarId() == null ||
                request.getZanzibarId().trim().isEmpty()) {

            return ResponseEntity
                    .badRequest()
                    .body("Zanzibar ID is required");
        }

        String zanzibarId =
                request.getZanzibarId().trim();

        if (!zanzibarId.matches("\\d{9}")) {

            return ResponseEntity
                    .badRequest()
                    .body("Zanzibar ID must contain exactly 9 digits");
        }

        if (request.getEmployeeNumber() == null ||
                request.getEmployeeNumber().trim().isEmpty()) {

            return ResponseEntity
                    .badRequest()
                    .body("Employee Number is required");
        }

        String employeeNumber =
                request.getEmployeeNumber().trim();

        if (!employeeNumber.matches("\\d{5}")) {

            return ResponseEntity
                    .badRequest()
                    .body("Employee Number must contain exactly 5 digits");
        }

        if (request.getPassword() == null ||
                request.getPassword().trim().isEmpty()) {

            return ResponseEntity
                    .badRequest()
                    .body("Password is required");
        }

        Optional<User> userOptional =
                userRepository.findByZanzibarId(zanzibarId);

        if (userOptional.isEmpty()) {

            return ResponseEntity
                    .status(401)
                    .body("Zanzibar ID au Employee Number sio sahihi");
        }

        User user = userOptional.get();

        if (user.getEmployeeNumber() == null ||
                !user.getEmployeeNumber()
                        .equals(employeeNumber)) {

            return ResponseEntity
                    .status(401)
                    .body("Zanzibar ID au Employee Number sio sahihi");
        }

        if (user.getPassword() == null ||
                user.getPassword().trim().isEmpty()) {

            return ResponseEntity
                    .status(401)
                    .body("Password sio sahihi");
        }

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            return ResponseEntity
                    .status(401)
                    .body("Password sio sahihi");
        }

        Map<String, Object> response =
                new HashMap<>();

        response.put("success", true);
        response.put("id", user.getId());
        response.put(
                "zanzibarId",
                user.getZanzibarId()
        );
        response.put(
                "employeeNumber",
                user.getEmployeeNumber()
        );
        response.put(
                "fullName",
                user.getFullName()
        );
        response.put(
                "role",
                user.getRole()
        );

        return ResponseEntity.ok(response);
    }

    public static class LoginRequest {

        private String zanzibarId;
        private String employeeNumber;
        private String password;

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

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
