public class VehicleRegistration {
    static class Vehicle {
        private String ownerName;
        private String vehicleType;
        
        private static double registrationFee = 150.00;
        
        public Vehicle(String ownerName, String vehicleType) {
            this.ownerName = ownerName;
            this.vehicleType = vehicleType;
        }
        
        public void displayVehicleDetails() {
            System.out.println("Owner: " + ownerName + 
                             ", Vehicle Type: " + vehicleType + 
                             ", Registration Fee: $" + registrationFee);
        }
        
        public static void updateRegistrationFee(double newFee) {
            registrationFee = newFee;
            System.out.println("Registration fee updated to: $" + registrationFee);
        }
        
        public double calculateTotalRegistrationCost() {
            double taxRate = 0.08;
            return registrationFee + (registrationFee * taxRate);
        }
        
        public String getOwnerName() {
            return ownerName;
        }
        
        public String getVehicleType() {
            return vehicleType;
        }
        
        public static double getRegistrationFee() {
            return registrationFee;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Vehicle Registration System ===\n");
        
        Vehicle car1 = new Vehicle("John Smith", "Sedan");
        Vehicle car2 = new Vehicle("Sarah Johnson", "SUV");
        Vehicle bike1 = new Vehicle("Mike Brown", "Motorcycle");
        
        System.out.println("Initial Vehicle Registrations:");
        car1.displayVehicleDetails();
        car2.displayVehicleDetails();
        bike1.displayVehicleDetails();
        
        System.out.println("\nTotal cost including tax for John's vehicle: $" + 
                         String.format("%.2f", car1.calculateTotalRegistrationCost()));
        
        System.out.println("\n" + "=".repeat(50));
        
        Vehicle.updateRegistrationFee(175.00);
        
        System.out.println("\nVehicle Details After Fee Update:");
        car1.displayVehicleDetails();
        car2.displayVehicleDetails();
        bike1.displayVehicleDetails();
        
        Vehicle truck1 = new Vehicle("David Wilson", "Pickup Truck");
        System.out.println("\nNew Vehicle Registration:");
        truck1.displayVehicleDetails();
        System.out.println("Total cost including tax: $" + 
                         String.format("%.2f", truck1.calculateTotalRegistrationCost()));
        
        System.out.println("\n" + "=".repeat(50));
        
        Vehicle.updateRegistrationFee(200.00);
        System.out.println("\nAll vehicles now have updated registration fee:");
        System.out.println("Current registration fee: $" + Vehicle.getRegistrationFee());
    }
}