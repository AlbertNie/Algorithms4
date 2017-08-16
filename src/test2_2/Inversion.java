package test2_2;

/**
 * Created by albert on 2017/6/8.
 */
public class Inversion {
    private static long merge(int[] a, int[] aux, int lo, int mid, int hi){
        long inversion = 0;
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi)  a[k] = aux[i++];
            else if (less(aux[i],aux[j])) a[k] = aux[i++];
            else {
                a[k] = aux[j++];
                inversion += (j-k-1);
            }
        }
        return inversion;
    }

    public static long count(int[] value){
        int[] aux = new int[value.length];
        int[] a = value.clone();
        return count(a,aux,0,a.length-1);
    }

    public static long count(int[] a, int[] aux, int lo, int hi){
        long inversion = 0;
        if (lo >= hi) return 0;
        int mid = lo + (hi-lo)/2;
        inversion += count(a,aux,lo,mid);
        inversion += count(a,aux,mid+1,hi);
        inversion += merge(a,aux,lo,mid,hi);
        return inversion;
    }

    private static boolean less(int a, int b){
        return a-b<0;
    }

    public static void main(String[] args) {
        int[] value = new int[5];
        value[0] = 4;
        value[1] = 2;
        value[2] = 1;
        value[3] = 0;
        value[4] = 3;
        System.out.println(count(value));
    }
}
