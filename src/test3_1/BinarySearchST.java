package test3_1;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by albert on 2017/6/13.
 */
public class BinarySearchST<Key extends Comparable<Key>,Value> {
    private Key[] keys;
    private Value[] values;
    private int N;
    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size(){
        return N;
    }

    private void resize(int n){
        Key[] ckeys = (Key[]) new Comparable[n];
        Value[] cvalues = (Value[]) new Object[n];
        for (int i = 0; i < N; i++) {
            ckeys[i] = keys[i];
            cvalues[i] = values[i];
        }
        keys = ckeys;
        values = cvalues;
    }

    public Value get(Key key){
        if (isEmpty()) return null;
        int i = rank(key);
        if (i<N && keys[i].compareTo(key)==0)
            return values[i];
        else
            return null;
    }

    public int rank(Key key){
        int lo = 0, hi = N-1;
        while (lo<=hi){
            int mid = lo + (hi-lo)/2;
            int i = keys[mid].compareTo(key);
            if (i>0)
                hi = mid - 1;
            else if (i < 0)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }

    public void put(Key key, Value value){
        if (key == null) throw new IllegalArgumentException("the key your gives is null");
        if (value == null)
            delete(key);
        int i = rank(key);
        if (i<N && keys[i].compareTo(key)==0){
            values[i] = value;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
        if (N == keys.length)
            resize(2*keys.length);
    }

    public boolean isEmpty(){
        return 0 == N;
    }

    public void delete(Key key){
        if (key == null) throw new IllegalArgumentException("the key your gives is null");
        if (isEmpty()) return;
        int i = rank(key);
        if (i == N || keys[i].compareTo(key)!=0)
            return;
        for (int j = i; j < N-1; j++) {
            keys[j] = keys[j+1];
            values[j] = values[j+1];
        }
        keys[N-1] = null;
        values[N-1] = null;
        N--;
        if (N >0 && N == keys.length/4)
            resize(keys.length/2);
    }

    public Key min(){
        return keys[0];
    }

    public Key max(){
        return keys[N-1];
    }

    public Key select(int k){
        return keys[k];
    }

    public Key ceiling(Key key){
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key){
        int i = rank(key);
        if (i == 0)
            return null;
        else if (i<N && keys[i].compareTo(key) == 0)
            return keys[i];
        else
            return keys[i-1];
    }

    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> queue = new Queue<Key>();
        for (int i = rank(lo); i < rank(hi); i++) {
            queue.enqueue(keys[i]);
        }
        if (contains(hi))
            queue.enqueue(keys[rank(hi)]);
        return queue;
    }

    private boolean contains(Key hi) {
        return hi == keys[rank(hi)];
    }


}























