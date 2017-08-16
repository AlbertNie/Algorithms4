package test2_1;

/**
 * Created by albert on 2017/5/4.
 */
public class Shell extends Example{
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        int count = 0;
        while(h < N/3){
            h = h* 3 + 1;
        }
        while (h >= 1){
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j],a[j-h]); j -= h) {
                    exch(a,j,j-h);
                }
            }
            System.out.print(getCount()/N + " ; ");
            h /= 3;
        }
        System.out.println("--------------");
    }
}
