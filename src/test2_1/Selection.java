package test2_1;

/**
 * Created by albert on 2017/5/4.
 */
public class Selection extends Example {
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j],a[i]))
                    min = j;
            }
            exch(a,i,min);
        }
    }
}
