package test5_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.MinPQ;

/**
 * Created by albert on 2017/7/27.
 */
public class Huffman {
    private static final int R = 256;

    public static void compress(){
        String s = BinaryStdIn.readString();
        char[] input = s.toCharArray();
        int[] freq = new int[R];
        for (int i = 0; i < input.length; i++) {
            freq[input[i]]++;
        }
        Node root = buildTrie(freq);
        String[] st = new String[R];
        buildCode(st,root,"");
        writeTrie(root);
        BinaryStdOut.write(input.length);
        for (int i = 0; i < input.length; i++) {
            String code = st[input[i]];
            for (int j = 0; j < code.length(); j++) {
                if (code.charAt(j) == '1')
                    BinaryStdOut.write(true);
                else BinaryStdOut.write(false);
            }
        }
        BinaryStdOut.close();
    }

    private static void writeTrie(Node x) {
        if (x.isLeaf()){
            BinaryStdOut.write(true);
            BinaryStdOut.write(x.ch);
            return;
        }
        BinaryStdOut.write(false);
        writeTrie(x.left);
        writeTrie(x.right);
    }

    private static void buildCode(String[] st, Node x, String s) {
        if (x.isLeaf()){
            st[x.ch] = s;
            return;
        }
        buildCode(st,x.left,s+'0');
        buildCode(st,x.right,s+'1');
    }

    private static Node buildTrie(int[] freq) {
        MinPQ<Node> pq = new MinPQ<>();
        for (char c = 0; c < R; c++) {
            if (freq[c] > 0)
                pq.insert(new Node(c,freq[c],null,null));
        }
        while (pq.size() > 1){
            Node x = pq.delMin();
            Node y = pq.delMin();
            Node parent = new Node('\0',x.freq+y.freq,x,y);
            pq.insert(parent);
        }
        return pq.delMin();
    }

    private static class Node implements Comparable<Node>{
        private char ch;
        private int freq;
        private final Node left,right;

        public Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public boolean isLeaf(){
            return left == null && right == null;
        }

        @Override
        public int compareTo(Node o) {
            return this.freq - o.freq;
        }
    }
}
