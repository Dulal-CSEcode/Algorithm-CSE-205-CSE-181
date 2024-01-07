/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.uvap10305;

/**
 *
 * @author gub Md Dulal Hossain ID 213902116 Email: dulal.md.cse@gmail.com
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class UVAP10305 {

    public static int[][] edges;
    public static int[] edgesCount;
    public static boolean[] visited;
    public static int[] ints;
    public static int intsCount;

    public static void topologicalSort(int id) {
        if (!visited[id]) {
            visited[id] = true;
            for (int i = 0; i < edgesCount[id]; i++) {
                topologicalSort(edges[id][i]);
            }
            ints[intsCount++] = id;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            edges = new int[n + 1][n + 1];
            edgesCount = new int[n + 1];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int src = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());
                edges[src][edgesCount[src]++] = dest;
            }
            visited = new boolean[n + 1];
            ints = new int[n];
            intsCount = 0;
            for (int i = 1; i <= n; i++) {
                topologicalSort(i);
            }
            for (int i = intsCount - 1; i >= 0; i--) {
                System.out.print(ints[i]);
                if (i == 0) {
                    System.out.println();
                } else {
                    System.out.print(" ");
                }
            }
        }
    }
}
/*

Sample Input

5 4
1 2
2 3
1 3
1 5
0 0

Sample Output

1 4 2 5 3


*/