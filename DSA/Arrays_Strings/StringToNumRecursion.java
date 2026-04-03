// public class StringToNumRecursion {
//     public static int stringToNum(String str, int n) {
//         if (n == 0) {
//             return 0;
//         }
//         int digit = str.charAt(n - 1) - '0';
//         return stringToNum(str, n - 1) * 10 + digit;
//     }
//     public static void main(String[] args) {
//         String str = "1234";
//         int result = stringToNum(str, str.length());
//         System.out.println("The integer value is: " + result);


//     }
// }

// dry-run example:
// str = "1234"
// n = 4
// stringToNum("1234", 4)
//     stringToNum("1234", 3) * 10 + 4
//         stringToNum("1234", 3)
//             stringToNum("1234", 2) * 10 + 3
//                 stringToNum("1234", 2)
//                     stringToNum("1234", 1) * 10 + 2
//                         stringToNum("1234", 1)
//                             stringToNum("1234", 0) * 10 + 1
//                                 n == 0 -> return 0
//                             return 0 * 10 + 1 = 1
//                         return 1 * 10 + 2 = 12
//                     return 12 * 10 + 3 = 123
//                 return 123 * 10 + 4 = 1234
//     return 1234


public class StringToNumRecursion {

    public static void main(String[] args) {
        String str = "1234";
        int n = str.length();
        while(n!=0){
            int digit = str.charAt(n - 1) - '0';
            
            System.out.println(digit);
            n--;
        }
    }
}