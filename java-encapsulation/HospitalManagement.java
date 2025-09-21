interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientDetails() {
        return patientId + " - " + name + ", Age: " + age;
    }

    public abstract double calculateBill();
}

class InPatient extends Patient implements MedicalRecord {
    public InPatient(int id, String name, int age) { super(id, name, age); }
    public double calculateBill() { return 5000; }
    public void addRecord(String record) { System.out.println("InPatient Record Added: " + record); }
    public void viewRecords() { System.out.println("Viewing InPatient Records..."); }
}

class OutPatient extends Patient implements MedicalRecord {
    public OutPatient(int id, String name, int age) { super(id, name, age); }
    public double calculateBill() { return 1000; }
    public void addRecord(String record) { System.out.println("OutPatient Record Added: " + record); }
    public void viewRecords() { System.out.println("Viewing OutPatient Records..."); }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Patient[] patients = {
            new InPatient(1, "Raj", 30),
            new OutPatient(2, "Simran", 25)
        };

        for (Patient p : patients) {
            System.out.println(p.getPatientDetails() + " Bill: " + p.calculateBill());
        }
    }
}
