public static String[] customSplit(String text) {
    int wordCount = 1;
    for (int i = 0;; i++) {
        try {
            if (text.charAt(i) == ' ') wordCount++;
        } catch (Exception e) {
            break;
        }
    }
    String[] words = new String[wordCount];
    int start = 0, wordIndex = 0;
    for (int i = 0;; i++) {
        try {
            if (text.charAt(i) == ' ') {
                words[wordIndex++] = text.substring(start, i);
                start = i + 1;
            }
        } catch (Exception e) {
            words[wordIndex] = text.substring(start);
            break;
        }
    }
    return words;
}
public static boolean compareArrays(String[] a, String[] b) {
    if (a.length != b.length) return false;
    for (int i = 0; i < a.length; i++) {
        if (!a[i].equals(b[i])) return false;
    }
    return true;
}