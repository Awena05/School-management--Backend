package School.management.system.School;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder =
                new BCryptPasswordEncoder();

        String password = "School@2026#Admin45!";

        String hashedPassword = encoder.encode(password);

        System.out.println("=================================");
        System.out.println("BCrypt Password:");
        System.out.println(hashedPassword);
        System.out.println("=================================");
    }
}