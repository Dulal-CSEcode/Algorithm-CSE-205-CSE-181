import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of Node And edge: ");
        int n = input.nextInt();
        int m = input.nextInt();
        final int inf = 10000000;

        ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(n + 1, inf));
        ArrayList<ArrayList<Pair<Integer, Integer>>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            int w = input.nextInt();
            graph.get(u).add(new Pair<>(v, w));
            graph.get(v).add(new Pair<>(u, w));
        }

        int source = input.nextInt();

        dist.set(source, 0);

        TreeSet<Pair<Integer, Integer>> s = new TreeSet<>(Comparator.comparingInt(Pair::getKey));
        for (int i = 1; i <= n; i++) {
            if (dist.get(i) < inf)
                System.out.print(dist.get(i) + "\t");
            else
                System.out.print(-1 + "\t");
        }
        System.out.println();

        s.add(new Pair<>(0, source));
        while (!s.isEmpty()) {
            Pair<Integer, Integer> x = s.first();
            s.remove(x);
            for (Pair<Integer, Integer> i : graph.get(x.getValue())) {
                if (dist.get(i.getKey()) > dist.get(x.getValue()) + i.getValue()) {
                    s.remove(new Pair<>(dist.get(i.getKey()), i.getKey()));
                    dist.set(i.getKey(), dist.get(x.getValue()) + i.getValue());
                    s.add(new Pair<>(dist.get(i.getKey()), i.getKey()));
                }
            }
            for (int i = 1; i <= n; i++) {
                if (dist.get(i) < inf)
                    System.out.print(dist.get(i) + "\t");
                else
                    System.out.print(-1 + "\t");
            }
            System.out.println();
        }
        System.out.print("final output: \t");
        for (int i = 1; i <= n; i++) {
            if (dist.get(i) < inf)
                System.out.print(dist.get(i) + "\t");
            else
                System.out.print(-1 + "\t");
        }
    }

    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
