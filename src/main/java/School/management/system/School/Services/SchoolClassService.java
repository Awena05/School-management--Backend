package School.management.system.School.Services;

import School.management.system.School.Model.SchoolClass;
import School.management.system.School.Repository.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolClassService {

    private final ClassRepository schoolClassRepository;

    public SchoolClassService(ClassRepository schoolClassRepository) {
        this.schoolClassRepository = schoolClassRepository;
    }

    public SchoolClass addClass(SchoolClass schoolClass) {
        return schoolClassRepository.save(schoolClass);
    }

    public List<SchoolClass> getAllClasses() {
        return schoolClassRepository.findAll();
    }

    public SchoolClass getClassById(Long id) {
        return schoolClassRepository.findById(id).orElse(null);
    }

    public void deleteClass(Long id) {
        schoolClassRepository.deleteById(id);
    }
}