package test2_2;

/**
 * Created by albert on 2017/5/9.
 */
public class Merge {
    private static int count=0; // 用于计算访问数组的次数
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        int i = lo;
        int j = mid+1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        count += a.length; // 数组访问次数

        for (int k = lo; k <= hi; k++) {
            if (i>mid) {
                a[k] = aux[j++];
                count++;
            } else if (j>hi) {
                a[k] = aux[i++];
                count++;
            }
            else if (less(aux[i],aux[j])) {
                a[k] = aux[i++];
                count++;
            }
            else {
                a[k] = aux[j++];
                count++;
            }
        }
    }

    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }

    private static void sort(Comparable[]a, Comparable[] aux, int lo, int hi){
        if (hi<=lo)
            return;
        int mid = lo + (hi-lo)/2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        merge(a,aux,lo,mid,hi);
    }

    protected static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }

    public static int getCount(){
        int a = count;
        count=0;
        return a;
    }
}
