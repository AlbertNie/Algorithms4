package test3_3;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by albert on 2017/6/19.
 */
public class RedBlackBST<Key extends Comparable<Key>,Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node{
        private Key key;
        private Value value;
        private Node left,right;
        private int N;
        private boolean color;

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            N = n;
            this.color = color;
        }
    }

    public int size(){
        return size(root);
    }
    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    private boolean isRed(Node h){
        if (h == null) return false;
        return h.color == RED;
    }

    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private void flipColors(Node h){
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
        h.color = !h.color;
    }

    public void put(Key key, Value value){
        root = put(root,key,value);
        root.color = BLACK;
    }
    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key,value,1,RED);
        int cmp = key.compareTo(x.key);
        if (cmp > 0) x.right = put(x.right,key,value);
        else if (cmp < 0) x.left = put(x.left,key,value);
        else x.value = value;

        if (!isRed(x.left) && isRed(x.right)) x = rotateLeft(x);
        if (isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
        if (isRed(x.left) && isRed(x.right)) flipColors(x);

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

    public Key min(){
        return min(root).key;
    }
    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }
    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    public boolean isEmpty(){
        return root == null;
    }

    public Key floor(Key key){
        Node x = floor(root,key);
        if (x == null) return null;
        return x.key;
    }
    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left,key);
        Node h = floor(x.right,key);
        if (h != null) return h;
        else return x;
    }

    public Key ceiling(Key key){
        Node x = ceiling(root,key);
        if (x == null) return null;
        else return x.key;
    }
    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0) return ceiling(x.right,key);
        Node h = ceiling(x.left,key);
        if (h != null) return h;
        else return x;
    }

    public int rank(Key key){
        return rank(root,key);
    }
    private int rank(Node x, Key key) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) return 1 + size(x.left) + rank(x.right,key);
        else if (cmp < 0) return rank(x.left,key);
        else return size(x.left);
    }

    public Key select(int k){
        return select(root,k).key;
    }
    private Node select(Node x, int k) {
        if (x == null) return null;
        int cmp = size(x.left);
        if (cmp == k) return x;
        else if (cmp > k) return select(x.left,k);
        else return select(x.right,k-cmp-1);
    }

    private void flipColor(Node h){
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    private Node moveRedLeft(Node h){
        flipColors(h);
        if (isRed(h.right.left)){
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }
    public void deleteMin(){
        if (!isRed(root.left) && !isRed(root.right)){
            root.color = RED;
        }
        root = deleteMin(root);
        if (!isEmpty())root.color = BLACK;
    }
    private Node deleteMin(Node x) {
        if (x.left == null) return null;
        if (!isRed(x.left) && !isRed(x.left.left))
            x = moveRedLeft(x);
        x.left = deleteMin(x.left);
        return balance(x);
    }
    private Node balance(Node x) {
        if (isRed(x.right)) x = rotateLeft(x);
        if (isRed(x.right) && !isRed(x.left)) x = rotateLeft(x);
        if (isRed(x.left) && isRed(x.left)) x = rotateRight(x);
        if (isRed(x.left) && isRed(x.right)) flipColors(x);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


    private Node moveRedRight(Node h){
        flipColors(h);
        if (!isRed(h.left.left)) {
            h = rotateRight(h);
            //flipColors(h);
        }
        return h;
    }

    public void deleteMax(){
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node deleteMax(Node h) {
        if (isRed(h.left))
            h = rotateRight(h);
        if (h.right == null) return null;
        if (!isRed(h.right) && !isRed(h.right.left))
            h = moveRedRight(h);
        h.right = deleteMax(h.right);
        return balance(h);
    }

    public void delete(Key key){
        if (!isRed(root.left) && !isRed(root.right)){
            root.color = RED;
        }
        root = delete(root,key);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node delete(Node h, Key key) {
        if (key.compareTo(h.key) < 0){
            if (!isRed(h.left) && !isRed(h.left.left))
                h = rotateLeft(h);
            h.left = delete(h.left,key);
        }else {
            if (isRed(h.left))
                h = moveRedRight(h);
            if (key.compareTo(h.key) == 0 && null==h.right)
                return null;
            if (!isRed(h.right) && !isRed(h.right.left))
                h = moveRedRight(h);
            if (key.compareTo(h.key) == 0){
                h.value = get(h.right,min(h.right).key);
                h.key = min(h.right).key;
                h = deleteMin(h.right);
            }
            else h.right = delete(h.right,key);
        }
        return balance(h);
    }

    public Value get(Key key){
        return get(root,key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x.value;
        else if (cmp > 0) return get(x.right,key);
        else return get(x.left,key);
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
        RedBlackBST<Integer,String> rb = new RedBlackBST<>();
        rb.put(1,"a");
        rb.put(2,"b");
        rb.put(4,"d");
        rb.put(5,"e");
//        System.out.println(rb.floor(3));
//        System.out.println(rb.ceiling(3));
//        System.out.println(rb.contains(2));
//        System.out.println(rb.rank(2));
        rb.deleteMin();
        rb.deleteMax();
        System.out.println(rb.select(0));
        System.out.println(rb.select(1));
        //System.out.println(rb.select(2));

    }
}













