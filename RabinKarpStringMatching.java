public class RabinKarpStringMatching {
    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
        String pattern = "ipsum";

        rabinKarpStringMatch(text, pattern);
    }

    public static void rabinKarpStringMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int prime = 101; // A prime number

        int textHash = calculateHash(text.substring(0, m), prime);
        int patternHash = calculateHash(pattern, prime);

        for (int i = 0; i <= n - m; i++) {
            if (textHash == patternHash && checkEqual(text, i, i + m - 1, pattern)) {
                System.out.println("Pattern found at index " + i);
            }

            if (i < n - m) {
                textHash = recalculateHash(text, i, i + m, textHash, prime);
            }
        }
    }

    public static int calculateHash(String str, int prime) {
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash += str.charAt(i) * Math.pow(prime, i);
        }
        return hash;
    }

    public static int recalculateHash(String str, int oldIndex, int newIndex, int oldHash, int prime) {
        int newHash = oldHash - str.charAt(oldIndex);
        newHash /= prime;
        newHash += str.charAt(newIndex) * Math.pow(prime, newIndex - oldIndex - 1);
        return newHash;
    }

    public static boolean checkEqual(String str1, int start1, int end1, String str2) {
        int len = end1 - start1 + 1;
        for (int i = 0; i < len; i++) {
            if (str1.charAt(start1 + i) != str2.charAt(i))
                return false;
        }
        return true;
    }
}
