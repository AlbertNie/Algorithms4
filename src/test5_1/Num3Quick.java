package test5_1;

import java.util.Arrays;

/**
 * Created by albert on 2017/7/18.
 */
public class Num3Quick {
    private static int charAt(int n, int d){
        String a = String.valueOf(n);
        if (d < a.length()) return a.charAt(d);
        else return -1;
    }
    public static void sort(int[] a){
        sort(a,0,a.length-1,0);
    }

    private static void sort(int[] a, int lo, int hi, int d) {
        if (lo >= hi) return;
        int lt = lo, gt = hi, i = lo+1;
        int v  = charAt(a[lo],d);
        while (i <= gt){
            int t = charAt(a[i],d);
            if (t > v) exchange(a,gt--,i);
            else if (t < v) exchange(a,i++,lt++);
            else i++;
         }
        sort(a,lo,lt-1,d);
        if (v >= 0) sort(a,lt,gt,d+1);
        sort(a,gt+1,hi,d);
    }

    private static void exchange(int[] a, int i, int j) {
        int n = a[i];
        a[i] = a[j];
        a[j] = n;
    }

    public static void main(String[] args) {
        int[] num = {23,43,6435,234,523,16534,45654,415,14};
        sort(num);
        System.out.println(Arrays.toString(num));
    }
}
