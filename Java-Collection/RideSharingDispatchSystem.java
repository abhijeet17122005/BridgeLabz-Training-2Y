import java.util.*;

public class RideSharingDispatchSystem {
    static class RideRequest {
        final String reqId;
        final int distanceMeters; // used for priority (closer = higher priority)
        RideRequest(String id, int d){ reqId=id; distanceMeters=d; }
        public String toString(){ return reqId + "(dist=" + distanceMeters + ")"; }
    }

    static class Driver {
        final String driverId;
        Driver(String id){ driverId=id; }
        @Override public boolean equals(Object o){ return o instanceof Driver && ((Driver)o).driverId.equals(driverId); }
        @Override public int hashCode(){ return driverId.hashCode(); }
        public String toString(){ return driverId; }
    }

    static class Ride { final String rideId; Ride(String id){rideId=id;} public String toString(){ return rideId; } }

    public static void main(String[] args) {
        Queue<RideRequest> pending = new LinkedList<>();
        pending.add(new RideRequest("R1", 2000));
        pending.add(new RideRequest("R2", 500));
        pending.add(new RideRequest("R3", 1500));

        Set<Driver> availableDrivers = new HashSet<>();
        availableDrivers.add(new Driver("D1"));
        availableDrivers.add(new Driver("D2"));

        List<Ride> completed = new ArrayList<>();

        // PriorityQueue: closest distance first
        PriorityQueue<RideRequest> priority = new PriorityQueue<>(Comparator.comparingInt(r -> r.distanceMeters));
        priority.addAll(pending);

        // Handle high-priority first
        System.out.println("Assigning rides by priority (closest first):");
        while (!priority.isEmpty() && !availableDrivers.isEmpty()) {
            RideRequest req = priority.poll();
            Iterator<Driver> it = availableDrivers.iterator();
            Driver driver = it.next();
            it.remove(); // driver now busy
            System.out.println("Assigned " + driver + " to " + req);
            // mark completed (simulate)
            completed.add(new Ride(req.reqId + "-ride"));
            // driver becomes available again
            availableDrivers.add(driver);
        }

        System.out.println("Completed rides: " + completed);
    }
}
