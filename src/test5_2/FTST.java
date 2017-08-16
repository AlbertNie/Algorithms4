package test5_2;

/**
 * Created by albert on 2017/7/21.
 */
public class FTST<Value> {
    private Node root;
    private class Node{
        char c;
        Node left,mid,right;
        Value value;
    }

    public void put(String key, Value value){
        int d = 0;
        if (root == null){
            root = new Node();
            root.c = key.charAt(0);
        }
        Node x = root;
        char c = 0;
        while (d < key.length()){
            c = key.charAt(d);
            if (c > x.c){
                if (x.right == null){
                    x.right = new Node();
                    x.right.c = c;
                }
                x = x.right;
                continue;
            }else if (c < x.c){
                if (x.left == null){
                    x.left = new Node();
                    x.left.c = c;
                }
                x = x.left;
                continue;
            }else {
                if (x.mid == null){
                    x.mid = new Node();
                    x.mid.c = c;
                }
                x = x.mid;
                d++;
            }
            x.value = value;
        }
    }

    public Value get(String key){
        Node x = root;
        int d = 0;
        while (d < key.length()){
            char c = key.charAt(d);
            if (x == null) return null;
            if (c > x.c){
                x = x.right;
                continue;
            }else if (c < x.c){
                x = x.left;
                continue;
            }else {
                x = x.mid;
                d++;
            }
        }
        return x.value;
    }

    public static void main(String[] args) {
        FTST<Integer> ftst = new FTST();
        ftst.put("sdf",1);
        ftst.put("ssff",23);
        ftst.put("asff",256);
        ftst.put("gfa",25);
        System.out.println(ftst.get("gfa"));
    }
}
