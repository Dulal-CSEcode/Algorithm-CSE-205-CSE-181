/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_final;
/**
 * @author Maria
 */
import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class Subset {
    int parent, rank;
}

public class KruskalExample {
    int V, E;
    Edge[] edges;

    KruskalExample(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; ++i)
            edges[i] = new Edge();
    }

    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void KruskalMST() {
        Edge result[] = new Edge[V];  
        int e = 0; 
        int i = 0; 

        for (int j = 0; j < V; ++j)
            result[j] = new Edge();

        Arrays.sort(edges);

        Subset subsets[] = new Subset[V];
        for (int v = 0; v < V; ++v) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        while (e < V - 1 && i < E) {
            Edge next_edge = edges[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
        }

        System.out.println("Edges in the Minimum Spanning Tree:");
        int totalWeight = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " - " + result[i].dest + " : " + result[i].weight);
            totalWeight += result[i].weight;
        }
        System.out.println("Total Weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        KruskalExample graph = new KruskalExample(V, E);

        System.out.println("Enter edges (src dest weight):");
        for (int i = 0; i < E; i++) {
            graph.edges[i].src = sc.nextInt();
            graph.edges[i].dest = sc.nextInt();
            graph.edges[i].weight = sc.nextInt();
        }

        graph.KruskalMST();
    }
}

/*


Enter number of vertices: 4
Enter number of edges: 5
Enter edges (src dest weight):
0 1 10
0 2 6
0 3 5
1 3 15
2 3 4


Edges in the Minimum Spanning Tree:
2 - 3 : 4
0 - 3 : 5
0 - 1 : 10
Total Weight of MST: 19






*/