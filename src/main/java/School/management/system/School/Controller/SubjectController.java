package School.management.system.School.Controller;

import School.management.system.School.Model.Subject;
import School.management.system.School.Repository.SubjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectRepository subjectRepository;

    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Subject addSubject(@RequestBody Subject subject) {
        return subjectRepository.save(subject);
    }

    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable Long id,
                                 @RequestBody Subject subject) {

        Subject existingSubject =
                subjectRepository.findById(id).orElse(null);

        if (existingSubject != null) {
            existingSubject.setSubjectCode(subject.getSubjectCode());
            existingSubject.setSubjectName(subject.getSubjectName());
            existingSubject.setDescription(subject.getDescription());

            return subjectRepository.save(existingSubject);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteSubject(@PathVariable Long id) {

        if (subjectRepository.existsById(id)) {
            subjectRepository.deleteById(id);
            return "Subject deleted successfully";
        }

        return "Subject not found";
    }
}

