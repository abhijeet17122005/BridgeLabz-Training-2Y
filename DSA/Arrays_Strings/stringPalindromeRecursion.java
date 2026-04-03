public class stringPalindromeRecursion {

    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String str = "naman";
        int n = str.length();
        if (isPalindrome(str, 0, n - 1)) {
            System.out.println(str + " is palindrome.");
        } else {
            System.out.println(str + " is not palindrome.");
        }
    }
}

// dry-run example:
// str = "racecar"
// n = 7
// isPalindrome("racecar", 0, 6)
//     'r' == 'r' -> isPalindrome("racecar", 1, 5)
//         'a' == 'a' -> isPalindrome("racecar", 2, 4)
//             'c' == 'c' -> isPalindrome("racecar", 3, 3)
//                 start >= end -> return true
//             return true
//         return true
//     return true