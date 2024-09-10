import java.util.HashMap;
import java.util.Map;

public class EmployeeRepository {

    private Map<Integer, Employee> employeeMap = new HashMap<>();

    public void save(Employee employee) {
        employeeMap.put(employee.getId(), employee);
    }

    public Employee findById(int id) {
        return employeeMap.get(id);
    }

    public void update(Employee employee) {
        employeeMap.put(employee.getId(), employee);
    }
}