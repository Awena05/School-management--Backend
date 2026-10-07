package School.management.system.School.Controller;

import School.management.system.School.Model.Teacher;
import School.management.system.School.Repository.TeacherRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Long id,
                                 @RequestBody Teacher teacher) {

        Teacher existingTeacher = teacherRepository.findById(id).orElse(null);

        if (existingTeacher != null) {
            existingTeacher.setTeacherNo(teacher.getTeacherNo());
            existingTeacher.setFullName(teacher.getFullName());
            existingTeacher.setGender(teacher.getGender());
            existingTeacher.setSubject(teacher.getSubject());
            existingTeacher.setPhone(teacher.getPhone());
            existingTeacher.setEmail(teacher.getEmail());

            return teacherRepository.save(existingTeacher);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable Long id) {

        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
            return "Teacher deleted successfully";
        }

        return "Teacher not found";
    }
}