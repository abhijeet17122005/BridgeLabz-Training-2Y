public class Student {
    private static String universityName = "National University";
    private static int totalStudents = 0;

    private final String rollNumber;
    private String name;
    private String grade;

    public Student(String name, String rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber; // final
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("University: " + universityName + " | Total Students: " + totalStudents);
    }

    public void updateGrade(String newGrade) {
        this.grade = newGrade;
    }

    public void displayStudentDetails(Object obj) {
        if (obj instanceof Student) {
            System.out.println("University: " + Student.universityName);
            System.out.println("Name: " + this.name);
            System.out.println("Roll No: " + this.rollNumber);
            System.out.println("Grade: " + this.grade);
        } else {
            System.out.println("Object is not a Student.");
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Amit", "R1001", "A");
        Student s2 = new Student("Meera", "R1002", "B");

        Student.displayTotalStudents();
        s1.displayStudentDetails(s1);
        s2.updateGrade("A+");
        s2.displayStudentDetails(s2);
    }
}
