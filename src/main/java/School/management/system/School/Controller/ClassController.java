package School.management.system.School.Controller;

import School.management.system.School.Model.SchoolClass;
import School.management.system.School.Repository.ClassRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    private final ClassRepository schoolClassRepository;

    public ClassController(ClassRepository schoolClassRepository) {
        this.schoolClassRepository = schoolClassRepository;
    }

    @PostMapping
    public SchoolClass addClass(@RequestBody SchoolClass schoolClass) {
        return schoolClassRepository.save(schoolClass);
    }

    @GetMapping
    public List<SchoolClass> getAllClasses() {
        return schoolClassRepository.findAll();
    }

    @GetMapping("/{id}")
    public SchoolClass getClassById(@PathVariable Long id) {
        return schoolClassRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteClass(@PathVariable Long id) {
        schoolClassRepository.deleteById(id);
        return "Class deleted successfully";
    }
}