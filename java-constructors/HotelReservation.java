public class HotelReservation {
    static class HotelBooking {
        private String guestName;
        private String roomType;
        private int nights;
        
        public HotelBooking() {
            this.guestName = "Guest";
            this.roomType = "Standard";
            this.nights = 1;
        }
        
        public HotelBooking(String guestName, String roomType, int nights) {
            this.guestName = guestName;
            this.roomType = roomType;
            this.nights = nights;
        }
        
        public HotelBooking(HotelBooking other) {
            this.guestName = other.guestName;
            this.roomType = other.roomType;
            this.nights = other.nights;
        }
        
        public void displayBookingInfo() {
            System.out.println("Guest: " + guestName + ", Room: " + roomType + ", Nights: " + nights);
        }
        
        public double calculateTotalCost() {
            double baseRate = roomType.equals("Deluxe") ? 150.0 : 100.0;
            return baseRate * nights;
        }
    }
    
    public static void main(String[] args) {
        HotelBooking defaultBooking = new HotelBooking();
        HotelBooking customBooking = new HotelBooking("John Doe", "Deluxe", 3);
        HotelBooking copiedBooking = new HotelBooking(customBooking);
        
        System.out.println("Default Booking:");
        defaultBooking.displayBookingInfo();
        System.out.println("Cost: $" + defaultBooking.calculateTotalCost());
        
        System.out.println("\nCustom Booking:");
        customBooking.displayBookingInfo();
        System.out.println("Cost: $" + customBooking.calculateTotalCost());
        
        System.out.println("\nCopied Booking:");
        copiedBooking.displayBookingInfo();
        System.out.println("Cost: $" + copiedBooking.calculateTotalCost());
    }
}