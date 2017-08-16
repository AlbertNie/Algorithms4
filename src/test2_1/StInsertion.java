package test2_1;

/**
 * Created by albert on 2017/5/4.
 */
public class StInsertion extends Example {
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 1; i < N; i++) {
            if (less(a[i],a[0]))
                exch(a,i,0);
            for (int j = i; less(a[j],a[j-1]); j--) {
                exch(a,j,j-1);
            }
        }
    }
}
