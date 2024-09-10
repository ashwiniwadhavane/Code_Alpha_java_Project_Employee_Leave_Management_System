import java.time.LocalDate;
import java.util.Scanner;

public class LeaveManagementUI {

    private LeaveService leaveService;
    private Scanner scanner = new Scanner(System.in);

    public LeaveManagementUI(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    public void start() {
        while (true) {
            System.out.println("1. Apply for Leave");
            System.out.println("2. Approve Leave");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    applyForLeave();
                    break;
                case 2:
                    approveLeave();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void applyForLeave() {
        System.out.print("Enter Employee ID: ");
        int employeeId = scanner.nextInt();
        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        LocalDate startDate = LocalDate.parse(scanner.next());
        System.out.print("Enter End Date (YYYY-MM-DD): ");
        LocalDate endDate = LocalDate.parse(scanner.next());

        if (leaveService.applyForLeave(employeeId, startDate, endDate)) {
            System.out.println("Leave applied successfully.");
        } else {
            System.out.println("Failed to apply for leave. Check leave balance or employee ID.");
        }
    }

    private void approveLeave() {
        System.out.print("Enter Leave Request ID: ");
        int requestId = scanner.nextInt();

        if (leaveService.approveLeave(requestId)) {
            System.out.println("Leave approved successfully.");
        } else {
            System.out.println("Failed to approve leave. Check request ID or status.");
        }
    }
}