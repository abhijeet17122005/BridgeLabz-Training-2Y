public class UniversityManagement {
    static class Student {
        public String rollNumber;
        
        protected String name;
        
        private double cgpa;
        
        public Student(String rollNumber, String name, double cgpa) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.cgpa = cgpa;
        }
        
        public double getCgpa() {
            return cgpa;
        }
        
        public void setCgpa(double cgpa) {
            if (cgpa >= 0.0 && cgpa <= 10.0) {
                this.cgpa = cgpa;
                System.out.println("CGPA updated to: " + cgpa);
            } else {
                System.out.println("Invalid CGPA! Must be between 0.0 and 10.0");
            }
        }
        
        public void displayBasicInfo() {
            System.out.println("Roll Number: " + rollNumber + " (public access)");
            System.out.println("CGPA: " + cgpa + " (accessed via public method)");
        }
    }
    
    static class PostgraduateStudent extends Student {
        private String researchArea;
        
        public PostgraduateStudent(String rollNumber, String name, double cgpa, String researchArea) {
            super(rollNumber, name, cgpa);
            this.researchArea = researchArea;
        }
        
        public void displayPostgradInfo() {
            System.out.println("=== Postgraduate Student Details ===");
            System.out.println("Roll Number: " + rollNumber + " (public - inherited)");
            System.out.println("Name: " + name + " (protected - accessible in subclass)");
            System.out.println("Research Area: " + researchArea);
            System.out.println("CGPA: " + getCgpa() + " (private - accessed via public method)");
        }
        
        public void updateResearchArea(String newArea) {
            this.researchArea = newArea;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== University Management System ===\n");
        
        Student student1 = new Student("CS2023001", "Alice Johnson", 8.5);
        
        System.out.println("Regular Student:");
        student1.displayBasicInfo();
        System.out.println("Accessing public rollNumber directly: " + student1.rollNumber);
        
        System.out.println("\nUpdating CGPA:");
        student1.setCgpa(9.2);
        student1.setCgpa(11.0);
        
        System.out.println("\n" + "=".repeat(50));
        
        PostgraduateStudent pgStudent = new PostgraduateStudent(
            "PG2023001", "Bob Smith", 9.1, "Machine Learning"
        );
        
        pgStudent.displayPostgradInfo();
        
        System.out.println("\nUpdating postgraduate student info:");
        pgStudent.setCgpa(9.5);
        pgStudent.updateResearchArea("Deep Learning");
        pgStudent.displayPostgradInfo();
    }
}