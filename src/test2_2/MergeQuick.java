package test2_2;


import edu.princeton.cs.algs4.Shell;

/**
 * Created by albert on 2017/5/11.
 */
public class MergeQuick {
    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b)<0;
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        int i = lo;
        int j = mid;
        Comparable[] down = new Comparable[hi-mid+1];
        for (int k = 0; k < down.length; k++) {
            down[k] = a[j++];
        }
        j=mid;
        Shell.sort(down);
        for (int k = 0; k < j; k++) {
            aux[k] = a[k];
        }
        for (int k = down.length; k >= 0; k--) {
            aux[j++] = down[k];
        }
        j=mid;

        for (int k = lo; k <= hi; k++) {
            if (less(aux[i],aux[j]))
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
        }
    }

    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo)/2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        merge(a,aux,lo,mid,hi);
    }
}
