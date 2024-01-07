import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Prims {
    static int n, m;
    static int N = 10000000;
    static int INF = 100000000;
    static int cost = 0;

    static List<List<int[]>> g = new ArrayList<>();
    static int dist[];
    static int Parent[];
    static boolean vis[];

    public static void prims(int source) {
        dist = new int[n + 1];
        Parent = new int[n + 1];
        vis = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dist[i] = INF;
        }
        dist[source] = 0;
        TreeSet<int[]> set = new TreeSet<>((a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        set.add(new int[] { 0, source
        });
        while (!set.isEmpty()) {
            int x[] = set.pollFirst();
            int w = x[0];
            int u = x[1];
            vis[u] = true;
            cost += w;
            for (int[] i : g.get(u)) {
                if (vis[i[0]]) {
                    continue;
                }
                if (dist[i[0]] > i[1]) {
                    set.remove(new int[] { dist[i[0]], i[1] });
                    dist[i[0]] = i[1];
                    set.add(new int[] { dist[i[0]], i[0]
                    });
                    Parent[i[0]] = u;
                }

            }
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter The Number Of Node and Edge: ");
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        System.out.println("Enter the Edges And Weight: ");
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            g.get(u).add(new int[] { v, w });
            g.get(v).add(new int[] { u, w });
        }
    }
}
