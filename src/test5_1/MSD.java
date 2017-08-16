package test5_1;

import edu.princeton.cs.algs4.Insertion;

/**
 * Created by albert on 2017/7/18.
 */
public class MSD {
    private static int R = 256;
    private static final int M = 15;
    private static String[] aux;
    private static int charAt(String a, int d){
        if (d < a.length()) return a.charAt(d);
        else return -1;
    }

    public static void sort(String[] a){
        int N = a.length;
        aux = new String[N];
        sort(a,0,N-1,0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi < lo + M){
            Insertion.sort(a,lo,hi);
            return;
        }
        int[] count = new int[R+2];
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i],d)+2]++;
        }
        for (int i = 0; i < R+1; i++) {
            count[i+1] += count[i];
        }
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i],d)+1]++] = a[i];
        }
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i-lo];
        }
        for (int i = 0; i < R+1; i++) {
            sort(a,lo+count[i],lo+count[i+1]-1,d+1);
        }
    }
}
