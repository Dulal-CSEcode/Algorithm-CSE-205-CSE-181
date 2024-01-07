import java.util.*;

public class LCS1 {

    // Returns length of LCS for X[0..m-1], Y[0..n-1]
    int lcs(String X, String Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];

        // Following steps build L[m+1][n+1] in bottom up
        // fashion. Note that L[i][j] contains length of LCS
        // of X[0..i-1] and Y[0..j-1]
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }

    // Utility function to get max of 2 integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Prints the LCS string
    void printLCS(String X, String Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];

        // Construct the LCS matrix
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
            }
        }

        // Retrieve the LCS string
        int index = L[m][n];
        int length = index;
        char[] lcs = new char[length + 1];
        lcs[length] = '\0'; // Add null character at the end

        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs[index - 1] = X.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (L[i - 1][j] > L[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // Print the LCS string
        System.out.println("Longest Common Subsequence: " + new String(lcs));
    }

    public static void main(String[] args) {
        LCS1 lcs = new LCS1();
        String S1 = "AGGTAB";
        String S2 = "GXTXAYB";
        int m = S1.length();
        int n = S2.length();

        int lcsLength = lcs.lcs(S1, S2, m, n);
        System.out.println("Length of LCS is: " + lcsLength);
        if (lcsLength > 0) {
            lcs.printLCS(S1, S2, m, n);
        }
    }
}
