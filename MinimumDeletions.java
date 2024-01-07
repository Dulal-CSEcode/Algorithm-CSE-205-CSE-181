
import java.util.Scanner;

public class MinimumDeletions {
    public static int minDeletions(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int commonLength = dp[str1.length()][str2.length()];
        int deletions = str1.length() - commonLength;

        return deletions;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter The 1st String: ");
        String str1 = in.nextLine();
        System.out.print("Enter The 2nd String: ");
        String str2 = in.nextLine();

        int minDeletions = minDeletions(str1, str2);
        System.out.println("Minimum deletions: " + minDeletions);
    }
}