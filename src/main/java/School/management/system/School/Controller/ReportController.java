package School.management.system.School.Controller;

import School.management.system.School.Repository.AttendanceRepository;
import School.management.system.School.Repository.ClassRepository;
import School.management.system.School.Repository.ExamRepository;
import School.management.system.School.Repository.StudentRepository;
import School.management.system.School.Repository.SubjectRepository;
import School.management.system.School.Repository.TeacherRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final ClassRepository classRepository;
    private final SubjectRepository subjectRepository;
    private final ExamRepository examRepository;
    private final AttendanceRepository attendanceRepository;

    public ReportController(
            StudentRepository studentRepository,
            TeacherRepository teacherRepository,
            ClassRepository classRepository,
            SubjectRepository subjectRepository,
            ExamRepository examRepository,
            AttendanceRepository attendanceRepository) {

        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.classRepository = classRepository;
        this.subjectRepository = subjectRepository;
        this.examRepository = examRepository;
        this.attendanceRepository = attendanceRepository;
    }

    @GetMapping("/summary")
    public Map<String, Long> getSummary() {

        Map<String, Long> report = new HashMap<>();

        report.put("students", studentRepository.count());
        report.put("teachers", teacherRepository.count());
        report.put("classes", classRepository.count());
        report.put("subjects", subjectRepository.count());
        report.put("exams", examRepository.count());
        report.put("attendance", attendanceRepository.count());

        return report;
    }
}
