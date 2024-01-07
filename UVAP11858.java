/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.uvap11858;

/**
 *
 * @author gub Md Dulal Hossain ID 213902116 Email: dulal.md.cse@gmail.com
 */
import java.io.*;
import java.util.*;

public class UVAP11858 {

    public static void main(String... args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(isr);
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(in.readLine());
            }
            long inversions = countInversions(arr);
            System.out.println("\nOutput :\n "+inversions);
        }
    }

    static long countInversions(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        long ansLeft = countInversions(left);
        long ansRight = countInversions(right);
        return ansLeft + ansRight + merge(left, right, arr);
    }

    static long merge(int[] left, int[] right, int[] arr) {
        long inv = 0;
        int i = 0, j = 0, k = 0;
        while (i < left.length || j < right.length) {
            if (i >= left.length) {
                arr[k++] = right[j++];
            } else if (j >= right.length) {
                arr[k++] = left[i++];
            } else {
                if (left[i] < right[j]) {
                    arr[k++] = left[i++];
                } else {
                    inv += left.length - i;
                    arr[k++] = right[j++];
                }
            }
        }
        return inv;
    }
}
/*

Sample Input


3
3
1
2



Sample Output


2


*/