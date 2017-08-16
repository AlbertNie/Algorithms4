package test2_3;
import edu.princeton.cs.algs4.StdRandom;
import test2_1.Example;

/**
 * Created by albert on 2017/5/24.
 */
public class QuickSimple {
    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi+1;
        Comparable v = a[lo];
        while (true){
            while (Example.less(a[++i],v))
                if (i == hi)
                    break;
            while (Example.less(v,a[++j]))
                if (j == lo)
                    break;
            if (lo >= hi)
                break;
            Example.exch(a,i,j);
        }
        Example.exch(a,lo,j);
        return j;
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo)
            return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }
}
