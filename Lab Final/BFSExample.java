/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_final;
/**
 * @author Maria
 */
import java.util.*;

public class BFSExample {
    private int V;
    private LinkedList<Integer> adj[];

    BFSExample(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int n : adj[node]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        BFSExample g = new BFSExample(V);

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

        System.out.println("BFS Traversal:");
        g.BFS(start);
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





BFS Traversal:
0 1 2 3 4 5


*/