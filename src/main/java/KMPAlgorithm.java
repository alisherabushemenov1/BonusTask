public class KMPAlgorithm {

    public static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int length = 0; // length of the previous longest prefix suffix
        int i = 1;

        lps[0] = 0; // LPS of the first character is always 0

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    // This is tricky: do not increment i here
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    /**
     * KMP search algorithm.
     * Searches for occurrences of the pattern string within the text string efficiently.
     *
     * @param text    the text string
     * @param pattern the pattern string to search for
     */
    public static void KMPSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        // Preprocess the pattern to get LPS array
        int[] lps = computeLPSArray(pattern);

        int i = 0; // index for text
        int j = 0; // index for pattern

        System.out.println("Pattern found at indices: ");

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                // Pattern found at index (i - j)
                System.out.print((i - j) + " ");
                j = lps[j - 1]; // Continue searching for next occurrences
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1]; // Use LPS to skip comparisons
                } else {
                    i++;
                }
            }
        }

        System.out.println(); // newline after printing indices
    }

    // Main function to test the algorithm with different string lengths
    public static void main(String[] args) {
        // Short string test
        String text1 = "ABABDABACDABABCABAB";
        String pattern1 = "ABABCABAB";
        System.out.println("Short string test:");
        KMPSearch(text1, pattern1);

        // Medium-length string test
        String text2 = "THISISAMEDIUMLENGTHTEXTWITHSOMEMEDIUMPATTERNSFORTESTINGKMP";
        String pattern2 = "MEDIUM";
        System.out.println("\nMedium-length string test:");
        KMPSearch(text2, pattern2);

        // Long string test
        String text3 = "A".repeat(1000) + "B" + "A".repeat(1000); // 2001 characters
        String pattern3 = "AAAB";
        System.out.println("\nLong string test:");
        KMPSearch(text3, pattern3);
    }
}

