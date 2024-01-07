import java.util.ArrayList;
import java.util.List;

public class KnapsackProblem2 {
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

        // Backtrack to find the selected items
        List<Integer> selectedItems = new ArrayList<>();
        int remainingCapacity = capacity;
        for (int i = n; i > 0 && remainingCapacity > 0; i--) {
            if (dp[i][remainingCapacity] != dp[i - 1][remainingCapacity]) {
                selectedItems.add(i - 1);
                remainingCapacity -= weights[i - 1];
            }
        }

        System.out.println("Selected items for knapsack:");
        for (int i = selectedItems.size() - 1; i >= 0; i--) {
            int itemIndex = selectedItems.get(i);
            System.out.println(
                    "Item index: " + itemIndex + ", Weight: " + weights[itemIndex] + ", Value: " + values[itemIndex]);
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
