
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

class HuffmanNode {

    int item;
    char c;
    HuffmanNode left;
    HuffmanNode right;
}

class ImplementComparator implements Comparator<HuffmanNode> {

    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.item - y.item;
    }
}

public class HuffmanFromString {

    public static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + "    | " + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter The String: ");
        String input = in.nextLine();
        Map<Character, Integer> frequencyTable = createFrequencyTable(input);

        int n = frequencyTable.size();
        char[] charArray = new char[n];
        int[] charfreq = new int[n];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : frequencyTable.entrySet()) {
            charArray[index] = entry.getKey();
            charfreq[index] = entry.getValue();
            System.out.println(entry.getKey() + ": " + entry.getValue());
            index++;
        }

        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new ImplementComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.item = charfreq[i];
            hn.left = null;
            hn.right = null;
            q.add(hn);
        }

        HuffmanNode root = null;

        while (q.size() > 1) {
            HuffmanNode x = q.peek();
            q.poll();

            HuffmanNode y = q.peek();
            q.poll();

            HuffmanNode f = new HuffmanNode();
            f.item = x.item + y.item;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;
            q.add(f);
        }

        System.out.println("Char | Code");
        System.out.println("-----|-----");
        printCode(root, "");
    }

    public static Map<Character, Integer> createFrequencyTable(String input) {
        Map<Character, Integer> frequencyTable = new HashMap<>();

        for (char c : input.toCharArray()) {
            frequencyTable.put(c, frequencyTable.getOrDefault(c, 0) + 1);
        }

        return frequencyTable;
    }
}