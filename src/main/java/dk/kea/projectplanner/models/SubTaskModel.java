package dk.kea.projectplanner.models;

import java.time.LocalDateTime;

public class SubTaskModel extends Activity {
    public SubTaskModel(String name, LocalDateTime plannedStartDate, LocalDateTime deadline) {
        super(name, plannedStartDate, deadline);
    }
}
