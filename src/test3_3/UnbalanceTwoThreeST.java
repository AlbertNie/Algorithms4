package test3_3;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by albert on 2017/6/19.
 */
public class UnbalanceTwoThreeST<Key extends Comparable<Key>,Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node{
        Key key;
        Value value;
        Node left,right;
        int N;
        boolean color;

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            N = n;
            this.color = color;
        }
    }

    private boolean isRed(Node x){
        if (x == null) return false;
        return x.color == RED;
    }

    public int size(){
        return size(root);
    }
    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    public Key min(){
        return min(root).key;
    }
    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void put(Key key, Value value){
        root = put(root,key,value);
        root.color = BLACK;
    }
    private Node put(Node x, Key key, Value value){
        if (x == null) return new Node(key,value,1,RED);

        int cmp = key.compareTo(x.key);
        if (cmp > 0) x.right = put(x.right,key,value);
        else if (cmp < 0) x.left = put(x.left,key,value);
        else x.value = value;

        if (isRed(x.left) && isRed(x.right)){
            if (x.left.key.compareTo(key) == 0)
                x.left.color = BLACK;
            else
                x.right.color = BLACK;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Value get(Key key){
        return get(root, key);
    }
    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) return get(x.right,key);
        else if (cmp < 0) return get(x.left,key);
        else return x.value;
    }

    public void delete(Key key){
        root = delete(root,key);
    }
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) delete(x.right,key);
        else if (cmp < 0) delete(x.left,key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node h = x;
            x = min(x.right);
            x.right = deleteMin(h.right);
            x.left = h.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public boolean contains(Key key){
        return contains(root,key);
    }
    private boolean contains(Node x, Key key) {
        if (x == null) return false;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) return contains(x.right,key);
        else if (cmp < 0) return contains(x.left,key);
        else return true;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<Key>();
        keys(root,queue);
        return queue;
    }
    private void keys(Node x, Queue<Key> queue) {
        if (x == null) return;
        keys(x.left,queue);
        queue.enqueue(x.key);
        keys(x.right,queue);
    }

    public static void main(String[] args) {
        UnbalanceTwoThreeST<Integer,String> ub = new UnbalanceTwoThreeST<>();
        ub.put(1,"a");
        ub.put(6,"b");
        ub.put(12,"c");
        ub.put(4,"d");
        ub.put(7,"e");
        ub.put(73,"da");

        for (int a:ub.keys()) {
            System.out.println(a);
        }
    }
}















