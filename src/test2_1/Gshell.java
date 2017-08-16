package test2_1;

/**
 * Created by albert on 2017/5/4.
 */
public class Gshell extends Example {
    public static void sort(Comparable[] a){
        int N = a.length;
        int count = 0;
        int h = 1;
        while (h < N/3){
            h = h*3 + 1;
            count++;
        }
        int[] diz = new int[count];
        for (int i = 0; i < count; i++) {
            diz[i] = h;
            h = h/3;
        }

        for (int i = 0; i < count; i++) {
            for (int j = diz[i]; j < N; j++) {
                for (int k = j; k > diz[i] && less(a[j],a[j-diz[i]]); k -= diz[i]) {
                    exch(a,j,j-diz[i]);
                }
            }
        }
    }
}
