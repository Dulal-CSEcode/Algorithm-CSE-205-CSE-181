/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_final;
/**
 * @author Maria
 */
import java.util.*;

public class DFSExample {
    private int V;
    private LinkedList<Integer> adj[];

    DFSExample(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int start) {
        boolean visited[] = new boolean[V];
        DFSUtil(start, visited);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        DFSExample g = new DFSExample(V);

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        System.out.println("Enter edges (u v) one by one:");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);  
        }

        System.out.print("Enter start node (0-" + (V - 1) + "): ");
        int start = sc.nextInt();

        System.out.println("DFS Traversal:");
        g.DFS(start);
    }
}


/*


Enter number of vertices: 6
Enter number of edges: 6
Enter edges (u v) one by one:
0 1
0 2
1 3
1 4
2 5
3 5
Enter start node (0-5): 0




DFS Traversal:
0 1 3 5 4 2


*/