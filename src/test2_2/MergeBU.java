package test2_2;

/**
 * Created by albert on 2017/5/9.
 */
public class MergeBU {
    private static int count=0;
   private static boolean less(Comparable a, Comparable b){
       return a.compareTo(b)<0;
   }

   private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
       int i = lo;
       int j = mid+1;
       for (int k = 0; k <= hi; k++) {
           aux[k] = a[k];
       }

       count += a.length;

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
       int N = a.length;
       Comparable[] aux = new Comparable[N];

       for (int sz = 1; sz < N; sz = sz+sz) {
           for (int lo = 0; lo < N-sz; lo += sz+sz) {
               merge(a,aux,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
           }
       }
   }

   public static int getCount(){
       int a=count;
       count=0;
       return a;
   }
}
