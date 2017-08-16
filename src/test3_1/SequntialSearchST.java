package test3_1;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by albert on 2017/6/13.
 */
public class SequntialSearchST<Key,Value> {
    private Node first;
    private int N = 0;
    private class Node{
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key){
        for(Node x = first; x!=null; x=x.next){
            if (key.equals(x.key))
                return x.value;
        }
        return null;
    }

    public void put(Key key, Value value){
        for(Node x = first; x!=null; x=x.next){
            if (key.equals(x.key)){
                x.value = value;
                return;
            }
        }
        first = new Node(key,value,first);
        N++;
    }

    public int size(){
        return N;
    }

    public void delete(Key key){
        if (key == null) throw new IllegalArgumentException("nullPoint Key");
        first = delete(first,key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)){
            N--;
            return x.next;
        }
        x.next = delete(x.next,key);
        return x;
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<Key>();
        Node x = first;
        while (x!=null){
            queue.enqueue(x.key);
        }
        return queue;
    }
}

















