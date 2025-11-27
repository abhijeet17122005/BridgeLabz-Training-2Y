import java.util.ArrayList;

// Course class
class Course {
    String name;
    Professor professor;                 // Association with Professor
    ArrayList<Student> students;         // Association with Students

    Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    // Assign professor to the course
    void assignProfessor(Professor prof) {
        this.professor = prof;
        System.out.println(prof.name + " is assigned to teach " + name);
    }

    // Enroll a student in the course
    void enrollStudent(Student s) {
        students.add(s);
        System.out.println(s.name + " enrolled in " + name);
    }

    // Show course details
    void showCourseDetails() {
        System.out.println("\nCourse: " + name);
        if (professor != null) {
            System.out.println("Taught by: " + professor.name);
        } else {
            System.out.println("No professor assigned yet.");
        }
        System.out.println("Enrolled Students:");
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
    }
}

// Student class
class Student {
    String name;
    ArrayList<Course> courses;   // Association with Courses

    Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Student enrolls in a course
    void enrollCourse(Course c) {
        courses.add(c);
        c.enrollStudent(this);
    }

    // Show student’s courses
    void showCourses() {
        System.out.println("\n" + name + " is enrolled in:");
        for (Course c : courses) {
            System.out.println("- " + c.name);
        }
    }
}

// Professor class
class Professor {
    String name;
    ArrayList<Course> courses;   // Association with Courses

    Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Assign professor to a course
    void assignCourse(Course c) {
        courses.add(c);
        c.assignProfessor(this);
    }

    // Show professor’s courses
    void showCourses() {
        System.out.println("\nProfessor " + name + " teaches:");
        for (Course c : courses) {
            System.out.println("- " + c.name);
        }
    }
}

// University class (Aggregation: contains multiple courses)
class University {
    String name;
    ArrayList<Course> courses;

    University(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Add course to university
    void addCourse(Course c) {
        courses.add(c);
        System.out.println(c.name + " added to " + name);
    }

    // Show university courses
    void showCourses() {
        System.out.println("\n" + name + " offers courses:");
        for (Course c : courses) {
            System.out.println("- " + c.name);
        }
    }
}

// Main class
public class UniversityDemo {
    public static void main(String[] args) {
        // Create university
        University uni = new University("Tech University");

        // Create courses
        Course c1 = new Course("Data Structures");
        Course c2 = new Course("Operating Systems");
        Course c3 = new Course("Machine Learning");

        // Add courses to university
        uni.addCourse(c1);
        uni.addCourse(c2);
        uni.addCourse(c3);

        // Create professors
        Professor p1 = new Professor("Dr. Sharma");
        Professor p2 = new Professor("Dr. Gupta");

        // Assign professors
        p1.assignCourse(c1);
        p2.assignCourse(c2);
        p1.assignCourse(c3);

        // Create students
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        // Students enroll in courses
        s1.enrollCourse(c1);
        s1.enrollCourse(c3);
        s2.enrollCourse(c2);

        // Show details
        uni.showCourses();
        c1.showCourseDetails();
        c2.showCourseDetails();
        c3.showCourseDetails();
        s1.showCourses();
        s2.showCourses();
        p1.showCourses();
        p2.showCourses();
    }
}
