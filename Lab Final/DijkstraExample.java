/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_final;
/**
 * @author Maria
 */
import java.util.*;

public class DijkstraExample {
    private int V;

    DijkstraExample(int v) {
        V = v;
    }

    int minDistance(int dist[], boolean sptSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    void printSolution(int dist[]) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t " + dist[i]);
    }

    // Dijkstra's Algorithm
    void dijkstra(int graph[][], int src) {
        int dist[] = new int[V];  
        boolean sptSet[] = new boolean[V]; 

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        DijkstraExample t = new DijkstraExample(V);

        int graph[][] = new int[V][V];
        System.out.println("Enter adjacency matrix (0 if no edge):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter source vertex (0-" + (V - 1) + "): ");
        int src = sc.nextInt();

        t.dijkstra(graph, src);
    }
}

/*


Enter number of vertices: 5
Enter adjacency matrix (0 if no edge):
0 10 0 0 5
0 0 1 0 2
0 0 0 4 0
7 0 6 0 0
0 3 9 2 0
Enter source vertex (0-4): 0




Vertex   Distance from Source
0        0
1        8
2        9
3        7
4        5


*/