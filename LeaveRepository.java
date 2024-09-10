import java.util.HashMap;
import java.util.Map;

public class LeaveRepository {

    private Map<Integer, LeaveRequest> leaveRequestMap = new HashMap<>();

    public void save(LeaveRequest leaveRequest) {
        leaveRequestMap.put(leaveRequest.getId(), leaveRequest);
    }

    public LeaveRequest findById(int id) {
        return leaveRequestMap.get(id);
    }

    public void update(LeaveRequest leaveRequest) {
        leaveRequestMap.put(leaveRequest.getId(), leaveRequest);
    }
}
