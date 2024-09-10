import java.time.LocalDate;
import java.util.List;

public class LeaveService {

    private LeaveRepository leaveRepository;
    private EmployeeRepository employeeRepository;

    public LeaveService(LeaveRepository leaveRepository, EmployeeRepository employeeRepository) {
        this.leaveRepository = leaveRepository;
        this.employeeRepository = employeeRepository;
    }

    public boolean applyForLeave(int employeeId, LocalDate startDate, LocalDate endDate) {
        Employee employee = employeeRepository.findById(employeeId);
        if (employee != null && employee.getLeaveBalance() > 0) {
            LeaveRequest request = new LeaveRequest(generateLeaveRequestId(), employeeId, startDate, endDate, "Pending");
            leaveRepository.save(request);
            return true;
        }
        return false;
    }

    public boolean approveLeave(int requestId) {
        LeaveRequest request = leaveRepository.findById(requestId);
        if (request != null && request.getStatus().equals("Pending")) {
            request.setStatus("Approved");
            leaveRepository.update(request);

            // Update employee leave balance
            Employee employee = employeeRepository.findById(request.getEmployeeId());
            int leaveDays = (int) (request.getEndDate().toEpochDay() - request.getStartDate().toEpochDay() + 1);
            employee.setLeaveBalance(employee.getLeaveBalance() - leaveDays);
            employeeRepository.update(employee);
            return true;
        }
        return false;
    }

    private int generateLeaveRequestId() {
        // Generate a unique ID for the leave request (e.g., using a sequence or timestamp)
        return (int) (Math.random() * 10000);
    }
}