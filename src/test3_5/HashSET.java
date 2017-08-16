package test3_5;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by albert on 2017/6/23.
 */
public class HashSET<Key> {
    private int N;
    private int M;
    private Key[] keys;

    public HashSET(){
        this(16);
    }

    public HashSET(int M){
        this.M = M;
        keys = (Key[]) new Object[M];
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
        HashSET<Key> t;
        t = new HashSET<Key>(cop);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null)
                t.put(keys[i]);
        }
        keys = t.keys;
        M = t.M;
    }

    public void put(Key key){
        if (N >= M/2) resize(2*M);
        int i;
        for(i = hash(key); keys[i]!=null; i=(i+1)%M){
            if (keys[i].equals(key)){
                return;
            }
        }
        keys[i] = key;
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
        i = (i+1) % M;
        while (keys[i]!=null){
            Key keyRep = keys[i];
            keys[i] = null;
            N--;
            put(keyRep);
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
}
