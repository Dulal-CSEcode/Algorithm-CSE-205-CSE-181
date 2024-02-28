
//Print Selected item
import java.util.ArrayList;
import java.util.List;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] values = { 10, 8, 7, 3, 1 };
        int[] weights = { 2, 5, 7, 3, 1 };
        int capacity = 9;

        List<Integer> selectedItems = knapsack(values, weights, capacity);

        int maxValue = calculateMaxValue(selectedItems, values);
        System.out.println("Maximum value: " + maxValue);
        System.out.println("Selected items:");
        for (int item : selectedItems) {
            System.out.println("Item " + item);
        }
    }

    public static List<Integer> knapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return getSelectedItems(dp, values, weights, capacity);
    }

    public static List<Integer> getSelectedItems(int[][] dp, int[] values, int[] weights, int capacity) {
        List<Integer> selectedItems = new ArrayList<>();
        int i = dp.length - 1;
        int j = dp[0].length - 1;

        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                selectedItems.add(i);
                j -= weights[i - 1];
                i--;
            } else {
                i--;
            }
        }

        return selectedItems;
    }

    public static int calculateMaxValue(List<Integer> selectedItems, int[] values) {
        int maxValue = 0;
        for (int item : selectedItems) {
            maxValue += values[item - 1];
        }
        return maxValue;
    }
}
