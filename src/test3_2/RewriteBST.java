package test3_2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by albert on 2017/6/14.
 */
public class RewriteBST<Key extends Comparable<Key>,Value> {
    private Node root;

    private class Node{
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int N;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    public int size(){
        return size(root);
    }
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

//    public Value get(Key key){
//        return get(root,key);
//    }
//    private Value get(Node x, Key key) {
//        if (x == null) return null;
//        int cmp = key.compareTo(x.key);
//        if (cmp > 0) return get(x.right,key);
//        else if (cmp < 0) return get(x.left,key);
//        else return x.value;
//    }

    public Value get(Key key){
        Node x = root;
        int cmp = 0;
        while (x != null){
            cmp = key.compareTo(x.key);
            if (cmp > 0) x = x.right;
            else if (cmp < 0) x = x.left;
            else return x.value;
        }
        return null;
    }

//    public void put(Key key, Value value){
//        root = put(root,key,value);
//    }
//    private Node put(Node x, Key key, Value value) {
//        if (x == null) return new Node(key,value,1);
//        int cmp = key.compareTo(x.key);
//        if (cmp > 0) x.right = put(x.right,key,value);
//        else if (cmp < 0) x.left = put(x.left,key,value);
//        else x.value = value;
//        x.N = size(x.right) + size(x.left) + 1;
//        return x;
//    }

    public void put(Key key, Value value){
        Node x = root;
        Node y = null;
        boolean isbreak = false;
        int cmp = 0;
        while (x != null){
            y = x;
            cmp = key.compareTo(x.key);
            if (cmp > 0){
                x = x.right;
            }else if (cmp < 0){
                x = x.left;
            }else {
                x.value = value;
                isbreak = true;
                break;
            }
        }
        if (isbreak) return;
        if (cmp > 0) y.right = new Node(key,value,1);
        else if (cmp < 0) y.right = new Node(key,value,1);
        else root = new Node(key,value,1);
        addNByKeyWay(key);
    }
    private void addNByKeyWay(Key key){
        Node x = root;
        int cmp = key.compareTo(x.key);
        while (cmp != 0){
            x.N = x.N + 1;
            if (cmp > 0) x = x.right;
            else x = x.left;
            cmp = key.compareTo(x.key);
        }
    }



//    public Key max(){
//        return max(root).key;
//    }
//    private Node max(Node x) {
//        if (x.right == null)
//            return x;
//        return max(x.right);
//    }
    public Key max(){
        return this.max(root).key;
    }
    private Node max(Node x){
        Node y = null;
        while (x != null){
            y = x;
            x = x.right;
        }
        return y;
    }

//    public Key min(){
//        return min(root).key;
//    }
//    private Node min(Node x) {
//        if (x.left == null) return x;
//        return min(x.left);
//    }

    public Key min(){
        return this.min(root).key;
    }
    private Node min(Node x){
        Node y = null;
        while (x != null){
            y = x;
            x = x.left;
        }
        return y;
    }

//    public Key floor(Key key){
//        Node x = floor(root,key);
//        if (x == null) return null;
//        else return x.key;
//    }
//    private Node floor(Node x, Key key) {
//        if (x == null) return null;
//        int cmp = key.compareTo(x.key);
//        if (cmp == 0) return x;
//        if (cmp > 0 ) return floor(x.left,key);
//        Node t = floor(x.right,key);
//        if (t != null) return t;
//        else return x;
//    }

    public Key floor(Key key){
        Node x = root;
        Node y = null;
        int cmp;
        while (x != null){
            cmp = key.compareTo(x.key);
            if (cmp == 0){
                y = x;
                break;
            }
            if (cmp > 0){
                y = x;
                x = x.right;
            }else {
                x = x.left;
            }
        }
        if (y == null) return null;
        else return y.key;
    }

//    public Key seiling(Key key){
//        Node x = seiling(root,key);
//        if (x == null )return null;
//        else return x.key;
//    }
//    private Node seiling(Node x, Key key) {
//        if (x == null) return null;
//        int cmp = key.compareTo(x.key);
//        if (cmp == 0) return x;
//        if (cmp < 0 ) return seiling(x.right,key);
//        Node t = seiling(x.left,key);
//        if (t != null) return t;
//        else return x;
//    }

    public Key ceiling(Key key){
        Node x = root;
        Node y = null;
        int cmp;
        while (x != null){
            cmp = key.compareTo(x.key);
            if (cmp == 0){
                y = x;
                break;
            }
            if (cmp < 0){
                y = x;
                x = x.left;
            }else {
                x = x.right;
            }
        }
        if (y == null) return null;
        else return y.key;
    }

//    public Key select(int k){
//        return select(root,k).key;
//    }
//    private Node select(Node x, int k) {
//        if (x == null) return null;
//        int t = size(x.left);
//        if (k < t) return select(x.left,k);
//        else if (k > t) return select(x.right,k-t-1);
//        else return x;
//    }

    public Key select(int k){
        if (k > size(root)-1 || k < 0)
            throw new IllegalArgumentException("out of size");
        Node x = root;
        int sum = size(x.left);
        while (sum != k){
            if (sum > k){
                x = x.left;
                sum = sum - size(x.right)-1;
            }else {
                x = x.right;
                sum = sum + size(x.left)+1;
            }
        }
        return x.key;
    }

//    public int rank(Key key){
//        return rank(root,key);
//    }
//    private int rank(Node x, Key key) {
//        if (x == null) return 0;
//        int cmp = key.compareTo(x.key);
//        if (cmp < 0) return rank(x.left,key);
//        else if (cmp > 0) return 1 + size(x.left) + rank(x.right,key);
//        else return size(x.left);
//    }

    public int rank(Key key){
        Node x = root;
        int sum = size(x.left);
        int cmp;
        while (x != null){
            cmp = key.compareTo(x.key);
            if (cmp > 0){
                sum = sum + size(x.left) + 1;
                x = x.right;
            }else if (cmp < 0){
                x = x.left;
                if (x != null)
                    sum = sum - size(x.right);
            }else {
                return sum;
            }
        }
        return sum;
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

    public void deleteMax(){
        root = deleteMax(root);
    }
    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key){
        root = delete(root,key);
    }
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left,key);
        else if (cmp > 0) x.right = delete(x.right,key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.left = t.left;
            x.right = deleteMin(t.right);
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<Key> keys(){
        return keys(min(),max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root,queue,lo,hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left,queue,lo,hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right,queue,lo,hi);
    }

    public Key randomKey(){
        int n = StdRandom.uniform(size());
        return select(n);
    }
}
