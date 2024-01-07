
import java.util.*;

class ActivitySelection {

    public static void printMaxActivities(int s[], int f[],
            int n) {
        int i, j;

        System.out.println("Following activities are selected");

        i = 0;
        System.out.print(i + " ");

        // Consider rest of the activities
        for (j = 1; j < n; j++) {
            // If this activity has start time greater than
            // or equal to the finish time of previously
            // selected activity, then select it
            if (s[j] >= f[i]) {
                System.out.print(j + " ");
                i = j;
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of task: ");
        int n = in.nextInt();

        int s[] = new int[n];
        int f[] = new int[n];
        System.out.print("Enter the Start time: ");
        for (int i = 0; i < n; i++) {
            s[i] = in.nextInt();
        }
        System.out.print("Enter the End time: ");
        for (int i = 0; i < n; i++) {
            f[i] = in.nextInt();
        }
        bubbleSort(f, s);

        // Function call
        printMaxActivities(s, f, n);
    }

    static void bubbleSort(int[] arr, int[] s) {
        int n = arr.length;
        int temp = 0, temp1 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    // swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;

                    temp1 = s[j - 1];
                    s[j - 1] = s[j];
                    s[j] = temp1;
                }

            }
        }
    }
}
