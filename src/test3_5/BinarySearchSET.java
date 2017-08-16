package test3_5;

import java.util.Random;

/**
 * Created by albert on 2017/6/22.
 */
public class BinarySearchSET<Key extends Comparable<Key>> {
    private Key[] keys;
    private int N;

    public BinarySearchSET() {
        this(10);
    }

    public BinarySearchSET(int M) {
        keys = (Key[]) new Comparable[M];
    }

    private void resize(int n){
        Key[] keyscopy = (Key[]) new Comparable[n];
        for (int i = 0; i < N; i++) {
            keyscopy[i] = keys[i];
        }
        keys = keyscopy;
    }

    private int rank(Key key){
        int lo = 0;
        int hi = N;
        int mid,cmp;
        while (hi > lo){
            mid = lo + (hi-lo)/2;
            cmp = key.compareTo(keys[mid]);
            if (cmp > 0) lo = mid+1;
            else if (cmp < 0) hi = mid -1;
            else return mid;
        }
        return hi;
    }

    public void add(Key key){
        if (key == null) throw new IllegalArgumentException("null key");
        int n = rank(key);
        if (n<N && key.compareTo(keys[n]) == 0) return;
        for (int i = N; i > n; i--) {
            keys[i] = keys[i-1];
        }
        keys[n] = key;
        N++;
        if (N == keys.length) resize(keys.length*2);
    }

    public void delete(Key key){
        if (key == null) throw new IllegalArgumentException("null key");
        int n = rank(key);
        if (n<N && keys[n].compareTo(key)!=0) return;
        for (int i = n; i < N-1; i++) {
            keys[i] = keys[i+1];
        }
        N--;
        keys[N] = null;
        if (N>0 && N==keys.length/4) resize(keys.length/2);
    }

    public boolean contains(Key key){
        if (key == null) throw new IllegalArgumentException("null Key");
        int n = rank(key);
        return key.compareTo(keys[n]) == 0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public static void main(String[] args) {
        BinarySearchSET<Integer> binarySearchSET = new BinarySearchSET<>();
        for (int i = 0; i < 1000000; i++) {
            binarySearchSET.add(i);
        }
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            binarySearchSET.delete(random.nextInt(1000000));
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(binarySearchSET.contains(random.nextInt(1000000)));
        }

    }
}














