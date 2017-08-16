package test2_3;

import test2_1.Example;

import java.util.Scanner;

/**
 * Created by albert on 2017/5/24.
 */
public class test2_3_5 {
    private static void sort(Comparable[] a, int lo, int hi){
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0)
                Example.exch(a, i++, lt++);
            else if (cmp > 0)
                Example.exch(a, i, gt--);
            else
                i++;
        }
    }

    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ex = in.nextLine();
        in.close();
        String[] a = ex.split("");
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
