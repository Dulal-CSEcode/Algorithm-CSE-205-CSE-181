import java.util.*;

public class Kruskal {
    static int[] parent;

    public static void makeSet(int v) {
        parent[v] = v;
    }

    public static int findSet(int v) {
        if (v == parent[v])
            return v;
        return findSet(parent[v]);
    }

    public static void unionSet(int a, int b) {
        int x = findSet(a);
        int y = findSet(b);
        if (x != y)
            parent[b] = a;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Number of Nodes & Edges:");
        int n = input.nextInt();
        int m = input.nextInt();
        int cost = 0;
        parent = new int[n + 1];
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            makeSet(i);
        }

        System.out.println("Enter the Edges & Weight:");

        for (int i = 0; i < m; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            int w = input.nextInt();
            edges.add(new ArrayList<>(Arrays.asList(w, u, v)));
        }

        Collections.sort(edges, Comparator.comparingInt(o -> o.get(0)));

        for (ArrayList<Integer> edge : edges) {
            int w = edge.get(0);
            int u = edge.get(1);
            int v = edge.get(2);
            int x = findSet(u);
            int y = findSet(v);
            if (x == y)
                continue;
            else {
                cost += w;
                unionSet(u, v);
            }
        }

        System.out.println("mincost: " + cost);
    }
}
