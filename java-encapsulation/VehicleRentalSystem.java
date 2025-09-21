interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    public abstract double calculateRentalCost(int days);
}

class Car extends Vehicle implements Insurable {
    public Car(String number, double rate) { super(number, "Car", rate); }
    public double calculateRentalCost(int days) { return getRentalRate() * days; }
    public double calculateInsurance() { return getRentalRate() * 0.1; }
    public String getInsuranceDetails() { return "Car Insurance 10%"; }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String number, double rate) { super(number, "Bike", rate); }
    public double calculateRentalCost(int days) { return getRentalRate() * days * 0.8; }
    public double calculateInsurance() { return getRentalRate() * 0.05; }
    public String getInsuranceDetails() { return "Bike Insurance 5%"; }
}

class Truck extends Vehicle implements Insurable {
    public Truck(String number, double rate) { super(number, "Truck", rate); }
    public double calculateRentalCost(int days) { return getRentalRate() * days * 1.5; }
    public double calculateInsurance() { return getRentalRate() * 0.2; }
    public String getInsuranceDetails() { return "Truck Insurance 20%"; }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("C101", 1000),
            new Bike("B202", 500),
            new Truck("T303", 2000)
        };

        for (Vehicle v : vehicles) {
            System.out.println(v.getType() + " → Rental: " + v.calculateRentalCost(5)
                + ", Insurance: " + ((Insurable)v).calculateInsurance());
        }
    }
}
