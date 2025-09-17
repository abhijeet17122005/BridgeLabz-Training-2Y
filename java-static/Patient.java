public class Patient {
    private static String hospitalName = "General Hospital";
    private static int totalPatients = 0;

    private final String patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID; // final
        totalPatients++;
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    public static String getHospitalName() {
        return hospitalName;
    }

    public void displayDetails(Object obj) {
        if (obj instanceof Patient) {
            System.out.println("Hospital: " + Patient.hospitalName);
            System.out.println("Patient Name: " + this.name);
            System.out.println("Age: " + this.age);
            System.out.println("Ailment: " + this.ailment);
            System.out.println("Patient ID: " + this.patientID);
        } else {
            System.out.println("Object is not a Patient.");
        }
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("Karan", 45, "Fever", "PT1001");
        Patient p2 = new Patient("Lata", 30, "Fracture", "PT1002");

        System.out.println("Hospital: " + Patient.getHospitalName());
        System.out.println("Total Patients: " + Patient.getTotalPatients());
        p1.displayDetails(p1);
        p2.displayDetails("random");
    }
}
