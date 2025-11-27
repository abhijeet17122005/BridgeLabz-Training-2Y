import java.util.ArrayList;
import java.util.List;

// ---------- Class: Subject ----------
class Subject {
    String subjectName;
    int marks;

    public Subject(String subjectName, int marks) {
        this.subjectName = subjectName;
        this.marks = marks;
    }
}

// ---------- Class: Student ----------
class Student {
    String name;
    List<Subject> subjects; // Aggregation: Student has multiple Subjects

    public Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    // Add a subject to the student's list
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}

// ---------- Class: GradeCalculator ----------
class GradeCalculator {
    // Association: GradeCalculator computes grades for a Student
    public String calculateGrade(Student student) {
        List<Subject> subjects = student.getSubjects();
        int totalMarks = 0;

        for (Subject s : subjects) {
            totalMarks += s.marks;
        }

        double average = (double) totalMarks / subjects.size();

        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }
}

// ---------- Main Class ----------
public class SchoolResultsApp {
    public static void main(String[] args) {

        // Object Diagram snapshot
        Student john = new Student("John"); // Student object
        john.addSubject(new Subject("Maths", 90));  // Subject object
        john.addSubject(new Subject("Science", 85)); // Subject object

        // Sequence Diagram interaction
        GradeCalculator calculator = new GradeCalculator(); // Actor: GradeCalculator
        String grade = calculator.calculateGrade(john); // Student requests grade

        // Output results
        System.out.println("Student: " + john.name);
        for (Subject s : john.getSubjects()) {
            System.out.println(s.subjectName + ": " + s.marks);
        }
        System.out.println("Grade: " + grade);
    }
}
