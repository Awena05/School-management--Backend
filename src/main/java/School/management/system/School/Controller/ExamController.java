package School.management.system.School.Controller;

import School.management.system.School.Model.Exam;
import School.management.system.School.Services.ExamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping
    public Exam addExam(@RequestBody Exam exam) {
        return examService.addExam(exam);
    }

    @GetMapping
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }

    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable Long id) {
        return examService.getExamById(id);
    }

    @PutMapping("/{id}")
    public Exam updateExam(
            @PathVariable Long id,
            @RequestBody Exam exam) {

        return examService.updateExam(id, exam);
    }
    @DeleteMapping("/{id}")
    public String deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
        return "Exam deleted successfully";
    }
}