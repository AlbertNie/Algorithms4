package test3_5;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by albert on 2017/6/14.
 * 修改二叉查找树，允许在树中插入重复的键
 * 这里还是使用数组队列把，方便一点
 */
public class BST<Key extends Comparable<Key>,Value>{
    private Node root;

    private class Node {
        private Key key;
        private ArrayList<Value> value;
        private Node right,left;
        private int N;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = new ArrayList<Value>();
            this.value.add(value);
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

    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) return get(x.right,key);
        else if (cmp < 0) return get(x.left,key);
        else{
            Random random = new Random();
            return x.value.get(random.nextInt(x.value.size()));
        }
    }

    public void put(Key key, Value value){
        root = put(root,key,value);
    }
    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key,value,1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left,key,value);
        else if (cmp > 0) x.right = put(x.right,key,value);
        else {
            if (!x.value.contains(value))
                x.value.add(value);
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key max(){
        return max(root).key;
    }
    private Node max(Node x){
        if (x.right == null)
            return x;
        return max(x.right);
    }

    public Key min(){
        return min(root).key;
    }
    private Node min(Node x){
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key floor(Key key){
        Node x = floor(root,key);
        if (x == null) return null;
        else return x.key;
    }
    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0 ) return floor(x.left,key);
        Node t = floor(x.right,key);
        if (t != null) return t;
        else return x;
    }

    public Key seiling(Key key){
        Node x = seiling(root,key);
        if (x == null) return null;
        else return x.key;
    }
    private Node seiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0 ) return seiling(x.right,key);
        Node t = seiling(x.left,key);
        if (t != null) return t;
        else return x;
    }

    public Key select(int k){
        return select(root,k).key;
    }
    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (k < t) return select(x.left,k);
        else if (k > t) return select(x.right,k-t-1);
        else return x;
    }

    public int rank(Key key){
        return rank(root,key);
    }
    private int rank(Node x, Key key) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(x.left,key);
        else if (cmp > 0) return 1+ size(x.left) + rank(x.right,key);
        else return size(x.left);
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
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<Key> keys(){
        return keys(min(),max());
    }

    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> queue = new Queue<Key>();
        keys(root,queue,lo,hi);
        return queue;
    }
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left,queue,lo,hi);
        if (cmplo <= 0 && cmphi >=0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right,queue,lo,hi);
    }

    public int height(){
        return height(root);

    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left),height(x.right));
    }

    public double avgCompares(){
        return ((0.0 + innerWay(root))/size(root)) + 1;
    }
    private int innerWay(Node x) {
        if (x == null) return -1;
        return 2 + innerWay(x.left) + innerWay(x.right);
    }

    public static double optCompares(int N){
        return (N-1)/(Math.ceil(Math.log(N)/Math.log(2)));
    }

    public Key randomKey(){
        int n = StdRandom.uniform(size());
        return select(n);
    }

    //练习题3。2。29
    public boolean isBinaryTree(Node x){
        if (x == null)
            return true;
        if (x.N != size(x.left) + size(x.right))
            return false;
        return isBinaryTree(x.left) && isBinaryTree(x.right);
    }

    //习题3.2.30
    public boolean isOrdered(){
        return isOrdered(root,null,null);
    }
    public boolean isOrdered(Node x, Key min, Key max){
        if (x == null) return true;
        if (min != null && min.compareTo(x.key)<=0) return false;
        if (max != null && max.compareTo(x.key)>=0) return false;
        return isOrdered(x.left,min,x.key) && isOrdered(x.right,x.key,max);
    }

    //习题3。2。31
    public boolean hasNoDuplicates(){
        return hasNoDuplicates(root);
    }
    public boolean hasNoDuplicates(Node x){
        if (x == null) return true;
        if (x.left!=null && x.left.key.compareTo(x.key)==0) return false;
        if (x.right!=null && x.right.key.compareTo(x.key)==0) return false;
        return hasNoDuplicates(x.left) && hasNoDuplicates(x.right);
    }

   //习题3。2。32
    public boolean isBST(Node x){
        if (!isBinaryTree(x)) return false;
        if (!isOrdered(x,null,null)) return false;
        if (!hasNoDuplicates(x)) return false;
        return true;
    }

    //习题3.2.33
    public boolean checkBST(){
        for (int i = 0; i < size()-1; i++) {
            if (i != rank(select(i)))
                return false;
        }
        Key keytest = randomKey();
        if (keytest.compareTo(select(rank(keytest))) != 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        BST<Integer,String> bst = new BST<>();
        bst.put(1,"a");
        bst.put(1,"v");
        bst.put(1,"b");
        bst.put(1,"g");
        bst.put(1,"h");
        bst.put(2,"ad");
        bst.put(3,"ddf");
        bst.delete(2);
        for (int i:bst.keys()) {
            System.out.println(bst.get(i));
        }
    }
}










