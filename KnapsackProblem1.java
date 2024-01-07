public class KnapsackProblem1 {
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = { 2, 5, 7, 3, 1 };
        int[] values = { 10, 8, 12, 6, 9 };
        int capacity = 9;

        int maxValue = knapsack(weights, values, capacity);
        System.out.println("Max Value: " + maxValue);
    }
}
