import java.util.*;
import java.util.stream.Collectors;

class Invoice {
    String transactionId;

    Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice created for Transaction: " + transactionId;
    }
}

public class InvoiceGenerator {
    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList("TXN001", "TXN002", "TXN003");

        // Using constructor reference to create Invoice objects
        List<Invoice> invoices = transactionIds.stream()
                                               .map(Invoice::new)
                                               .collect(Collectors.toList());

        System.out.println("Generated Invoices:");
        invoices.forEach(System.out::println);
    }
}
