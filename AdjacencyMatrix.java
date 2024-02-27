
import java.util.Scanner;

public class AdjacencyMatrix {
    public static int noofvertices;
    public static int[][] adjmatrix;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m, edge;
        System.out.println("Enter the number of Node: ");
        noofvertices = in.nextInt();
        adjmatrix = new int[noofvertices][noofvertices];
        for (int i = 0; i < noofvertices; i++) {
            for (int j = 0; j < noofvertices; j++) {
                adjmatrix[i][j] = 0;
            }
        }
        System.out.println("Enter the number of edge:");
        edge = in.nextInt();
        for (int i = 0; i < edge; i++) {
            System.out.println("Enter the source and destination of edge: ");
            n = in.nextInt();
            m = in.nextInt();
            adjmatrix[n][m] = 1;
            adjmatrix[m][n] = 1;
        }
        printmatrix();
    }

    public static void printmatrix() {
        for (int i = 0; i < noofvertices; i++) {
            for (int j = 0; j < noofvertices; j++) {
                System.out.print(adjmatrix[i][j] + " ");
            }
        }
    }
}
