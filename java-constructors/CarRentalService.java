public class CarRentalService {
    static class CarRental {
        private String customerName;
        private String carModel;
        private int rentalDays;
        private static final double DAILY_RATE = 50.0;
        
        public CarRental() {
            this.customerName = "Unknown Customer";
            this.carModel = "Economy Car";
            this.rentalDays = 1;
        }
        
        public CarRental(String customerName, String carModel, int rentalDays) {
            this.customerName = customerName;
            this.carModel = carModel;
            this.rentalDays = rentalDays;
        }
        
        public CarRental(CarRental other) {
            this.customerName = other.customerName;
            this.carModel = other.carModel;
            this.rentalDays = other.rentalDays;
        }
        
        public double calculateTotalCost() {
            double multiplier = 1.0;
            
            if (carModel.toLowerCase().contains("luxury")) {
                multiplier = 2.0;
            } else if (carModel.toLowerCase().contains("suv")) {
                multiplier = 1.5;
            }
            
            return DAILY_RATE * multiplier * rentalDays;
        }
        
        public void displayRentalInfo() {
            System.out.println("Customer: " + customerName + ", Car: " + carModel + 
                             ", Days: " + rentalDays + ", Total Cost: $" + calculateTotalCost());
        }
        
        public void extendRental(int additionalDays) {
            this.rentalDays += additionalDays;
            System.out.println("Rental extended by " + additionalDays + " days.");
        }
    }
    
    public static void main(String[] args) {
        CarRental defaultRental = new CarRental();
        CarRental economyRental = new CarRental("Alice Johnson", "Toyota Camry", 5);
        CarRental luxuryRental = new CarRental("Bob Smith", "Luxury BMW", 3);
        CarRental suvRental = new CarRental("Carol White", "SUV Honda Pilot", 7);
        
        System.out.println("Rental Details:");
        defaultRental.displayRentalInfo();
        economyRental.displayRentalInfo();
        luxuryRental.displayRentalInfo();
        suvRental.displayRentalInfo();
        
        System.out.println("\nExtending Alice's rental:");
        economyRental.extendRental(2);
        economyRental.displayRentalInfo();
    }
}