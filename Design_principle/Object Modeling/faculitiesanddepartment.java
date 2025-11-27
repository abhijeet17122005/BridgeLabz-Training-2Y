import java.util.ArrayList;

// Faculty class (independent, Aggregation)
class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }

    void showFaculty() {
        System.out.println("Faculty: " + name);
    }
}

// Department class (exists only inside a University → Composition)
class Department {
    String deptName;

    Department(String deptName) {
        this.deptName = deptName;
    }

    void showDepartment() {
        System.out.println("Department: " + deptName);
    }
}

// University class (Composition with Departments, Aggregation with Faculty)
class University {
    String uniName;
    ArrayList<Department> departments;  // Composition
    ArrayList<Faculty> faculties;       // Aggregation

    University(String uniName) {
        this.uniName = uniName;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    // Add department (composition)
    void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    // Add faculty (aggregation)
    void addFaculty(Faculty f) {
        faculties.add(f);
    }

    // Show university details
    void showUniversity() {
        System.out.println("University: " + uniName);

        System.out.println("Departments:");
        for (Department d : departments) {
            d.showDepartment();
        }

        System.out.println("Faculties:");
        for (Faculty f : faculties) {
            f.showFaculty();
        }
        System.out.println();
    }

    // Simulate deleting university (composition effect)
    void deleteUniversity() {
        System.out.println("Deleting University: " + uniName + "...");
        departments.clear(); // Departments vanish
        // Faculties remain (aggregation)
    }
}

// Main class to demonstrate
public class UniversityDemo {
    public static void main(String[] args) {
        // Create faculty independently
        Faculty f1 = new Faculty("Dr. Alice");
        Faculty f2 = new Faculty("Dr. Bob");

        // Create University
        University uni = new University("Global University");

        // Add departments (composition)
        uni.addDepartment("Computer Science");
        uni.addDepartment("Mechanical Engineering");

        // Add faculty (aggregation)
        uni.addFaculty(f1);
        uni.addFaculty(f2);

        // Show details
        uni.showUniversity();

        // Delete university
        uni.deleteUniversity();

        // Show details after deletion
        uni.showUniversity();

        // Faculties still exist independently
        System.out.println("Independent Faculties after University deletion:");
        f1.showFaculty();
        f2.showFaculty();
    }
}
