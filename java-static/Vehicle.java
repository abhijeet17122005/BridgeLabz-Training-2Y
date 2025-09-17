public class Vehicle {
    private static double registrationFee = 1500.0;
    private static int totalVehicles = 0;

    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber; // final
        totalVehicles++;
    }

    public static void updateRegistrationFee(double newFee) {
        if (newFee >= 0) registrationFee = newFee;
    }

    public void displayRegistrationDetails(Object obj) {
        if (obj instanceof Vehicle) {
            System.out.println("Registration Fee (common): " + Vehicle.registrationFee);
            System.out.println("Owner: " + this.ownerName);
            System.out.println("Vehicle Type: " + this.vehicleType);
            System.out.println("Reg No: " + this.registrationNumber);
        } else {
            System.out.println("Provided object is not a Vehicle.");
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Sunil", "Car", "MH12XY1234");
        Vehicle v2 = new Vehicle("Neha", "Motorbike", "MH12AB4321");

        v1.displayRegistrationDetails(v1);
        Vehicle.updateRegistrationFee(1800.0);
        v2.displayRegistrationDetails(v2);
    }
}
