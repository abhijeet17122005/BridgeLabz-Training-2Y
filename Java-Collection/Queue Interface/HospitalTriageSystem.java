import java.util.PriorityQueue;
import java.util.Comparator;

public class HospitalTriageSystem {
    static class Patient {
        String name;
        int severity; // higher number -> higher priority

        Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }

        @Override
        public String toString() {
            return name + "(" + severity + ")";
        }
    }

    public static void main(String[] args) {
        // comparator: higher severity first; tie-breaker can be FIFO if needed (not implemented here)
        PriorityQueue<Patient> pq = new PriorityQueue<>(new Comparator<Patient>() {
            public int compare(Patient a, Patient b) {
                return Integer.compare(b.severity, a.severity); // descending severity
            }
        });

        pq.add(new Patient("John", 3));
        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 2));

        System.out.println("Treatment order:");
        while (!pq.isEmpty()) {
            System.out.println(pq.remove().name);
        }
        // Output order: Alice, John, Bob
    }
}
