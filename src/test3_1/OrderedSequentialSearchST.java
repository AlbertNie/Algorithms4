package test3_1;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by albert on 2017/6/13.
 */
public class OrderedSequentialSearchST<Key extends Comparable<Key>,Value> {
    private int N = 0;
    private Node first = null;
    private class Node{
        Key key = null;
        Value value = null;
        Node next = null;
        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }
    }

    public OrderedSequentialSearchST(){}

    //插入键值对
    public void put(Key key, Value value){
        Node node = new Node(key,value);
        Node o = null;
        if (first == null){
            first = node;
            N++;
            return;
        }
        for(o=first; o.next!=null; o = o.next){
            if (o.key.compareTo(node.key)<=0 && o.next.key.compareTo(node.key)>0){
                node.next = o.next;
                o.next = node;
                N++;
                return;
            }
        }
        o.next = node;
        N++;
    }

    //获取key对应的值，若key不存在则返回空
    public Value get(Key key){
        for(Node o=first; o!=null; o=o.next){
            if (o.key.equals(key))
                return o.value;
        }
        return null;
    }

    //从表中删去键key及其对应的值
    public void delete(Key key){
        if (N == 0) return;
        if (first.key.equals(key)){
            first = first.next;
            N--;
        }
        for(Node o=first; o.next!=null; o=o.next){
            if (o.next.key.equals(key)){
                o.next = o.next.next;
                N--;
            }
        }
    }

    //键key是否存在于表中
    public boolean contains(Key key){
        for(Node o=first; o!=null; o=o.next){
            if (o.key.equals(key)){
                return true;
            }
        }
        return false;
    }

    //表是否为空
    public boolean isEmpty(){
        return 0 == N;
    }

    //表中的键值对数量
    public int size(){
        return N;
    }

    //最小的键
    public Key min(){
        return first.key;
    }

    //最大的键
    public Key max(){
        Node o = first;
        while (o.next!=null){
            o=o.next;
        }
        return o.key;
    }

    //小于等于key的最大键
    public Key floor(Key key){
        if (first.key.compareTo(key)>0){
            return null;
        }
        Node o =null;
        for(o=first; o.next!=null; o=o.next){
            if (o.key.compareTo(key)<=0 && o.next.key.compareTo(key)>0)
                return o.key;
        }
        return o.key;
    }

    //大于等于key的最小键
    public Key ceiling(Key key){
        Node o = null;
        for(o=first; o.next!=null; o=o.next){
            if (o.key.compareTo(key)>=0)
                return o.key;
        }
        return o.key;
    }

    //小于key的键的数量
    public int rank(Key key){
        int n = 0;
        Node o = first;
        while (o!=null && o.key.compareTo(key)<0){
            n++;
        }
        return n;
    }

    //排名为k的键
    public Key select(int k){
        if (k > N) return null;
        Node o = first;
        while (k>0){
            o = o.next;
            k--;
        }
        return o.key;
    }

    //删除最小的键
    public void deleteMin(){
        first = first.next;
        N--;
    }

    //删除最大的键
    public void deleteMax(){
        Node o = first;
        for (int i = 0; i < N-1; i++) {
            o = o.next;
        }
        o.next = null;
        N--;
    }

    //[lo...hi】之间的键的数量
    public int size(Key lo, Key hi){
        int n = 0;
        Node o = first;
        while (o!=null && o.key.compareTo(hi)<=0){
            if (o.key.compareTo(lo)>=0)
                n++;
        }
        return n;
    }

    //[lo...hi】之间的所有键，已排序
    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> queue = new Queue<Key>();
        Node o = first;
        while (o!=null && o.key.compareTo(hi)<=0){
            if (o.key.compareTo(lo)>=0)
                queue.enqueue(o.key);
        }
        return queue;
    }

    //表中所有键的集合，已排序
    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<Key>();
        Node o = first;
        while (o!=null){
            queue.enqueue(o.key);
        }
        return queue;
    }
}
