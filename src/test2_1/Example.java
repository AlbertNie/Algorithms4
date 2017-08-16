package test2_1;

import edu.princeton.cs.algs4.StdOut;


/**
 * Created by albert on 2017/5/4.
 */
public class Example {
    private static int count = 0;
    public static boolean less(Comparable v, Comparable w){
        count++;
        return v.compareTo(w)<0;
    }
    public static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if (less(a[i],a[i-1]))
                return false;
        }
        return true;
    }

    public static int getCount(){
        int n = count;
        count = 0;
        return n;
    }
}
