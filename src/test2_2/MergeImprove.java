package test2_2;

import edu.princeton.cs.algs4.In;
import test2_1.Example;

import java.util.Scanner;

/**
 * Created by albert on 2017/5/11.
 */
public class MergeImprove {
    private static final int min = 15;

    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b)<0;
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        int i = lo;
        int j = mid+1;
//        for (int k = lo; k <= hi; k++) {
//            aux[k] = a[k];
//        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[i],aux[j]))
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
        }
    }

    private static void shell(Comparable[] a, int lo, int hi){
        int N = hi-lo+1;
        int h = 1;
        while (h < N/3){
            h = h*3+1;
        }
        while (h>=1){
            for (int i = h; i < N; i++) {
                for (int j = i; j >=h && less(a[lo+j],a[lo+j-h]); j-=h) {
                    Example.exch(a,lo+j,lo+j-h);
                }
            }
            h = h/3;
        }
    }

    public static void sort(Comparable[] a){
        Comparable[] aux = a.clone();
        sort(a,aux,0,a.length-1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi-lo<min) {
            shell(a,lo,hi);
            return;
        }
        int mid = lo + (hi - lo)/2;
        sort(aux,a,lo,mid);
        sort(aux,a,mid+1,hi);
        if (less(aux[mid+1],aux[mid]))
            merge(a,aux,lo,mid,hi);
    }

    public static void main(String[] args) {
       String[] a;
        Scanner in = new Scanner(System.in);
        String b = in.nextLine();
        in.close();
        a=b.split("");
       sort(a);
       System.out.println(Example.isSorted(a));
       Example.show(a);
    }
}
