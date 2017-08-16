package test5_2;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by albert on 2017/7/20.
 */
public class TrieST<Value> {
    private static final int R = 256;
    private static Nood root;

    private static class Nood{
        private Object value;
        private Nood[] next = new Nood[R];
    }

    public void put(String key, Value value){
        root = put(root,key,value,0);
    }

    private Nood put(Nood x, String key, Value value, int d) {
        if (x == null) x = new Nood();
        if (d == key.length()){
            x.value = value;
            return x;
        }
        char c = key.charAt(d);
        x.next[c]=put(x.next[c],key,value,d+1);
        return x;
    }

    public Value get(String key){
        Nood x = get(root,key,0);
        if (x == null) return null;
        return (Value) x.value;
    }

    private Nood get(Nood x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c],key,d+1);
    }

    public void delete(String key){
        root = delete(root,key,0);
    }

    private Nood delete(Nood x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) x.value = null;
        else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c],key,d+1);
        }
        if (x.value != null) return x;
        for (char c = 0; c < R; c++) {
            if (x.next[c] != null)
                return x;
        }
        return null;
    }

    public boolean contains(String key){
        Nood x = get(root,key,0);
        if (x == null) return false;
        if (x.value == null) return false;
        return true;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public String longestPrefixOf(String s){
        int length = search(root,s,0,0);
        return s.substring(0,length);
    }

    private int search(Nood x, String s, int length, int d) {
        if (x == null) return length;
        if (x.value != null) length = d;
        if (d == s.length()) return length;
        char c = s.charAt(d);
        return search(x.next[c],s,length,d+1);
    }

    public Iterable<String> keysWithPrefix(String pre){
        Queue<String> q = new Queue<>();
        collect(get(root,pre,0),pre,q);
        return q;
    }

    private void collect(Nood x, String pre, Queue<String> q) {
        if (x == null) return;
        if (x.value != null) q.enqueue(pre);
        for (char c = 0; c < R; c++) {
            collect(x.next[c],pre+c,q);
        }
    }

    public Iterable<String> keysThatMatch(String pat){
        Queue<String> q = new Queue<>();
        collect(root,"",pat,q);
        return q;
    }

    private void collect(Nood x, String pre, String pat, Queue<String> q) {
        int d = pre.length();
        if (x == null) return;
        if (d == pat.length() && x.value!=null) q.enqueue(pre);
        if (d == pat.length()) return;
        char next = pat.charAt(d);
        for (char c = 0; c < R; c++) {
            if (next == '.' || next == c)
                collect(x.next[c],pre+c,pat,q);
        }
    }

    //练习5.2.8为TrieST实现floor方法。没找到答案自己写的
    public String floor(String key){
        String re = longestPrefixOf(key);
        if (re.length() == key.length()) return re;
        else{
            char c = key.charAt(re.length());
            if (c > 0)
                c--;
            return floor(get(root,re,0),re,c);
        }
    }

    private String floor(Nood x, String re, char cd) {
        for (char c = cd; c > 0; c--) {
            if (x.next[c] != null)
                return floor(x.next[c],re+c,'ÿ');
        }
        return re;
    }

    public String ceiling(String key){
        String re = longestPrefixOf(key);
        if (re.length() == key.length()) return re;
        else{
            char c = key.charAt(re.length());
            if (c < 255)
                c++;
            return ceiling(get(root,re,0),re,c);
        }
    }

    private String ceiling(Nood x, String re, char cd) {
        for (char c = cd; c <= 255; c++) {
            if (x.next[c] != null)
                return ceiling(x.next[c],re+c,'\u0000');
        }
        return re;
    }

    /**
     * 在第三章中rank是通过节点的计数来实现的，这里的节点没有这个字段
     * @param key
     * @return
     */
    public void rank(String key){

    }

    public int size(){
        Queue<String> q = (Queue<String>) keys();
        return q.size();
    }

    public Iterable<String> keys(){
        return keysWithPrefix("");
    }

    public static void main(String[] args) {
        TrieST<Integer> trieST = new TrieST();
        trieST.put("sdf",3);
        trieST.put("sdfdsfa",3);
        trieST.put("agfga",3);
        trieST.put("fdhgdah",3);
        trieST.put("aaaa",3);
        System.out.println(trieST.ceiling("babb"));
    }

}























