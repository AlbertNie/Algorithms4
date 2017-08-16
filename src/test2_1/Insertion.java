package test2_1;

/**
 * Created by albert on 2017/5/4.
 */
public class Insertion extends Example {
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j],a[j-1]); j--) {
                exch(a,j,j-1);
            }
        }
    }
}
