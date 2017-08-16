package test5_2;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by albert on 2017/7/20.
 */
public class TST<Value> {
    private Node root;
    private class Node{
        private char c;
        private Node left,mid,right;
        private Value value;
    }
    public Value get(String key){
        if (key.length() == 0)
            throw new IllegalArgumentException("Keys's length must more than 0");
        Node x = get(root,key,0);
        if (x == null) return null;
        return x.value;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        char c = key.charAt(d);
        if (c > x.c) return get(x.right,key,d);
        else if (c < x.c) return get(x.left,key,d);
        else if (d < key.length()-1) return get(x.mid,key,d+1);
        else return x;
    }

    public void put(String key, Value value){
        if (key.length() == 0)
            throw new IllegalArgumentException("Keys's length must more than 0");
        root = put(root,key,value,0);
    }

    private Node put(Node x, String key, Value value, int d) {
        char c = key.charAt(d);
        if (x == null){
            x = new Node();
            x.c = c;
        }
        if (c > x.c) x.right = put(x.right,key,value,d);
        else if (c < x.c) x.left = put(x.left,key,value,d);
        else if (d < key.length()-1) x.mid = put(x.mid,key,value,d+1);
        else x.value = value;
        return x;
    }

    public String longestPrefixOf(String key){
        int length = search(root,key,0,0);
        return key.substring(0,length+1);
    }

    private int search(Node x, String key, int d, int length) {
        if (x == null) return length;
        if (x.value != null) length = d;
        char c = key.charAt(d);
        if (c > x.c) return search(x.right,key,d,length);
        else if (c < x.c) return search(x.left,key,d,length);
        else if (d < key.length()-1) return search(x.mid,key,d+1,length);
        return length;
    }

    public Iterable<String> keysWithPrefix(String key){
        Queue<String> q = new Queue<>();
        Node x = get(root,key,0);
        if (x.value != null) q.enqueue(key);

        collect(x.mid,new StringBuilder(key),q);
        return q;
    }

    private void collect(Node x, StringBuilder pre, Queue<String> q) {
        if (x == null) return;
        collect(x.left,pre,q);
        if (x.value != null){
            q.enqueue(pre.toString()+x.c);//这一步采用加是因为处理左边和右边的叶子节点
        }
        collect(x.mid,pre.append(x.c),q);
        pre.deleteCharAt(pre.length()-1);//这一步去掉最后一个字母是处理完一个字符串后回退的时候删除多余的字符;
        collect(x.right,pre,q);
    }

    public Iterable<String> keysThatMatch(String key){
        Queue<String> q = new Queue<>();
        collect(root,new StringBuilder(),0,key,q);
        return q;
    }

    private void collect(Node x, StringBuilder result, int d, String key, Queue<String> q) {
        if (x == null) return;
        char c = key.charAt(d);
        if (c == '.' || c > x.c) collect(x.right,result,d,key,q);
        if (c == '.' || c == x.c){
            if (d == key.length()-1 && x.value != null) q.enqueue(result.toString() + x.c);
            if (d < key.length()-1){
                collect(x.mid,result.append(x.c),d+1,key,q);
                result.deleteCharAt(result.length()-1);
            }
        }
        if (c == '.' || c < x.c) collect(x.left,result,d,key,q);
    }

    public Iterable<String> keys(){
        Queue<String> q = new Queue<>();
        collect(root,new StringBuilder(),q);
        return q;
    }


    public static void main(String[] args) {
        TST<Integer> tst = new TST<>();
        tst.put("dad",1);
        tst.put("daddafd",1);
        tst.put("ddddafd",1);
        tst.put("adffafd",1);
        tst.put("egsadafd",1);
        //System.out.println(tst.longestPrefixOf("daddafddafdaf"));
        for (String x : tst.keysThatMatch(".......")) {
            System.out.println(x);
        }
    }
}
