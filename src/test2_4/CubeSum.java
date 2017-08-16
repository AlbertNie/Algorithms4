package test2_4;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

import java.util.ArrayList;

/**
 * Created by albert on 2017/6/6.
 */
public class CubeSum implements Comparable<CubeSum> {
    public long sum;
    public long i,j;
    @Override
    public int compareTo(CubeSum o) {
        if (this.sum>o.sum) return 1;
        else if (this.sum<o.sum) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "(" +sum +" , " + i +" ," + j +')';
    }

    public CubeSum(long i, long j){
       sum = i*i*i+j*j*j;
       this.i = i;
       this.j = j;
    }

    public static void main(String[] args) {
        int N = 10000;
        MinPQ<CubeSum> minPQ = new MinPQ<>();
        Stack<CubeSum> same = new Stack<>();
        for (int i = 0; i < N; i++) {
            minPQ.insert(new CubeSum(i,0));
        }

        while (!minPQ.isEmpty()){
            CubeSum a = minPQ.delMin();
            if (a.j<N)
                minPQ.insert(new CubeSum(a.i,a.j+1));
            same.push(a);
            if (a.compareTo(same.peek())!=0){
                int n = same.size();
                CubeSum[] duibi = new CubeSum[n];
                if (n<2){
                    for (int i = 0; i < n; i++) {
                        same.pop();
                    }
                }
                else {
                    for (int i = 0; i < n; i++) {
                        System.out.println(same.pop());
                    }
                }
                minPQ.insert(a);
            }
        }
    }
}
















