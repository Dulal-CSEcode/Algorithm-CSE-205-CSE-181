import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjacencyList {
    static List<List<Integer>> adjList;
    static int noOfVertices;

    public static void addEdge(int a, int b) {
        if (a >= noOfVertices || b >= noOfVertices) {
            System.out.println("Invalid Edge!");
        } else {
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
    }

    public static void printList() {
        for (int i = 0; i < noOfVertices; i++) {
            System.out.print("Vertex " + i + " -> ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int a, b, edgeNo;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        noOfVertices = scanner.nextInt();

        adjList = new ArrayList<>(noOfVertices);
        for (int i = 0; i < noOfVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        System.out.print("Enter the number of edges: ");
        edgeNo = scanner.nextInt();

        for (int i = 1; i <= edgeNo; i++) {
            System.out.printf("Enter the %dth edge: ", i);
            a = scanner.nextInt();
            b = scanner.nextInt();
            addEdge(a, b);
        }

        printList();
        scanner.close();
    }
}
