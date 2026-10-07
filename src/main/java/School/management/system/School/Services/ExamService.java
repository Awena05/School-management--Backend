package School.management.system.School.Services;

import School.management.system.School.Model.Exam;
import School.management.system.School.Repository.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }
    public Exam addExam(Exam exam) {
        return examRepository.save(exam);
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Exam getExamById(Long id) {
        return examRepository.findById(id).orElse(null);
    }
    public Exam updateExam(Long id, Exam exam) {

        Exam existingExam =
                examRepository.findById(id).orElse(null);

        if (existingExam != null) {

            existingExam.setAdmissionNo(
                    exam.getAdmissionNo()
            );

            existingExam.setStudentName(
                    exam.getStudentName()
            );

            existingExam.setClassName(
                    exam.getClassName()
            );

            existingExam.setSubject(
                    exam.getSubject()
            );

            existingExam.setMarks(
                    exam.getMarks()
            );

            existingExam.setGrade(
                    exam.getGrade()
            );

            existingExam.setExamType(
                    exam.getExamType()
            );

            return examRepository.save(existingExam);
        }

        return null;
    }

    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }
}