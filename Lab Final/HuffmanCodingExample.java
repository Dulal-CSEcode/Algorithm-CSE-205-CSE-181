/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_final;
/**
 * @author Maria
 */
import java.util.PriorityQueue;
import java.util.Scanner;

class HuffmanNode {
    int freq;
    char c;
    HuffmanNode left, right;
}

class MyComparator implements java.util.Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.freq - y.freq;
    }
}

public class HuffmanCodingExample {

    public static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ": " + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] charArray = new char[n];
        int[] charFreq = new int[n];

        System.out.println("Enter character and its frequency:");
        for (int i = 0; i < n; i++) {
            charArray[i] = sc.next().charAt(0);
            charFreq[i] = sc.nextInt();
        }

        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new MyComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.freq = charFreq[i];
            hn.left = null;
            hn.right = null;
            q.add(hn);
        }

        HuffmanNode root = null;

        while (q.size() > 1) {
            HuffmanNode x = q.poll();
            HuffmanNode y = q.poll();

            HuffmanNode f = new HuffmanNode();
            f.freq = x.freq + y.freq;
            f.c = '-';
            f.left = x;
            f.right = y;

            root = f;
            q.add(f);
        }

        System.out.println("\nHuffman Codes:");
        printCode(root, "");
    }
}

/*


Enter number of characters: 6
Enter character and its frequency:
a 5
b 9
c 12
d 13
e 16
f 45


Huffman Codes:
f: 0
c: 100
d: 101
a: 1100
b: 1101
e: 111


*/