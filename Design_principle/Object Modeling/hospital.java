import java.util.ArrayList;

// Patient class
class Patient {
    String name;
    ArrayList<Doctor> doctors;  // Many doctors per patient

    Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    // Add doctor for this patient
    void addDoctor(Doctor d) {
        if (!doctors.contains(d)) {
            doctors.add(d);
        }
    }

    // Show doctors this patient consulted
    void showDoctors() {
        System.out.println("Patient: " + name + " has consulted:");
        for (Doctor d : doctors) {
            System.out.println("- Dr. " + d.name);
        }
        System.out.println();
    }
}

// Doctor class
class Doctor {
    String name;
    ArrayList<Patient> patients;  // Many patients per doctor

    Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    // Communication: doctor consults a patient
    void consult(Patient p) {
        if (!patients.contains(p)) {
            patients.add(p);
        }
        p.addDoctor(this); // Maintain bidirectional association
        System.out.println("Dr. " + name + " consulted patient " + p.name);
    }

    // Show patients seen by this doctor
    void showPatients() {
        System.out.println("Dr. " + name + " has seen:");
        for (Patient p : patients) {
            System.out.println("- " + p.name);
        }
        System.out.println();
    }
}

// Hospital class (contains doctors and patients)
class Hospital {
    String hospitalName;
    ArrayList<Doctor> doctors;
    ArrayList<Patient> patients;

    Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    void addDoctor(Doctor d) {
        doctors.add(d);
    }

    void addPatient(Patient p) {
        patients.add(p);
    }

    void showHospital() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Doctors:");
        for (Doctor d : doctors) {
            System.out.println("- Dr. " + d.name);
        }
        System.out.println("Patients:");
        for (Patient p : patients) {
            System.out.println("- " + p.name);
        }
        System.out.println();
    }
}

// Main class to demonstrate
public class HospitalDemo {
    public static void main(String[] args) {
        // Create hospital
        Hospital hosp = new Hospital("City Hospital");

        // Create doctors
        Doctor d1 = new Doctor("Smith");
        Doctor d2 = new Doctor("Johnson");

        // Create patients
        Patient p1 = new Patient("Alice");
        Patient p2 = new Patient("Bob");

        // Add to hospital
        hosp.addDoctor(d1);
        hosp.addDoctor(d2);
        hosp.addPatient(p1);
        hosp.addPatient(p2);

        hosp.showHospital();

        // Consultations (association + communication)
        d1.consult(p1);
        d1.consult(p2);

        d2.consult(p1);

        // Show details
        d1.showPatients();
        d2.showPatients();

        p1.showDoctors();
        p2.showDoctors();
    }
}
