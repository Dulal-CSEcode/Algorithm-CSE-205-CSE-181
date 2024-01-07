import java.util.*;

public class PrimsMST {
    static int n, m;
    static int cost = 0;
    static final int N = 999;
    static final int INF = 1_000_000_000;

    static List<List<int[]>> g = new ArrayList<>();
    static int[] dist;
    static int[] parent;
    static boolean[] vis;

    static void primsMST(int source) {
        dist = new int[n + 1];
        parent = new int[n + 1];
        vis = new boolean[n + 1];

        Arrays.fill(dist, INF);// initializing the distance array with infinity
        dist[source] = 0;

        TreeSet<int[]> set = new TreeSet<>((a, b) -> {// comparator for the treeset
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        set.add(new int[] { 0, source });

        while (!set.isEmpty()) {
            int[] x = set.pollFirst();

            int w = x[0];
            int u = x[1];

            vis[u] = true;

            cost += w;

            for (int[] i : g.get(u)) {
                if (vis[i[0]])
                    continue;
                if (dist[i[0]] > i[1]) {
                    set.remove(new int[] { dist[i[0]], i[0] });
                    dist[i[0]] = i[1];
                    set.add(new int[] { dist[i[0]], i[0] });
                    parent[i[0]] = u;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number of Nodes:");
        n = scanner.nextInt();
        System.out.print("Enter The Number Of Edges: ");
        m = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());// initializing the graph
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();

            g.get(u).add(new int[] { v, w });// adding the edge
            g.get(v).add(new int[] { u, w });
        }

        primsMST(0);
        System.out.println(cost);
        scanner.close();
    }
}
