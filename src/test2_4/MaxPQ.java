package test2_4;

import java.util.Arrays;

/**
 * Created by albert on 2017/6/6.
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN+1];
    }

    public MaxPQ(){
        this(1);
    }

    public MaxPQ(Key[] value){
        this.N = value.length;
        pq = (Key[]) new Comparable[N+1];
        for (int i = 0; i < N; i++) {
            pq[i+1] = value[i];
        }
        for (int i = N/2; i >=1 ; i--) {
            sink(i);
        }
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void insert(Key v){
        if (N == pq.length-1)
            resize(2*N+1);
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        if (N > 0 && N == pq.length/4)
            resize(pq.length/2);
        Key max = pq[1];
        exch(1,N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    private void resize(int size){
        Key[] backups = (Key[]) new Comparable[size];
        for (int i = 0; i <= N; i++) {
            backups[i] = pq[i];
        }
        pq = backups;
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j])<0;
    }

    private void exch(int i, int j){
        Key value = pq[i];
        pq[i] = pq[j];
        pq[j] = value;
    }

    private void swim(int k){
        while (k>1 && less(k/2,k)){
            exch(k/2,k);
            k /= 2;
        }
    }

    private void sink(int k){
        while (2*k <=N){
            int j = 2*k;
            if (j<N && less(j,j+1))
                j++;
            if (!less(k,j))
                break;
            exch(k,j);
            k = j;
        }
    }

    @Override
    public String toString() {
        return "pq=" + Arrays.toString(pq);
    }

    public static void main(String[] args) {
        MaxPQ<String> test = new MaxPQ<>(12);
        test.insert("s");
        test.insert("e");
        test.insert("h");
        test.insert("d");
        test.insert("h");
        test.insert("w");
        test.insert("j");
        test.insert("g");
        test.insert("h");
        test.insert("k");
        System.out.println(test.toString());
        test.insert("y");
        test.delMax();
        System.out.println(test.toString());
        test.insert("y");
        test.insert("z");
        test.delMax();
        test.delMax();
        System.out.println(test.toString());

    }
}










