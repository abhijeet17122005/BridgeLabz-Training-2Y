public class GeometryCalculator {
    static class Circle {
        private double radius;
        
        public Circle() {
            this(1.0);
        }
        
        public Circle(double radius) {
            this.radius = radius;
        }
        
        public double getArea() {
            return Math.PI * radius * radius;
        }
        
        public void displayCircleInfo() {
            System.out.println("Radius: " + radius + ", Area: " + String.format("%.2f", getArea()));
        }
    }
    
    public static void main(String[] args) {
        Circle defaultCircle = new Circle();
        Circle customCircle = new Circle(5.0);
        
        System.out.println("Default Circle:");
        defaultCircle.displayCircleInfo();
        
        System.out.println("\nCustom Circle:");
        customCircle.displayCircleInfo();
    }
}