package School.management.system.School.Repository;

import School.management.system.School.Model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<SchoolClass, Long> {
}