package test2_3;

import edu.princeton.cs.algs4.StdRandom;
import test2_1.Example;

/**
 * Created by albert on 2017/5/24.
 */
public class test2_3_6 {
    private static long count=0;
    private static boolean less(Comparable a, Comparable b){
        count++;
        return a.compareTo(b)<0;
    }
    private static long getCount(){
        long i = count;
        count = 0;
        return i;
    }

    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi+1;
        Comparable v = a[lo];
        while (true){
            while (less(a[++i],v))
                if (i == hi)
                    break;
            while (less(v,a[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;
            Example.exch(a,i,j);
        }
        Example.exch(a,lo,j);
        return j;
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if (lo>=hi)
            return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    public static void main(String[] args) {
        int N = 10;
        Double[] test;
        long count;
        for (int i = 0; i < 4; i++) {
            long sum = 0;
            N *= 10;
            test = new Double[N];
            for (int j = 0; j < N; j++) {
                test[j] = 3.0;
            }
            sort(test);
            count = getCount();
            for (int j = 1; j <= N; j++) {
                sum += j;
            }
            System.out.println("while N = "+N+"比较次数是："+count+"理论计算为："+1.3*N*Math.log(N));
        }
    }
}
