interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

abstract class RideVehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public RideVehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleDetails() {
        return vehicleId + " - " + driverName + " @ " + ratePerKm + "/km";
    }

    public double getRatePerKm() { return ratePerKm; }

    public abstract double calculateFare(double distance);
}

class RideCar extends RideVehicle implements GPS {
    private String location = "Unknown";
    public RideCar(String id, String driver, double rate) { super(id, driver, rate); }
    public double calculateFare(double distance) { return distance * getRatePerKm(); }
    public String getCurrentLocation() { return location; }
    public void updateLocation(String location) { this.location = location; }
}

class RideBike extends RideVehicle implements GPS {
    private String location = "Unknown";
    public RideBike(String id, String driver, double rate) { super(id, driver, rate); }
    public double calculateFare(double distance) { return distance * getRatePerKm() * 0.8; }
    public String getCurrentLocation() { return location; }
    public void updateLocation(String location) { this.location = location; }
}

class RideAuto extends RideVehicle implements GPS {
    private String location = "Unknown";
    public RideAuto(String id, String driver, double rate) { super(id, driver, rate); }
    public double calculateFare(double distance) { return distance * getRatePerKm() * 0.9; }
    public String getCurrentLocation() { return location; }
    public void updateLocation(String location) { this.location = location; }
}

public class RideHailing {
    public static void main(String[] args) {
        RideVehicle[] rides = {
            new RideCar("C101", "Arjun", 15),
            new RideBike("B202", "Meera", 10),
            new RideAuto("A303", "Ravi", 12)
        };

        for (RideVehicle v : rides) {
            System.out.println(v.getVehicleDetails() + " → Fare for 10km: " + v.calculateFare(10));
        }
    }
}
