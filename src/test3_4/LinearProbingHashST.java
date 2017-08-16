package test3_4;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by albert on 2017/6/21.
 */
public class LinearProbingHashST<Key,Value> {
    private int N;
    private int M;
    private int Null;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST(){
        this(16);
    }

    public LinearProbingHashST(int M){
        this.M = M;
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff)%M;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    private void resize(int cop){
        LinearProbingHashST<Key,Value> t;
        t = new LinearProbingHashST<Key, Value>(cop);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null)
                t.put(keys[i],values[i]);
        }
        keys = t.keys;
        values = t.values;
        M = t.M;
    }

    public Value get(Key key){
        int i;
        for(i = hash(key); keys[i]!=null;i = (i+1)%M){
            if (keys[i].equals(key))
                return values[i];
        }
        return null;
    }

    public void put(Key key, Value value){
        if (N >= M/2) resize(2*M);
        int i;
        for(i = hash(key); keys[i]!=null; i=(i+1)%M){
            if (keys[i].equals(key)){
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public boolean cotains(Key key){
        for (int i = hash(key); keys[i]!=null; i = (i+1)%M) {
            if (keys[i].equals(key))
                return true;
        }
        return false;
    }

    public void delete(Key key){
        if (!cotains(key)) return;
        int i = hash(key);
        while (!keys[i].equals(key))
            i = (i+1)&M;
        keys[i] = null;
        values[i] = null;
        i = (i+1) % M;
        while (keys[i]!=null){
            Key keyRep = keys[i];
            Value valueRep = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(keyRep,valueRep);
            i = (i+1)%M;
        }
        N--;
        if (N > 0 && N == M/8) resize(M/2);
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++) {
            if (keys[i] != null)
                queue.enqueue(keys[i]);
        }
        return queue;
    }

    /***
     * 练习3。4。26 线性探测中的延时删除
     * 采用resize时才真正删除
     * 在增加的时候put的时候，判断resize的条件变为
     * if(N+Null>M/2)
     */
    public void deletes(Key key){
        for (int i = hash(key); keys[i]!=null; i = (i+1)/M){
            if (key.equals(keys[i])){
                values[i] = null;
                Null++;
                N--;
                return;
            }
        }
        if (N > 0 && N+Null == M/8)
            resizes(M/2);
    }

    private void resizes(int cop){
        LinearProbingHashST<Key,Value> t = new LinearProbingHashST<Key, Value>(cop);
        for (int i = 0; i < M; i++) {
            if (keys[i]!=null && values[i]!=null)
                t.put(keys[i],values[i]);
        }
        this.keys = t.keys;
        this.values = t.values;
        this.M = t.M;
    }
}
















