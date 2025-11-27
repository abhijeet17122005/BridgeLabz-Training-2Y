import java.util.*;

public class CourierDeliveryRoutingSystem {
    static class Parcel {
        final String id;
        final int priority; // higher value => higher priority
        Parcel(String id, int priority){ this.id=id; this.priority=priority; }
        public String toString(){ return id + "(prio=" + priority + ")"; }
    }

    public static void main(String[] args) {
        PriorityQueue<Parcel> priorityQueue = new PriorityQueue<>((a,b) -> Integer.compare(b.priority, a.priority));
        Set<String> assignedIds = new HashSet<>();
        List<Parcel> completed = new ArrayList<>();
        Queue<Parcel> normalQueue = new LinkedList<>();

        Parcel p1 = new Parcel("P1", 5);
        Parcel p2 = new Parcel("P2", 1);
        Parcel p3 = new Parcel("P3", 10);

        // add parcels
        addParcel(p1, priorityQueue, normalQueue, assignedIds);
        addParcel(p2, priorityQueue, normalQueue, assignedIds);
        addParcel(p3, priorityQueue, normalQueue, assignedIds);

        // assign high-priority first
        while (!priorityQueue.isEmpty()) {
            Parcel p = priorityQueue.poll();
            System.out.println("Assigning high-priority " + p);
            completed.add(p);
        }

        // complete normal queue
        while (!normalQueue.isEmpty()) {
            Parcel p = normalQueue.poll();
            System.out.println("Assigning normal " + p);
            completed.add(p);
        }

        System.out.println("Completed deliveries: " + completed);
    }

    static void addParcel(Parcel p, PriorityQueue<Parcel> pq, Queue<Parcel> normal, Set<String> assigned) {
        if (!assigned.add(p.id)) {
            System.out.println("Duplicate parcel id " + p.id + ", ignored.");
            return;
        }
        if (p.priority > 3) pq.add(p);
        else normal.add(p);
    }
}
