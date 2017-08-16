package test2_2;

/**
 * Created by albert on 2017/8/4.
 */
public class MergeWithoutCopy {
    public static void sort(int[] array){
        int[] aux = array.clone();
        sort(aux,array,0,array.length-1);
    }

    private static void sort(int[] aux, int[] array, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi-lo)/2;
        sort(array,aux,lo,mid);
        sort(array,aux,mid+1,hi);
        merge(aux,array,lo,mid,hi);
    }

    private static void merge(int[] aux, int[] array, int lo, int mid, int hi) {
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) array[k] = aux[j++];
            else if (j > hi) array[k] = aux[i++];
            else if (aux[i] < aux[j]) array[k] = aux[i++];
            else array[k] = aux[j++];
        }
    }

    public static void main(String[] args) {
        int[] array = {2,5,12,12,5,23,52,2,4,3,6,1,6,134,1,134,14,51,243};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
