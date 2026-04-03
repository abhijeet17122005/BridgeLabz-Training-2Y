import java.util.Scanner;

public class ValidIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter IP address: ");
        String ip = sc.nextLine();
        System.out.println(isValidIPv4(ip) ? "Valid IP" : "Invalid IP");
        sc.close();
    }

    public static boolean isValidIPv4(String ip) {
        if (ip == null || ip.length() == 0) return false;
        String[] parts = ip.split("\\.");
        if (parts.length != 4) return false;

        for (String part : parts) {
            if (part.length() == 0 || part.length() > 3) return false;
            if (part.charAt(0) == '0' && part.length() > 1) return false;

            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }

            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) return false;
        }
        return true;
    }
}
