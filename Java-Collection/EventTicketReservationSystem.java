import java.util.*;

public class EventTicketReservationSystem {
    static class Booking {
        final String bookingId;
        final String userId;
        final boolean vip;
        Booking(String b, String u, boolean vip){ bookingId=b; userId=u; this.vip=vip; }
        public String toString(){ return bookingId + "(" + userId + (vip?":VIP":":Reg") + ")"; }
    }

    public static void main(String[] args) {
        List<Booking> allBookings = new ArrayList<>();
        Set<String> users = new HashSet<>(); // prevent duplicate user registrations
        Queue<Booking> confirmQueue = new LinkedList<>();
        PriorityQueue<Booking> vipQueue = new PriorityQueue<>((a,b) -> Boolean.compare(b.vip, a.vip));

        // register users
        registerUser("U1", users);
        registerUser("U2", users);
        registerUser("U1", users); // duplicate ignored

        // accept bookings
        Booking b1 = new Booking("B1", "U1", false);
        Booking b2 = new Booking("B2", "U2", true);
        confirmQueue.add(b1); confirmQueue.add(b2);
        vipQueue.add(b1); vipQueue.add(b2);

        // prioritize VIPs
        System.out.println("Processing VIP first using priority queue:");
        while (!vipQueue.isEmpty()) {
            Booking b = vipQueue.poll();
            System.out.println("Confirming " + b);
            allBookings.add(b);
        }

        System.out.println("All confirmed bookings: " + allBookings);
    }

    static void registerUser(String id, Set<String> users) {
        if (users.add(id)) System.out.println("Registered user " + id);
        else System.out.println("User " + id + " already registered");
    }
}
