import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Item {
    int value;
    int weight;
    double ratio;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;
    }

    public double getRatio() {
        return ratio;
    }
}

public class FractionalKnapsackProblem {
    public static void main(String[] args) {
        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int capacity = 50;

        List<Item> items = createItemList(values, weights);
        List<Item> selectedItems = fractionalKnapsack(items, capacity);

        int maxProfit = calculateMaxProfit(selectedItems);
        System.out.println("Maximum profit: " + maxProfit);

        System.out.println("Selected items:");
        for (Item item : selectedItems) {
            System.out.println("Value: " + item.value + ", Weight: " + item.weight);
        }
    }

    public static List<Item> fractionalKnapsack(List<Item> items, int capacity) {
        items.sort(Comparator.comparingDouble(Item::getRatio).reversed());

        List<Item> selectedItems = new ArrayList<>();

        int currentWeight = 0;
        double currentProfit = 0.0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                selectedItems.add(item);
                currentWeight += item.weight;
                currentProfit += item.value;
            } else {
                double remainingWeight = capacity - currentWeight;
                double fraction = remainingWeight / item.weight;
                selectedItems.add(new Item((int) (fraction * item.value), (int) remainingWeight));
                currentProfit += fraction * item.value;
                break;
            }
        }

        return selectedItems;
    }

    public static List<Item> createItemList(int[] values, int[] weights) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            items.add(new Item(values[i], weights[i]));
        }
        return items;
    }

    public static int calculateMaxProfit(List<Item> selectedItems) {
        int maxProfit = 0;
        for (Item item : selectedItems) {
            maxProfit += item.value;
        }
        return maxProfit;
    }
}
