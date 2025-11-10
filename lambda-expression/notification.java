import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;
    boolean critical;

    Alert(String type, boolean critical) {
        this.type = type;
        this.critical = critical;
    }

    @Override
    public String toString() {
        return type + " (Critical: " + critical + ")";
    }
}

public class NotificationFilter {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
            new Alert("Heart Rate High", true),
            new Alert("Low Battery", false),
            new Alert("Temperature Normal", false),
            new Alert("Oxygen Level Low", true)
        );

        // Predicate to show only critical alerts
        Predicate<Alert> criticalAlert = alert -> alert.critical;

        System.out.println("Filtered Alerts:");
        alerts.stream()
              .filter(criticalAlert)
              .forEach(System.out::println);
    }
}
