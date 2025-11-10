import java.util.*;

public class PatientIDPrint {
    public static void main(String[] args) {
        List<String> patientIDs = Arrays.asList("P101", "P102", "P103", "P104");

        // Using lambda expression
        System.out.println("Using Lambda:");
        patientIDs.forEach(id -> System.out.println(id));

        // Using method reference
        System.out.println("\nUsing Method Reference:");
        patientIDs.forEach(System.out::println);
    }
}
