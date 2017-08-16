package test5_2;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by albert on 2017/7/20.
 */
public class FTrieST<Value> {
    private static final int R = 256;
    private static Node root;

    private static class Node{
        private Object value;
        private Node[] next = new Node[R];
    }

    public void put(String key, Value value){
       if (root == null) root = new Node();
       int d = 0;
       Node x = root;
       while (d < key.length()){
           char c = key.charAt(d);
           if (x.next[c] == null)
               x.next[c] = new Node();
           x = x.next[c];
           d++;
       }
       x.value = value;
    }

    public Value get(String key){
        Node x = root;
        int d = 0;
        while (d < key.length()){
            char c = key.charAt(d);
            if (x == null) return null;
            x = x.next[c];
            d++;
        }
        return (Value) x.value;
    }

    public void delete(String key){
        Node x = root,y = root;
        int d = 0;
        char a = 0;
        while (d < key.length()){
            if (x == null) return;
            char c = key.charAt(d);
            if (x.value != null){
                a = c;
                y = x;
            }
            x = x.next[c];
            d++;
        }
        for (char c = 0; c < R; c++) {
            if (x.next[c] != null){
                x.value = null;
                return;
            }
        }
        y.next[a] = null;
    }

    public boolean contains(String key){
        if (get(key) != null) return true;
        else return false;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public String longestPrefixOf(String pre){
        if (root == null) return null;
        Node x = root;
        int d = 0,length = 0;
        while (d < pre.length()){
            char c = pre.charAt(d);
            x = x.next[c];
            d++;
            if (x == null) break;
            if (x.value != null){
                length = d;
            }
        }
        return pre.substring(0,length);
    }

    public static void main(String[] args) {
        FTrieST<Integer> fTrieST = new FTrieST();
        fTrieST.put("abc",1);
        fTrieST.put("acd",3);
        fTrieST.put("acdadsfa",5);
        fTrieST.put("acdasa",4);
        fTrieST.put("dsdasa",7);
        fTrieST.delete("acd");
        System.out.println(fTrieST.longestPrefixOf("acdadsfa"));
//        System.out.println(fTrieST.get("acdasa"));
//        System.out.println(fTrieST.get("abc"));
    }
}
