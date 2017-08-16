package test2_3;

import edu.princeton.cs.algs4.StdRandom;
import test2_1.Example;

/**
 * Created by albert on 2017/5/24.
 */
public class Quick3way {
    private static void sort(Comparable[] a, int lo, int hi){
        if (lo >= hi)
            return;
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while (i<=gt){
            int cmp = a[i].compareTo(v);
            if (cmp < 0)
                Example.exch(a,i++,lt++);
            else if (cmp > 0)
                Example.exch(a,i,gt--);
            else
                i++;
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }
}
