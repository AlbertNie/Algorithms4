package test3_5;

import edu.princeton.cs.algs4.Queue;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by albert on 2017/6/21.
 * 练习3.5.8
 * 允许存在重复的键，对于get方法返回任意值，对于delete方法删除所有和给定键相等的键值对
 * 感觉允许重复的键的话把value设置成队列数组更好，重复的键的值直接加到队列里面，但是不知道题的意思是不是这样
 * 我用的方法还是直接把键值对插在后面。删除的时候把后面的全部重新插入
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
        ArrayList<Value> arrayList = new ArrayList<Value>();
        for(i = hash(key); keys[i]!=null;i = (i+1)%M){
            if (keys[i].equals(key))
                arrayList.add(values[i]);
        }
        Random random = new Random();
        if (arrayList.size()==0)
            return null;
        else return arrayList.get(random.nextInt(arrayList.size()));
    }

    public void put(Key key, Value value){
        if (N >= M/2) resize(2*M);
        int i=hash(key);
//        for(i = hash(key); keys[i]!=null; i=(i+1)%M){
//            if (keys[i].equals(key)){
//                values[i] = value;
//                return;
//            }
//        }
        while (keys[i]!=null){
            i++;
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
        int j = 0;
        boolean flage = true;
//        while (!keys[i].equals(key))
//            i = (i+1)&M;
//        keys[i] = null;
//        values[i] = null;
//        i = (i+1) % M;
        while (keys[i]!=null){
            while (keys[i]!=null && !keys[i].equals(key))
                i = (i+1)%M;
            keys[i] = null;
            values[i] = null;
            i = (i+1) % M;
            if (flage){
                j = i;
                flage = false;
            }
        }
        while (j<=i || keys[j]!=null){
            if (keys[j]!=null) {
                Key keyRep = keys[j];
                Value valueRep = values[j];
                keys[j] = null;
                values[j] = null;
                N--;
                put(keyRep, valueRep);
                j = (j + 1) % M;
            }else j = (j+1)%M;
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

    public static void main(String[] args) {
        LinearProbingHashST<Integer,String> linearProbingHashST = new LinearProbingHashST<>();
        linearProbingHashST.put(1,"ads");
        linearProbingHashST.put(1,"df");
        linearProbingHashST.put(1,"df");
        linearProbingHashST.put(1,"asfa");
        linearProbingHashST.put(2,"asfa");
        linearProbingHashST.put(1,"grg");
        linearProbingHashST.put(1,"wehrh");
        linearProbingHashST.put(3,"wehrh");
        linearProbingHashST.put(0,"wehrh");
        linearProbingHashST.put(5,"wehrh");
        linearProbingHashST.put(1,"wertqweh");
        linearProbingHashST.put(1,"wewrgerwgertweqrt");
        linearProbingHashST.delete(2);
        linearProbingHashST.delete(0);
        linearProbingHashST.delete(3);
        linearProbingHashST.delete(5);
        System.out.println(linearProbingHashST.get(1));
    }
}
















