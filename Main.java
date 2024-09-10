public class Main {
    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        LeaveRepository leaveRepository = new LeaveRepository();

        // Create sample data
        Employee emp1 = new Employee(1, "John Doe", 10);
        employeeRepository.save(emp1);

        LeaveService leaveService = new LeaveService(leaveRepository, employeeRepository);
        LeaveManagementUI ui = new LeaveManagementUI(leaveService);
        ui.start();
    }
}