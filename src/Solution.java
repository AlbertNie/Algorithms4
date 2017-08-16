/**
 * Created by albert on 2017/6/9.
 */
public class Solution {
    public boolean Find(int target, int[][] array){
        int i,j;
        i = binarySearch(target,0,array.length-1,array);
        for (int k = 0; k <= i; k++) {
            j = binarySearch(target,0,array[k].length-1,array[k]);
            System.out.println(j);
            if (array[k][j] == target)
                return true;
        }
        return false;
    }

    private int binarySearch(int target, int lo, int hi, int[][] array){
        if(lo>=hi) return hi;
        int mid = lo + (hi-lo)/2;
        if(array[mid][0]>=target)
            return binarySearch(target,lo,mid,array);
        else
            return binarySearch(target,mid+1,hi,array);
    }

    private int binarySearch(int target, int lo, int hi, int[] array){
        if(lo>=hi) return hi;
        int mid = lo + (hi-lo)/2;
        if(array[mid]>=target)
            return binarySearch(target,lo,mid,array);
        else
            return binarySearch(target,mid+1,hi,array);
    }

    public static void main(String[] args) {
        int[][] array = new int[1][1];
//        array[0][0] = 0;
//        array[0][1] = 1;
//        array[1][0] = 2;
//        array[1][1] = 3;
        Solution solution = new Solution();
//        System.out.println(array[0][0]);
        System.out.println(solution.Find(0,array));
        System.out.println(1+"a"+1+2);
    }
}
