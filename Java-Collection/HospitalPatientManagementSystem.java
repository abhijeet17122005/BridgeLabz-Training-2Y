import java.util.*;

public class HospitalPatientManagementSystem {
    static class Patient {
        final String id;
        Patient(String id){ this.id=id; }
        @Override public String toString(){ return id; }
        @Override public boolean equals(Object o){ return o instanceof Patient && ((Patient)o).id.equals(id); }
        @Override public int hashCode(){ return id.hashCode(); }
    }

    public static void main(String[] args) {
        Set<Patient> admitted = new HashSet<>();
        Queue<Patient> waiting = new LinkedList<>();
        Stack<Patient> discharged = new Stack<>();
        List<Patient> history = new ArrayList<>();

        // admit patients
        Patient p1 = new Patient("P1");
        Patient p2 = new Patient("P2");
        if (admitted.add(p1)) { waiting.add(p1); history.add(p1); }
        if (admitted.add(p2)) { waiting.add(p2); history.add(p2); }

        // treat in order
        while (!waiting.isEmpty()) {
            Patient p = waiting.poll();
            System.out.println("Treating " + p);
            // discharge after treatment
            admitted.remove(p);
            discharged.push(p);
            System.out.println("Discharged " + p);
        }

        // re-admit recently discharged
        if (!discharged.isEmpty()) {
            Patient recent = discharged.peek();
            System.out.println("Re-admitting " + recent);
            admitted.add(recent);
            waiting.add(recent);
        }

        System.out.println("Admitted now: " + admitted);
        System.out.println("History: " + history);
    }
}
