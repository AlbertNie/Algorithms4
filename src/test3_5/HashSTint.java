package test3_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**
 * Created by albert on 2017/6/22.
 */
public class HashSTint<Value> {
    private int N;
    private int M;
    private int[] keys;
    private Value[] values;

    public HashSTint(){
        this(16);
    }

    public HashSTint(int M){
        this.M = M;
        keys = new int[M];
        for (int i = 0; i < M; i++) {
            keys[i] = Integer.MAX_VALUE;
        }
        values = (Value[]) new Object[M];
    }

    private int hash(int key){
        return (key & 0x7fffffff)%M;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    private void resize(int cop){
        HashSTint<Value> t;
        t = new HashSTint<Value>(cop);
        for (int i = 0; i < M; i++) {
            if (keys[i] != Integer.MAX_VALUE)
                t.put(keys[i],values[i]);
        }
        keys = t.keys;
        values = t.values;
        M = t.M;
    }

    public Value get(int key){
        int i;
        for(i = hash(key); keys[i]!=Integer.MAX_VALUE;i = (i+1)%M){
            if (keys[i]==key)
                return values[i];
        }
        return null;
    }

    public void put(int key, Value value){
        if (N >= M/2) resize(2*M);
        int i;
        for(i = hash(key); keys[i]!=Integer.MAX_VALUE; i=(i+1)%M){
            if (keys[i]==key){
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public boolean cotains(int key){
        for (int i = hash(key); keys[i]!=Integer.MAX_VALUE; i = (i+1)%M) {
            if (keys[i]==key)
                return true;
        }
        return false;
    }

    public void delete(int key){
        if (!cotains(key)) return;
        int i = hash(key);
        while (keys[i]!=key)
            i = (i+1)&M;
        keys[i] = Integer.MAX_VALUE;
        values[i] = null;
        i = (i+1) % M;
        while (keys[i]!=Integer.MAX_VALUE){
            int keyRep = keys[i];
            Value valueRep = values[i];
            keys[i] = Integer.MAX_VALUE;
            values[i] = null;
            N--;
            put(keyRep,valueRep);
            i = (i+1)%M;
        }
        N--;
        if (N > 0 && N == M/8) resize(M/2);
    }

    public Iterable<Integer> keys(){
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < M; i++) {
            if (keys[i] != Integer.MAX_VALUE)
                queue.enqueue(keys[i]);
        }
        return queue;
    }

    public static void main(String[] args) {
        HashSTint<String> hashSTint = new HashSTint<>();
        hashSTint.put(1,"a");
        hashSTint.put(2,"b");
        hashSTint.put(3,"c");
        hashSTint.put(4,"d");
        hashSTint.delete(3);
        for (int i:hashSTint.keys()) {
            System.out.println(hashSTint.get(i));
        }
    }
}
