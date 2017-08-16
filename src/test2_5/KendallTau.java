package test2_5;

import test2_2.Inversion;

/**
 * Created by albert on 2017/6/8.
 */
public class KendallTau {
    public static long kendallTau(int[] a, int[] b){
        if (a.length != b.length)
            throw new IllegalArgumentException("Not equal");
        int[] aIndexInNomal = new int[a.length];
        int[] bIndexIna = new int[b.length];
        for (int i = 0; i < a.length; i++) {
            aIndexInNomal[a[i]] = i;
        }

        for (int i = 0; i < a.length; i++) {
            bIndexIna[i] = aIndexInNomal[b[i]];
        }

        return Inversion.count(bIndexIna);
    }

    public static void main(String[] args) {
        int[] a = {3,6,4,7,5,1,2,9,0,8};
        int[] b = {5,9,3,1,6,2,4,8,7,0};
        System.out.println(kendallTau(a,b));
    }
}
