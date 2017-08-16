package test2_5;

/**
 * Created by albert on 2017/6/7.
 * 查找第k小的元素，k从0开始算
 */
public class test2_5_6 {
    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b)<0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable value = a[i];
        a[i] = a[j];
        a[j] = value;
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
            if (i>=j)
                break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }

    public static Comparable select(Comparable[] a,int k){
        int hi = a.length-1;
        Comparable[] b = a.clone();
        select(b,0,hi,k);
        return b[k];
    }

    private static void select(Comparable[] a, int lo, int hi, int k){
        int j = partition(a,lo,hi);
        if (j == k)
            return;
        else if (j > k)
            select(a,lo,j-1,k);
        else
            select(a,j+1,hi,k);
    }

    public static void main(String[] args) {
        Integer[] a = {14,2,3,4,5,6,7,8,9,10};
        System.out.println(select(a,0));
    }
}















