package School.management.system.School.Repository;

import School.management.system.School.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmployeeNumber(String employeeNumber);

    Optional<User> findByZanzibarId(String zanzibarId);

    boolean existsByEmployeeNumber(String employeeNumber);

    boolean existsByZanzibarId(String zanzibarId);
}