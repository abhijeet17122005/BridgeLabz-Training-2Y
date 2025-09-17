public class OnlineCourseManagement {
    static class Course {
        private String courseName;
        private int duration;
        private double fee;
        
        private static String instituteName = "Tech Learning Institute";
        
        public Course(String courseName, int duration, double fee) {
            this.courseName = courseName;
            this.duration = duration;
            this.fee = fee;
        }
        
        public void displayCourseDetails() {
            System.out.println("Course: " + courseName + 
                             ", Duration: " + duration + " weeks" +
                             ", Fee: $" + fee + 
                             ", Institute: " + instituteName);
        }
        
        public static void updateInstituteName(String newName) {
            instituteName = newName;
            System.out.println("Institute name updated to: " + instituteName);
        }
        
        public String getCourseName() {
            return courseName;
        }
        
        public int getDuration() {
            return duration;
        }
        
        public double getFee() {
            return fee;
        }
        
        public static String getInstituteName() {
            return instituteName;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Online Course Management ===\n");
        
        Course javaCourse = new Course("Java Programming", 12, 299.99);
        Course pythonCourse = new Course("Python for Data Science", 8, 249.99);
        Course webDevCourse = new Course("Full Stack Web Development", 16, 399.99);
        
        System.out.println("Initial Course Details:");
        javaCourse.displayCourseDetails();
        pythonCourse.displayCourseDetails();
        webDevCourse.displayCourseDetails();
        
        System.out.println("\n" + "=".repeat(50));
        
        Course.updateInstituteName("Advanced Tech Academy");
        
        System.out.println("\nCourse Details After Institute Name Update:");
        javaCourse.displayCourseDetails();
        pythonCourse.displayCourseDetails();
        webDevCourse.displayCourseDetails();
        
        Course aiCourse = new Course("Artificial Intelligence", 20, 599.99);
        System.out.println("\nNew Course Added:");
        aiCourse.displayCourseDetails();
    }
}