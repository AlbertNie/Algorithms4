package test3_1;


import edu.princeton.cs.algs4.Queue;

/**
 * Created by albert on 2017/6/13.
 * test3_1_2 使用无序数组实现基本API
 */
public class ArrayST<Key,Value> {
    private int N = 0;
    private Key[] keys = null;
    private Value[] values = null;

    public ArrayST(){
        keys = (Key[]) new Object[1];
        values = (Value[]) new Object[1];
    }

    //插入元素实现
    public void put(Key key, Value value){
        if (value == null){
            delete(key);
            return;
        }
        if (N >= keys.length){
            augment(2*keys.length);
        }
        keys[N] = key;
        values[N] = value;
        N++;
    }

    //获取键对应的值//使用自组织查找
    public Value get(Key key){
        int i = getId(key);
        if (i == -1){
            return null;
        }else {
            Value value = values[i];
            for (int j = i; j > 0; j--) {
                keys[j] = keys[j-1];
                values[j] = values[j-1];
            }
            keys[0] = key;
            values[0] = value;
            return values[0];
        }
    }

    //从表中删除键Key及其对应的值
    public void delete(Key key){
        for (int j = 0; j < keys.length; j++) {
            if (keys[j].equals(key)){
                keys[j] = keys[N-1];
                values[j] = values[N-1];
                keys[N-1] = null;
                values[N-1] = null;
                N--;
                if (N>0 && N == keys.length/4){
                    augment(N/2);
                }
                return;
            }
        }
    }

    //键key在表中是否有对应的值
    public boolean contains(Key key){
        if (-1 == getId(key))
            return false;
        else
            return true;
    }

    //表是否为空
    public boolean isEmpty(){
        return 0 == N;
    }

    //表中的键值对的数量
    public int size(){
        return N;
    }

    //表中所有键的集合
    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(keys[i]);
        }
        return queue;
    }

    //数组的动态扩充
    private void augment(int n){
        if (N > n) throw new IllegalArgumentException("will miss data");
        Key[] ckeys = (Key[]) new Object[n];
        Value[] cvalue = (Value[]) new Object[n];
        for (int i = 0; i < keys.length; i++) {
            ckeys[i] = keys[i];
            cvalue[i] = values[i];
        }
        keys = ckeys;
        values = cvalue;
    }

   //获取键对应的数组位置
    private int getId(Key key){
        int i = -1;
        for (int j = 0; j < N; j++) {
            if (keys[j].equals(key)){
                i = j;
                break;
            }
        }
        return i;
    }
}
























