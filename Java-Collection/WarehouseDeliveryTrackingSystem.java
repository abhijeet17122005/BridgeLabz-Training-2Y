import java.util.*;

public class WarehouseDeliveryTrackingSystem {
    static class Package {
        final String id;
        final String address;
        Package(String id, String addr){ this.id=id; this.address=addr; }
        @Override public String toString(){ return id + "->" + address; }
    }

    public static void main(String[] args) {
        Queue<Package> pending = new LinkedList<>();
        Set<String> packageIds = new HashSet<>();
        List<Package> delivered = new ArrayList<>();
        Stack<Package> returned = new Stack<>();

        // add requests
        addPackage(new Package("PK1","Addr1"), pending, packageIds);
        addPackage(new Package("PK2","Addr2"), pending, packageIds);
        addPackage(new Package("PK1","Addr1"), pending, packageIds); // duplicate ignored

        // process deliveries
        while (!pending.isEmpty()) {
            Package p = pending.poll();
            System.out.println("Delivering " + p);
            delivered.add(p);
            // simulate one return
            if ("PK2".equals(p.id)) {
                System.out.println(" -> returned");
                delivered.remove(p);
                returned.push(p);
            }
        }

        System.out.println("Delivered: " + delivered);
        System.out.println("Returned: " + returned);

        // summary
        System.out.println("Summary: total delivered = " + delivered.size() + ", returned = " + returned.size());
    }

    static void addPackage(Package p, Queue<Package> pending, Set<String> ids) {
        if (ids.add(p.id)) pending.add(p);
        else System.out.println("Duplicate package id " + p.id + ", ignored.");
    }
}
