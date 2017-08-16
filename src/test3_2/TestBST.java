package test3_2;

/**
 * Created by albert on 2017/6/16.
 */
public class TestBST {
    public static void main(String[] args) {
        BST<Integer,String> bst = new BST<>();
        bst.put(4,"c");
        bst.put(1,"a");
        bst.put(2,"b");
        bst.put(6,"e");
        bst.put(5,"d");
        bst.put(34,"de");
        bst.put(23,"ddf");
        bst.put(43,"dfd");
        bst.put(13,"ds");
        bst.put(64,"dsfd");
        bst.put(213,"dfd");
        bst.put(65,"dasdf");
        bst.put(1234,"dad");
        bst.put(21,"dad");
        System.out.println(bst.min());
        System.out.println(bst.max());
        System.out.println(bst.floor(3));
        System.out.println(bst.seiling(3));
        System.out.println(bst.select(2));
        System.out.println(bst.rank(4));
        bst.delete(4);
        bst.deleteMin();
        bst.deleteMax();
        for (Integer n: bst.keys()) {
            System.out.println(n);
        }
    }
}
