import java.util.ArrayList;

// Course class
class Course {
    String courseName;
    ArrayList<Student> students;  // Many students can join a course

    Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    // Add student to this course
    void addStudent(Student s) {
        if (!students.contains(s)) {
            students.add(s);
        }
    }

    // Show all enrolled students
    void showStudents() {
        System.out.println("Course: " + courseName + " has students:");
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
        System.out.println();
    }
}

// Student class
class Student {
    String name;
    ArrayList<Course> courses;  // Many courses per student

    Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Enroll in a course
    void enrollCourse(Course c) {
        if (!courses.contains(c)) {
            courses.add(c);
            c.addStudent(this);  // keep bidirectional association
        }
    }

    // Show student’s enrolled courses
    void showCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (Course c : courses) {
            System.out.println("- " + c.courseName);
        }
        System.out.println();
    }
}

// School class (Aggregation with Students)
class School {
    String schoolName;
    ArrayList<Student> students;

    School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    // Add student to school
    void addStudent(Student s) {
        students.add(s);
    }

    // Show all students in the school
    void showStudents() {
        System.out.println("School: " + schoolName + " has students:");
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
        System.out.println();
    }
}

// Main class to demonstrate
public class SchoolDemo {
    public static void main(String[] args) {
        // Create a school
        School school = new School("Greenwood High");

        // Create students
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        // Add students to school (Aggregation)
        school.addStudent(s1);
        school.addStudent(s2);

        // Create courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Computer Science");

        // Students enroll in courses (Association many-to-many)
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);

        s2.enrollCourse(c1);

        // Show school students
        school.showStudents();

        // Show each student's courses
        s1.showCourses();
        s2.showCourses();

        // Show course enrollments
        c1.showStudents();
        c2.showStudents();
    }
}
