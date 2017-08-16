package test5_1;

import java.util.Arrays;

/**
 * Created by albert on 2017/7/18.
 */
public class Quick3string {
    private static int chatAt(String a, int d){
        if (d < a.length()) return a.charAt(d);
        else return -1;
    }

    //练习5.1.14数组排序
    public static void sort(int[] num){
        String[] a = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            a[i] = String.valueOf(num[i]);
            int n = a[i].length();
            String nums = "";
            for (int j = 0; j < 10-n; j++) {
                nums += "0";
            }
            a[i] = nums + a[i];
        }
        sort(a);
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(a[i]);
        }
    }

    public static void sort(String[] a){
        sort(a,0,a.length-1,0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (lo >= hi) return;
        int lt = lo, gt = hi, i = lo+1;
        int v = chatAt(a[lo],d);
        while (i<=gt){
            int t = chatAt(a[i],d);
            if (t > v) exchange(a,i,gt--);
            else if (t < v) exchange(a,i++,lt++);
            else i++;
        }
        sort(a,lo,lt-1,d);
        if (v >= 0) sort(a,lt,gt,d+1);
        sort(a,gt+1,hi,d);
    }

    private static void exchange(String[] a, int i, int j) {
        String aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

    public static void main(String[] args) {
        int[] num = {23,43,6435,234,523,16534,45654,415,14};
        sort(num);
        System.out.println(Arrays.toString(num));
    }
}
