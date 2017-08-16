package test3_5;

/**
 * Created by albert on 2017/6/22.
 */
public class SequentialSearchSET<Key> {
    private Node first;
    private int N;
    class Node{
        Key key;
        Node next;

        public Node(Key key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    public SequentialSearchSET() {
    }

    public void add(Key key){
        for (Node x = first; x!=null; x = x.next){
            if (x.key.equals(key))
                return;
        }
        first = new Node(key,first);
        N++;
    }

    public void delete(Key key){
        if (key == null) throw new IllegalArgumentException("null key");
        first = delete(first,key);
    }
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (x.key.equals(key)){
            N--;
            return x.next;
        }
        x.next = delete(x.next,key);
        return x;
    }

    public boolean contains(Key key){
        for (Node x = first; x!=null; x= x.next){
            if (key.equals(x.key))
                return true;
        }
        return false;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }
}
