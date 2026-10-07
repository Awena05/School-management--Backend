package School.management.system.School.Services;

import School.management.system.School.Model.Attendance;
import School.management.system.School.Repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }
    public Attendance addAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }


    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    public Attendance updateAttendance(Long id, Attendance attendance) {

        Attendance existingAttendance =
                attendanceRepository.findById(id).orElse(null);

        if (existingAttendance != null) {

            existingAttendance.setAdmissionNo(
                    attendance.getAdmissionNo()
            );

            existingAttendance.setStudentName(
                    attendance.getStudentName()
            );

            existingAttendance.setClassName(
                    attendance.getClassName()
            );

            existingAttendance.setDate(
                    attendance.getDate()
            );

            existingAttendance.setStatus(
                    attendance.getStatus()
            );

            return attendanceRepository.save(existingAttendance);
        }

        return null;
    }
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}