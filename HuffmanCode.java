import java.util.Comparator;
import java.util.PriorityQueue;
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

public class HuffmanCode {
    public static void printCode(HuffmanNode root, String ch) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + "   | " + ch);
            return;
        }
        printCode(root.left, ch + "0");
        printCode(root.right, ch + "1");
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        char[] charArray = new char[10];
        int[] freqarray = new int[10];
        System.out.println("Enter the Number of Characters ");
        int ch = in.nextInt();
        in.nextLine(); // Consume the newline character
        System.out.println("Enter thE Characters & Frequencies:");
        for (int i = 0; i < ch; i++) {
            charArray[i] = in.next().charAt(0);
            freqarray[i] = in.nextInt();
            in.nextLine(); // Consume the newline character
        }

        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(ch, new ImplementComparator());

        for (int i = 0; i < ch; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.item = freqarray[i];
            hn.c = charArray[i];
            hn.right = null;
            hn.left = null;
            q.add(hn);
        }

        HuffmanNode root = null;
        while (q.size() > 1) {
            HuffmanNode x = q.peek();
            q.poll();

            HuffmanNode y = q.peek();
            q.poll();

            HuffmanNode hn = new HuffmanNode();
            hn.item = x.item + y.item;
            hn.c = '-';
            hn.left = x;
            hn.right = y;
            root = hn;
            q.add(hn);
        }

        System.out.println("Char | Code");
        System.out.println("-----|-----");
        printCode(root, "");
    }
}
