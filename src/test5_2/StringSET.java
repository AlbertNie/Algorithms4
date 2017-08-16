package test5_2;

import edu.princeton.cs.algs4.Queue;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by albert on 2017/7/21.
 */
public class StringSET {
    private Node root;
    private int size;
    private class Node{
        private char c;
        private Node left,mid,right;
        private boolean flag;
    }

    public void add(String s){
        root = add(root,s,0);
    }

    private Node add(Node x, String s, int d) {
        char c = s.charAt(d);
        if (x == null){
            x = new Node();
            x.c = c;
        }
        if (c > x.c) x.right = add(x.right,s,d);
        else if (c < x.c) x.left = add(x.left,s,d);
        else if (d < s.length()-1) x.mid = add(x.mid,s,d+1);
        else {
            if (x.flag == false)
                size++;
            x.flag = true;
        }
        return x;
    }

    public boolean contains(String key){
        return get(key);
    }

    private boolean get(String key) {
        Node x = get(root,key,0);
        if (x == null) return false;
        return x.flag;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()-1) return x;
        char c = key.charAt(d);
        if (c > x.c) return get(x.right,key,d);
        else if (c < x.c) return get(x.left,key,d);
        else return get(x.mid,key,d+1);
    }

    public void delete(String key){
        root = delete(root,key,0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()-1){
            if (x.flag == true)
                size--;
            x.flag = false;
        }
        else {
            char c = key.charAt(d);
            if (c > x.c) x.right = delete(x.right, key, d);
            else if (c < x.c) x.left = delete(x.left, key, d);
            else x.mid = delete(x.mid, key, d + 1);
        }
        if (x.flag == true) return x;
        if (x.left != null || x.mid != null || x.right != null) return x;
        return null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String s : keys()) {
            result.append(s + " ");
        }
        return result.toString();
    }

    private Queue<String> keys(){
        Queue<String> q = new Queue<>();
        collect(root,"",q);
        return q;
    }

    private void collect(Node x, String s, Queue<String> q) {
        if (x == null) return;
        if (x.flag == true) {
            s = s + x.c;
            q.enqueue(s);
        }
        collect(x.left,s,q);
        collect(x.right,s,q);
        collect(x.mid,s+x.c,q);
    }

    public static void main(String[] args) {
        StringSET stringSET = new StringSET();
        stringSET.add("sadfasf");
        stringSET.add("sadafsd");
        stringSET.add("ssadfasdf");
        stringSET.add("adsfasgdas");
        stringSET.add("adsdsafsdfd");
        System.out.println(stringSET);
        stringSET.delete("sadfasf");
        System.out.println(stringSET.contains("sadfasf"));
        System.out.println(stringSET.size);
        System.out.println(stringSET);

    }

}













